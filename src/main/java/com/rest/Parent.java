package com.rest;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parent implements Serializable{
	
    @Id
    @GeneratedValue
    private Long id;

	private String schoolId;
	private String parentId;
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
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
	
	
	
	public Parent() {
		super();
	}
	public Parent(Long id, String schoolId, String parentId, String firstName,
			String middleName, String lastName, String tempAddr,
			String permAddr, String emailId, String mobileNo, String contactNo,
			String shortDescr, String longDescr, Date deletedOn) {
		super();
		this.id = id;
		this.schoolId = schoolId;
		this.parentId = parentId;
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
	}
	
	
}
