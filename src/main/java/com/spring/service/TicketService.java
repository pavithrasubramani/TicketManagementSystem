package com.spring.service;
import java.util.List;
import com.spring.model.Ticket;



public interface TicketService {
	
	 void addTicket(Ticket t);
	 List<Ticket> listTicket();
	 void updateTicket(Ticket t);
	 Ticket getTicketById(int id);
		
	}
