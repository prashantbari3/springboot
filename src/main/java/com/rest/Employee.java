package com.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
  
    private String firstName;
    private String lastName;
    private int empId;
    private String mobileNo;

    // avoid this "No default constructor for entity"
    public Employee() {
    }

 

    public Employee(Long id, String firstName, String lastName, int empId,
			String mobileNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
		this.mobileNo = mobileNo;
	}




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    
    public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getEmpId() {
		return empId;
	}



	public void setEmpId(int empId) {
		this.empId = empId;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", empId=" + empId + ", mobileNo="
				+ mobileNo + "]";
	}





}
