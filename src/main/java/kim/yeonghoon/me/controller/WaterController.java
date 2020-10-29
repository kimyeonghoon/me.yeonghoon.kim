package kim.yeonghoon.me.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import kim.yeonghoon.me.service.IWaterService;


@Controller
public class WaterController {

	
	@Autowired
	IWaterService iWaterService;
	
	/**
	 * 메인 페이지(get으로 접근) 
	 */
	@GetMapping("water")
	public String main() {
		return "water/main";
	}
	
	
	/**
	 * 메인 페이지 접근 시 리스트 불러오기. 페이징은 나중에 필요하다면 만들 생각.
	 */
	@PostMapping(value = "water/waterSelectList", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String main(ModelAndView mav) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			List<HashMap<String,String>> list = iWaterService.selectList();
			modelMap.put("list", list);
			modelMap.put("result", "success");
		} catch (Throwable e) {
			e.printStackTrace();
			modelMap.put("result", "fail");
		}
		return mapper.writeValueAsString(modelMap);
	}
	
	
	/**
	 * 필터 사용 횟수 카운트(post로 던짐)
	 */
	@PostMapping(value = "water", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String useFilter(@RequestParam HashMap<String,String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			int cnt = iWaterService.countUp(params);
			if(cnt > 0) {
				iWaterService.countTime(params);
				modelMap.put("result", "success");
			} else {
				modelMap.put("result", "fail");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			modelMap.put("result", "fail");
		}
		return mapper.writeValueAsString(modelMap);
	}

	
	/**
	 * 필터 상세 정보 페이지(기본) 
	 */
	@GetMapping("water/detail")
	public String detail() {
		return "water/detail";
	}
	
	
	/**
	 * 필터 상세 정보 페이지(Pathvariable)
	 */
	@GetMapping("water/{id}")
	public ModelAndView detail(@PathVariable String id, ModelAndView mav) {
		mav.addObject(id);
		mav.setViewName("water/detail");
		return mav;
	}
	

	/**
	 * 선택한 필터의 상세 정보 불러오는 기능(post)
	 */
	@PostMapping(value = "water/selectFilter", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String selectFilter(@RequestParam HashMap<String,String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			HashMap<String,String> selectFilter = iWaterService.selectFilter(params);
			List<HashMap<String,String>> timeFilter = iWaterService.timeFilter(params);
			modelMap.put("list", selectFilter);
			modelMap.put("timeFilter", timeFilter);
			modelMap.put("result", "success");
		} catch (Throwable e) {
			e.printStackTrace();
			modelMap.put("result", "fail");
		}
		System.out.println(mapper.writeValueAsString(modelMap));
		return mapper.writeValueAsString(modelMap);
	}
	
	
	/**
	 * 필터 교체 기능
	 */
	@PostMapping(value = "water/filterReplace", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String filterReplace(@RequestParam HashMap<String,String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int newNo = Integer.parseInt(params.get("id")) + 1;
		params.put("selectNo", Integer.toString(newNo));
		try {
			int filterEnd = iWaterService.filterEnd(params);
			int filterReplace = iWaterService.filterReplace(params);
			iWaterService.countTime(params);
			if(filterEnd + filterReplace >= 2) {
				modelMap.put("result", "success");
			} else {
				modelMap.put("result", "fail");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			modelMap.put("result", "fail");
		}
		System.out.println(mapper.writeValueAsString(modelMap));
		return mapper.writeValueAsString(modelMap);
	}
}