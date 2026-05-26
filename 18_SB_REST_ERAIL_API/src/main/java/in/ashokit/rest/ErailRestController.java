package in.ashokit.rest;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.request.Passenger;
import in.ashokit.response.Ticket;


@RestController
public class ErailRestController {

	
	private Map<Integer,Ticket> tickets=new HashMap<>();
 
	@PostMapping(
			value="/ticket",
            consumes= {"application/xml","application/json"},
            produces= {"application/xml","application/json"}
			)
	public Ticket bookTicket(@RequestBody Passenger passenger) {
		
		
		Random r=new Random();
		int ticketId = r.nextInt();
	
		//logic to book ticket
		Ticket t=new Ticket();
		t.setTicketId(ticketId);
		t.setFrom(passenger.getFrom());
		t.setTo(passenger.getTo());
		t.setTktCost("500.00 INR");
		t.setTrainNum(passenger.getTrainNum());
		t.setTicketStatus("Confirmed");
		
		tickets.put(ticketId,t);
		
		
		return t;
	}
	      //2.  GET REQUEST
	
	       @GetMapping(
			value="/ticket/{ticketId}",
			produces= {"application/xml","application/json"}
		    )
	        public Ticket getTicket(@PathVariable Integer ticketId) {
 		    //logic to get from DB
		System.out.println(tickets);
           if(tickets.containsKey(ticketId)) {
	       return tickets.get(ticketId); 
           }
		
          return null;
		
	}
}
