package in.ashokit.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import in.ashokit.binding.Address;
import in.ashokit.binding.Person;

public class MarshallDemo {
    
	 public static void main(String[] args) throws Exception {
		
		 Address addr=new Address();
		 addr.setCity("kasganj");
		 addr.setCountry("india");
         addr.setState("up");		 
		 
		 
		 Person p=new Person();
		 p.setId(101);
		 p.setName("sarthak");
		 p.setGender("male");
		 p.setEmail("sart@gmail.com");
		 p.setAddr(addr);
		 
		JAXBContext context = JAXBContext.newInstance(Person.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(p, new File("person.xml"));
	
		
		System.out.println("done......."); 
	}
	
}
