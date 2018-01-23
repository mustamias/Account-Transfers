package com.ac.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Transfer implements Serializable {
	
	@Id  @GeneratedValue
	private long id_transfer;
	private double amount;
	private Date date_transfer;
	private String FromOrTO;
	private String type_transfer;
	
	@ManyToOne
	private Account account;

	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getType_transfer() {
		return type_transfer;
	}


	public void setType_transfer(String type_transfer) {
		this.type_transfer = type_transfer;
	}


	public Transfer(double amount, Date date_transfer, String fromOrTO, String type_transfer, Account account) {
		super();
		this.amount = amount;
		this.date_transfer = date_transfer;
		FromOrTO = fromOrTO;
		this.type_transfer = type_transfer;
		this.account = account;
	}









	public String getFromOrTO() {
		return FromOrTO;
	}




	public void setFromOrTO(String fromOrTO) {
		FromOrTO = fromOrTO;
	}




	public long getId_transfer() {
		return id_transfer;
	}

	public void setId_transfer(long id_transfer) {
		this.id_transfer = id_transfer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate_transfer() {
		return date_transfer;
	}

	public void setDate_transfer(Date date_transfer) {
		this.date_transfer = date_transfer;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	

}
