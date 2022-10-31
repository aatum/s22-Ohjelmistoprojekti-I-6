package hh.s22ohjelmistoprojekti1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClothController {

	@GetMapping("clothelist")
	public String showclothers(Model model) {
		model.addAttribute("Books", clothRepository.findAll());
		return "clothelist";
	}
	
}
