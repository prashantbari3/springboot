package com.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private BigDecimal amount; 
    private Date  paymentdate;
    private Date feespaid;
   

    // avoid this "No default constructor for entity"
    public Payment() {
    }


    public Payment( BigDecimal amount,Date paymentdate,Date feespaid) {
    	this.amount = amount;
        this.paymentdate = paymentdate;
        this. feespaid =  feespaid;
    }
       

    public BigDecimal getId() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date Paymentdate) {
        this.paymentdate= paymentdate;
    }

    public Date getFeespaid() {
        return feespaid;
    }

    public void setFeespaid(Date feespaid) {
        this.feespaid=feespaid;
    }

   

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", paymentdate='" + paymentdate + '\'' +
                ", feespaid='" + feespaid + '\'' +
                
                '}';
    }

}
