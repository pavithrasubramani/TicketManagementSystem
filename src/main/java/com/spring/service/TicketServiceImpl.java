package com.spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.dao.TicketDAO;
import com.spring.model.Ticket;
import com.spring.model.TicketHistory;

@Service
public class TicketServiceImpl implements TicketService {
		
		private TicketDAO ticketDAO;

		@Autowired
		public void setTicketDAO(TicketDAO ticketDAO) {
			this.ticketDAO = ticketDAO;
		}
		@Override
		@Transactional
		public void addTicket(Ticket t) {
			
	       this.ticketDAO.addTicket(t);
			
		}
		
		private Object getTicketHistory() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		@Transactional
		public List<Ticket> listTicket() {
			return this.ticketDAO.listTickets();
		}
		@Override
		public void updateTicket(Ticket t) {
			
				this.ticketDAO.updateTicket(t);
			}
    	@Override
		public Ticket getTicketById(int id) {
			
				return this.ticketDAO.getTicketById(id);
			}	
		}