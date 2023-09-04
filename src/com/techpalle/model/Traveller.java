package com.techpalle.model;

public class Traveller 
{
	private String name;
	private String email;
	private long mobile;
	private String address;
	private String date;
	private String from;
	private String to;
	public int getid;
	
	
	
	public int getGetid() {
		return getid;
	}
	public void setGetid(int getid) {
		this.getid = getid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Traveller(String name, String email, long mobile, String address, String date, String from, String to) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.date = date;
		this.from = from;
		this.to = to;
	}
	public Traveller(String name, String email, long mobile, String address, String date, String from, String to,
			int getid) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.date = date;
		this.from = from;
		this.to = to;
		this.getid = getid;
	}
	
	
}
