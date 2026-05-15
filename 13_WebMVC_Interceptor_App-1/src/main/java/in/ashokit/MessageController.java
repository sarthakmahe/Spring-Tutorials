package in.ashokit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MessageController {
	
	@GetMapping("/welcome")
	@ResponseBody
	public String welcomeMsg() {
		return "welcome to ashok it";
	}
	
	@GetMapping("/greet")
	@ResponseBody
	public String greetMsg() {
		return "good evening";
	}
	
	
	

}
