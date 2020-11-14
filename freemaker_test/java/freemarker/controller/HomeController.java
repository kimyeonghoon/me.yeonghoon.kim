package freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "freemarker home title");
		model.addAttribute("content", "<a href=\"jobApply\">입사지원</a>");
		return "home";
	}
	
}
