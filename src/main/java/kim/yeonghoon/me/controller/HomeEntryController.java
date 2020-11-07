package kim.yeonghoon.me.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kim.yeonghoon.me.common.bean.PagingBean;
import kim.yeonghoon.me.common.service.IPagingService;
import kim.yeonghoon.me.service.IHomeEntryService;

@Controller
public class HomeEntryController {
	
	@Autowired
	IHomeEntryService iHomeEntryService;
	
	@Autowired
	IPagingService iPagingService; 
	
	@GetMapping("homeEntry")
	public ModelAndView main(@RequestParam HashMap<String,String> params, ModelAndView mav) throws Throwable {
		// 페이지 파라메타가 비어있을 경우(null) 1페이지로 지정
		if(params.get("page") == null) {
			params.put("page", "1");
		}
		// 페이지 이동 시 출입번호 어디서부터 LIMIT를 걸 건지를 지정, 리스트를 몇 개 표시할지 설정
		int listCount = 10;
		int currentPage = Integer.parseInt(params.get("page"));
		params.put("limitStart", Integer.toString((currentPage - 1) * listCount));
		params.put("limitCount", Integer.toString(listCount));
		try {
			// 모든 출입 번호 체크
			int cnt = iHomeEntryService.getNoCnt(params);
			// 페이징 빈 생성
			PagingBean pb = iPagingService.getPageingBean(Integer.parseInt(params.get("page")), cnt, listCount, 5);
			// 계산된 값을 params에 넣음
			params.put("startCnt", Integer.toString(pb.getStartCount()));
			params.put("endCnt", Integer.toString(pb.getEndCount()));
			// 리스트 불러온 후 list에 저장
			List<HashMap<String,String>> list = iHomeEntryService.getNoList(params);
			// 페이징에 필요한 값 map에 저장
			HashMap<String,String> pagingMap = new HashMap<String,String>();
			pagingMap.put("startCnt", Integer.toString(pb.getStartCount()));
			pagingMap.put("endCnt", Integer.toString(pb.getEndCount()));
			pagingMap.put("maxPcount", Integer.toString(pb.getMaxPcount()));
			pagingMap.put("startPcount", Integer.toString(pb.getStartPcount()));
			pagingMap.put("endPcount", Integer.toString(pb.getEndPcount()));
			pagingMap.put("currentPage", params.get("page"));
			// view에 전달할 값 지정
			mav.addObject("list", list);
			mav.addObject("pagingMap", pagingMap);
			mav.addObject("result", "success");
		} catch (Throwable e) {
			e.printStackTrace();
			mav.addObject("result", "fail");
		}
		mav.setViewName("homeEntry/main");
		return mav;
	}
	
	@GetMapping("homeEntry/check")
	public ModelAndView check(ModelAndView mav) throws Throwable {
		try {
			// 마지막 출입번호 체크
			int prevNo = iHomeEntryService.prevNo();
			// 테이블 최초 생성시에는 수치가 0이기 그냥 입실처리
			if(prevNo == 0) {
				iHomeEntryService.insertEntry();
				mav.addObject("result", "in");
			} else {
				// 마지막 출입번호에 퇴실시간이 존재하는지 확인(현재 출입 상태 확인)
				int entryStatus = iHomeEntryService.entryStatus(prevNo);
				// entrySTatus가 0이면 입실처리, 1이면 퇴실처리
				if(entryStatus == 0) {
					iHomeEntryService.insertEntry();
					mav.addObject("result", "in");
				} else if(entryStatus == 1) {
					iHomeEntryService.updateEntry(prevNo);
					mav.addObject("result", "out");
				}
				
			}
		} catch (Throwable e) {
			e.printStackTrace();
			mav.addObject("result", "fail");
		}
		mav.setViewName("homeEntry/result");
		return mav;
	}
}
