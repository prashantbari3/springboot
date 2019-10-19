package com.rest;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Installment {
	@Id
    @GeneratedValue
    private Long id;
	
	private BigDecimal  amount;
	private Date sheduledDate;
	private Date paymentdate;
	private String  status;
	
	
	
	public Installment() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public Date getSheduledDate() {
		return sheduledDate;
	}


	public void setSheduledDate(Date sheduledDate) {
		this.sheduledDate = sheduledDate;
	}


	public Date getPaymentdate() {
		return paymentdate;
	}


	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Installment(Long id, BigDecimal amount, Date sheduledDate,
			Date paymentdate, String status) {
		super();
		this.id = id;
		this.amount = amount;
		this.sheduledDate = sheduledDate;
		this.paymentdate = paymentdate;
		this.status = status;
	}


	public Installment(BigDecimal amount, Date sheduledDate, Date paymentdate,
			String status) {
		super();
		this.amount = amount;
		this.sheduledDate = sheduledDate;
		this.paymentdate = paymentdate;
		this.status = status;
	}


	@Override
	public String toString() {
		return "Installment [id=" + id + ", amount=" + amount
				+ ", sheduledDate=" + sheduledDate + ", paymentdate="
				+ paymentdate + ", status=" + status + "]";
	}
	
	
	
	

}
