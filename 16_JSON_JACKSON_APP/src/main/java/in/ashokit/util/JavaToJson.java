package in.ashokit.util;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.binding.Address;
import in.ashokit.binding.Passenger;


import com.google.gson.Gson;


public class JavaToJson {
        
    public static void main(String[] args)throws Exception {
	   
    	//create object for address
    	
    	Address addr=new Address();
    	addr.setCity("kasganj");
    	addr.setState("up");
    	addr.setCountry("india");
    	
    	Passenger pass=new Passenger();
        pass.setName("Sarthak");
        pass.setFrom("Kasganj");
        pass.setTo("Delhi");
        pass.setGender("Male");
        //Set passenger address
        pass.setAddr(addr);
        
    
        
        /*  JACKSON API  
         * 
         * 
       ObjectMapper mapper=new ObjectMapper();
    	//mapper is object like pass addr
    	mapper.writeValue(new File("passeneger.json"), pass);
	*/
        
        Gson gson=new Gson();
        String json = gson.toJson(pass);
        System.out.println(json);
        
        
        
        System.out.println("done.......");
    
    }	
	      
}
