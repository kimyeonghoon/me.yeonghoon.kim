package kim.yeonghoon.me.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kim.yeonghoon.me.common.service.IPagingService;
import kim.yeonghoon.me.service.IJobApplyService;


@Controller
public class JobApplyController {

	@Autowired
	IJobApplyService iJobApplyService;
	
	@Autowired
	IPagingService iPagingService; 
	
	@GetMapping("jobApply")
	public ModelAndView main(@RequestParam HashMap<String,String> params, ModelAndView mav) throws Throwable {
		mav.setViewName("jobApply/main");
		return mav;
	}
	
}
