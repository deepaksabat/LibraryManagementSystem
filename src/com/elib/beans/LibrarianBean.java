package com.elib.beans;
public class LibrarianBean {
	
	private int id;
	private String name,email,password;
	private long mobiel;
	
	public LibrarianBean(){
		
	}
	public LibrarianBean(int id, String name,String email,String password,long mobiel){
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobiel = mobiel;
		
	}
	
	public LibrarianBean(String name, String email, String password, long mobiel) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobiel = mobiel;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public long getMobiel()
	{
		return mobiel;
	}
	public void setMobiel(long mobiel)
	{
		this.mobiel = mobiel;
	}
	
	

}
