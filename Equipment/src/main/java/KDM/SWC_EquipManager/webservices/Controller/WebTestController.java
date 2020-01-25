package KDM.SWC_EquipManager.webservices.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebTestController {
	
	@GetMapping("/signUp")
	public String index() {
		return "SignUp";
	}
	
	@GetMapping("/")
	public String studentNum() {
		return "SignIn";
	}
	
}
