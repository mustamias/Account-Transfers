package com.ac.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@SuppressWarnings("serial")
@Entity
public class Account implements Serializable {
	
	
	@Id
	private String name;
	//@Column(columnDefinition="double precision default '200.0'")
	private double balance;
	private String email;
	
	@OneToMany(mappedBy="account", fetch=FetchType.LAZY)

	private Collection<Transfer> transfers;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(String name, double balance, String email) {
		super();
		this.name = name;
		this.balance = balance;
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Collection<Transfer> getTransfers() {
		return transfers;
	}


	public void setTransfers(Collection<Transfer> transfers) {
		this.transfers = transfers;
	}
	
	

}
