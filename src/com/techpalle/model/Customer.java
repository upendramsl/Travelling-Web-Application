package com.techpalle.model;

public class Customer
{
	private int id;
	private String name;
	private String email;
	private long mobile;
	private String password;
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Customer(String name, String email, long mobile, String password) 
	{
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	public Customer(int i, String n, String e, long m)
	{
		this.id=i;
		this.name = n;
		this.email = e;
		this.mobile = m;
		
	}
	public int getId() 
	{
		// TODO Auto-generated method stub
		return 0;
	}
	

}
