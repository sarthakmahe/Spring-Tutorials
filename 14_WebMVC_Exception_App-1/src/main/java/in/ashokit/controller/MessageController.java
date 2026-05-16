package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

	
	  @GetMapping("/welcome")
	  @ResponseBody
	  public String getWelcomeMsg() {
		  String msg="Welcome to ashok it";
		  /*
		  try {
		        int i=10/0;
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  */
		  int i=10/0;
          return msg;
	  }
	  
	  @GetMapping("/greet")
	  @ResponseBody
	  public String getGreetMsg(){
		  String msg="good evening";
		  String s=null;
		  try {
		  s.length();
		  }catch(Exception e) {
		   e.printStackTrace();
		  }
		  return msg;
	  }
	  
	     @ExceptionHandler(value=ArithmeticException.class)
     	 public ModelAndView handleAE(ArithmeticException ex) {
	
     	 String msg=ex.getMessage();
		 
		 ModelAndView mav=new ModelAndView();
		 mav.setViewName("error") ;
		
		 return mav;
	 }
}
