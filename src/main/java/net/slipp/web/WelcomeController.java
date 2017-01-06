package net.slipp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/helloworld")
	public String welcome(Model model){

		model.addAttribute("name", "javajigi");
		model.addAttribute("age", 10000);
		model.addAttribute("company", "<b>GitHub</b>");
		model.addAttribute("in_ca", true);
		return "welcome";
	}
}
