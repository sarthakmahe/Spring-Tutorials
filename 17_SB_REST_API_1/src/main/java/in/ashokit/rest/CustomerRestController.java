package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Customer;

@RestController
public class CustomerRestController {
     
	 @GetMapping("/customer")
	 public Customer getCustomer() {
		 
		 Customer c=new Customer();
		 c.setName("sarthak");
		 c.setGender("male");
		 c.setEmail("sart123@gmail.com");
		 
		 return c;
	 }
	
	
	  
}
