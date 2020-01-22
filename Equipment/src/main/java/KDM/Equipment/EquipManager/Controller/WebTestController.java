package KDM.Equipment.EquipManager.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebTestController {
	
	@GetMapping("/test")
	public String test() {
		return "Hello World!";
	}
	
}
