package com.spring.dao;
import java.util.List;

import com.spring.model.Ticket;

public interface TicketDAO {
	
	 void addTicket(Ticket t);
	 
	 List<Ticket> listTickets();
	 
	 void updateTicket(Ticket t);
	 
	 Ticket getTicketById(int id);
}
