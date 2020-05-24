package com.luv2code.springdemo.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email")
	private String email;

	@Column(name="staff_id")
	private int staffId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="staff_id", insertable = false, updatable = false)
	private Staff staff;

	
	public Customer() {
		
	}	
	
	public Customer(String firstname, String lastname, String email, int staffId, Staff staff) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.staffId = staffId;
		this.staff = staff;
	}

	public Staff getStaff() {
		return staff;
	}

	public int getStaff_id() {
		return staffId;
	}

	public void setStaff_id(int staffId) {
		this.staffId = staffId;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [staff=" + staff + ", id=" + id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", staffId=" + staffId + "]";
	}

	

		
	
}
