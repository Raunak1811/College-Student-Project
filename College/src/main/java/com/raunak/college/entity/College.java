package com.raunak.college.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long c_id;
	private String c_name;
	private int noOfStud;

	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getNoOfStud() {
		return noOfStud;
	}

	public void setNoOfStud(int noOfStud) {
		this.noOfStud = noOfStud;
	}

	public College(long c_id, String c_name, int noOfStud) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.noOfStud = noOfStud;
	}

	public College() {
		super();
// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "College [c_id=" + c_id + ", c_name=" + c_name + ", noOfStud=" + noOfStud + "]";
	}

}
