package com.spring.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "s_id", nullable = false)
	private Student s;
	
    @OneToMany(cascade=CascadeType.ALL)
	private List<TicketHistory> ticketHistory;
	 
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Student getS() {
		return s;
	}
     public void setS(Student s) {
		this.s = s;
	}
	
	
   public List<TicketHistory> getTicketHistory() {
		return ticketHistory;
	}

	public void setTicketHistory(List<TicketHistory> ticketHistory) {
		this.ticketHistory = ticketHistory;
	}

	@Override
	public String toString(){
		return "id="+id+", title="+title+", description="+description;
	}
	}
