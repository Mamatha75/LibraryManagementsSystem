package com.dxc.pojos;

public class Users {

	private String uName;
	private int uId;
	private String uPassword;
	private String uBookissued;
	private int uBalance;
	private int days;
	
	public Users() {}
    public Users(String uName, int uId, String uPassword, String uBookissued, int uBalance, int days) {
		super();
		this.uName = uName;
		this.uId = uId;
		this.uPassword = uPassword;
		this.uBookissued = uBookissued;
		this.uBalance = uBalance;
		this.days = days;
	}






	public Users(String uName, String uBookissued) {
		super();
		this.uName = uName;
		this.uBookissued = uBookissued;
	}
	
	public Users(String uName, int uBalance) {
		super();
		this.uName = uName;
		this.uBalance = uBalance;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public int getuId() {
		return uId;
	}


	public void setuId(int uId) {
		this.uId = uId;
	}


	public String getuPassword() {
		return uPassword;
	}


	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}


	public String getuBookIssued() {
		return uBookissued;
	}


	public void setuBookIssued(String uBookissued) {
		this.uBookissued = uBookissued;
	}


	public int getuBalance() {
		return uBalance;
	}


	public void setuBalance(int uBalance) {
		this.uBalance = uBalance;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	public void display()
	{
		System.out.println(uName+"\t\t"+uBookissued);
	}
	
	public void show()
	{
		System.out.println(uName+"\t\t"+uBalance);
	}
}
