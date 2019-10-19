package com.rest;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	
	
    @Id
    @GeneratedValue
    private Long id;
	
	private String schoolId;
	private String studId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String tempAddr;
	private String permAddr;
	private String emailId;
	private String mobileNo;
	private String contactNo;
	private String shortDescr;
	private String longDescr;
	private Date deletedOn;
	
	private long totalAmount;
	private long paidAmount;
	private long balanceAmount;
	
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public long getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(long paidAmount) {
		this.paidAmount = paidAmount;
	}
	public long getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(long balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getStudId() {
		return studId;
	}
	public void setStudId(String studId) {
		this.studId = studId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTempAddr() {
		return tempAddr;
	}
	public void setTempAddr(String tempAddr) {
		this.tempAddr = tempAddr;
	}
	public String getPermAddr() {
		return permAddr;
	}
	public void setPermAddr(String permAddr) {
		this.permAddr = permAddr;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getShortDescr() {
		return shortDescr;
	}
	public void setShortDescr(String shortDescr) {
		this.shortDescr = shortDescr;
	}
	public String getLongDescr() {
		return longDescr;
	}
	public void setLongDescr(String longDescr) {
		this.longDescr = longDescr;
	}
	public Date getDeletedOn() {
		return deletedOn;
	}
	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}
	
	
	public Student() {
		super();
	}
	public Student(String schoolId, String studId, String firstName,
			String middleName, String lastName, String tempAddr,
			String permAddr, String emailId, String mobileNo, String contactNo,
			String shortDescr, String longDescr, Date deletedOn,
			long totalAmount, long paidAmount, long balanceAmount) {
		super();
	
		this.schoolId = schoolId;
		this.studId = studId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.tempAddr = tempAddr;
		this.permAddr = permAddr;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.contactNo = contactNo;
		this.shortDescr = shortDescr;
		this.longDescr = longDescr;
		this.deletedOn = deletedOn;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.balanceAmount = balanceAmount;
	}
	@Override
	public String toString() {
		return "Student {id=" + id + ", schoolId=" + schoolId + ", studId="
				+ studId + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", tempAddr="
				+ tempAddr + ", permAddr=" + permAddr + ", emailId=" + emailId
				+ ", mobileNo=" + mobileNo + ", contactNo=" + contactNo
				+ ", shortDescr=" + shortDescr + ", longDescr=" + longDescr
				+ ", deletedOn=" + deletedOn + ", totalAmount=" + totalAmount
				+ ", paidAmount=" + paidAmount + ", balanceAmount="
				+ balanceAmount + "}";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
