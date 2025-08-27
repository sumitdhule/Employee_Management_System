package com.task.beans;



public class EmployeeData {
	private String name;
	private int id;
	private String adharNumber;
	
	
	
	public EmployeeData(String name, int id, String adharNumber) {
		super();
		this.name = name;
		this.id = id;
		this.adharNumber = adharNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", id=" + id + ", adharNumber=" + adharNumber + "]"+"\n";
	}

	}
	
	

