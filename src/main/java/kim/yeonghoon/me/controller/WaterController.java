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
	
	
	@GetMapping("/water")
	public String main() {
		return "/water/main";
	}
	
	
	@PostMapping(value = "/waterSelectList", produces = "text/json;charset=UTF-8")
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

	
	@GetMapping("/water/{id}")
	public ModelAndView detail(@PathVariable String id, ModelAndView mav) {
		mav.addObject(id);
		mav.setViewName("/water/detail");
		return mav;
	}
	
	
	@GetMapping("/water/detail")
	public String detail() {
		return "/water/detail";
	}
	
	
	@PostMapping(value = "/water", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String filterReplace(@RequestParam HashMap<String,String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			int cnt = iWaterService.countUp(params);
			if(cnt > 0) {
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

}
