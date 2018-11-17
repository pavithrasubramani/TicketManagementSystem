package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

    @Entity
	@Table(name="history_of_ticket")
	public class TicketHistory {
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
	
		@JoinColumn(name="s_id")
		@ManyToOne(fetch=FetchType.LAZY)
		private Student s_id;
		
		@Column(name="e_id")
		private Integer employee;
		
		@Column(name="status")
		private String status;

		@Column(name="comments")
		private String comments;
		
		@Column(name="created_on")
	    private String  createdon;
		
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="t_id", nullable = false)
		private Ticket tk;
	    
	   public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public Student getS_id() {
			return s_id;
		}
		public void setS_id(Student s_id) {
			this.s_id = s_id;
		}
		public Integer getEmployee() {
			return employee;
		}
		public void setEmployee(Integer employee) {
			this.employee = employee;
		}
		public Ticket getTk() {
			return tk;
		}
		public void setTk(Ticket tk) {
			this.tk = tk;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public String getCreatedon() {
			return createdon;
		}
		public void setCreatedon(String createdon) {
			this.createdon = createdon;
		}

		
		
		
		
		@Override
		public String toString(){
		
			return "id="+id+", e_id="+employee+", status="+status+",comments="+comments+",createdon="+createdon;
		}
}
