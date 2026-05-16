package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	 @GetMapping("/demo")
	  @ResponseBody
	  public String getDemoMsg(){
		  String msg="good evening";
		  String s=null;
		  try {
		  s.length();
		  }catch(Exception e) {
		   e.printStackTrace();
		  }
		  return msg;
	  }
}
