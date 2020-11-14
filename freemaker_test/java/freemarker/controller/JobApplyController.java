package freemarker.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
		
		System.out.println(mav);
		mav.setViewName("jobApply/main");
		return mav;
	}
}
