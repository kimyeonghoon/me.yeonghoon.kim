package freemarker.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import freemarker.service.IJobApplyService;


@Controller
public class JobApplyController {

	@Autowired
	IJobApplyService iJobApplyService;
	
	@GetMapping("jobApply")
	public ModelAndView main(ModelAndView mav) throws Throwable {
		try {
			List<HashMap<String, String>> list = iJobApplyService.list();
			mav.addObject("list", list);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		mav.setViewName("jobApply/main");
		return mav;
	}
	
	@PostMapping(value = "jobAdd", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String jobApply(ModelAndView mav, @RequestParam HashMap<String,String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			System.out.println(params);
			if(params.get("companyName").isEmpty() || params.get("announceName").isEmpty() || params.get("companyName") == null || params.get("announceName") == null) {
				modelMap.put("result", "null");
			} else {
				iJobApplyService.jobAdd(params);
				modelMap.put("result", "success");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			modelMap.put("result", "fail");
		}
		return mapper.writeValueAsString(modelMap);
	}
}
