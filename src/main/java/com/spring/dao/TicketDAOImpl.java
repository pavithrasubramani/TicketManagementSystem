package com.spring.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.model.Ticket;
import com.spring.model.TicketHistory;


@Repository
public class TicketDAOImpl implements TicketDAO {
	
	private static final Logger logger = LoggerFactory.logger(TicketDAOImpl.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	public List<Ticket> listTickets() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Ticket> ticketList = (List<Ticket>) session.createQuery("from Ticket t").list();
		for(Ticket t : ticketList){
			logger.info("Ticket List::"+t);
		}
		return ticketList;
	}
	@Override
	public void addTicket(Ticket t) {
		Session session = this.sessionFactory.getCurrentSession();
		for (TicketHistory ticketHistory : t.getTicketHistory()) {
		 ticketHistory.setTk(t);	
		}
		session.persist(t);
		logger.info("Ticket saved successfully, Ticket Details="+t);
	}

	@Override
	public void updateTicket(Ticket t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Tickets updated successfully, Ticket Details="+t);
	}
	
	
	@Override
	public Ticket getTicketById(int id) {
	        Session session = this.sessionFactory.getCurrentSession();		
			Ticket t = (Ticket) session.load(Ticket.class, new Integer(id));
			logger.info("Ticket loaded successfully, Ticket details="+t);
			return t;
		}
		
		
	}