package com.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Ticket;
import com.spring.service.TicketService;

@RestController
public class TicketController {

	private TicketService ticketService;
		
		@Autowired(required=true)
		@Qualifier(value="ticketService")
		public void setTicketService(TicketService ts){
			this.ticketService = ts;
		}
		

		
		@RequestMapping(value = "/tickets", method = RequestMethod.GET, produces="application/json")
		public @ResponseBody List<Ticket> listTicket() {
			List<Ticket> ticket=this.ticketService.listTicket();
			return ticket;
		}
		
	
		@RequestMapping(value= "/ticket/add", method = RequestMethod.POST,produces="application/json")
		public String addTicket(@RequestBody Ticket t){
        if(t.getId() == 0){
				
				this.ticketService.addTicket(t);
				}
       else{
	
	            this.ticketService.updateTicket(t);			
	
            }
			
		return "ticket";
		}
	}
