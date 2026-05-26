package in.ashokit.util;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import in.ashokit.binding.Passenger;
public class JsonToJava {
    
	public static void main(String[] args) throws Exception{
		/*
		 * ObjectMapper mapper=new ObjectMapper();
		Passenger passe = mapper.readValue(new File("passeneger.json"), Passenger.class );
	
	    System.out.println(passe);
	    */
		
		
		
	Gson gson=new Gson();
	FileReader reader = new FileReader("passeneger.json");
	Passenger passe= gson.fromJson(reader, Passenger.class);	
	System.out.println(passe);
	}
	
}
