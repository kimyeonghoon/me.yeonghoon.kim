package kim.yeonghoon.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kim.yeonghoon.me.service.IHomeEntryService;

@Controller
public class HomeEntry {
	
	@Autowired
	IHomeEntryService iHomeEntryService;
	
	@GetMapping("homeEntry")
	public String main() {
		return "homeEntry/main";
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
