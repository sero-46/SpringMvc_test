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
@Table(name="staff")
public class Staff {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stf_id")
	private int stfIid;	
	
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="staff_name")
	private String staff_name;
	

	public Staff() {
	}

	public long getStfIid() {
		return stfIid;
	}

	public void setStfIid(int stfIid) {
		this.stfIid = stfIid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	
	public Staff(String city, String state, String staff_name) {
		this.city = city;
		this.state = state;
		this.staff_name = staff_name;
	}

	@Override
	public String toString() {
		return "Staff [stfIid=" + stfIid + ", city=" + city + ", state=" + state + ", staff_name=" + staff_name + "]";
	}

	
}