package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashokit.binding.Product;

@Controller
public class MessageController {
	
	  @GetMapping("/welcome")
      public String getWelcomeMsg(Model model) {
    	  
      model.addAttribute("msg","Welcome to Thymeleaf");
      model.addAttribute("product", new Product());
      return "index";
      
      
      }
}
