package com.ac.model;

import java.util.List;

import com.ac.entities.Account;
import com.ac.entities.Transfer;
import com.ac.entities.exception.InsufficientAccountBalanceException;
import com.ac.entities.exception.NotFoundException;

public interface IAccount {
	
	public Account FindAccount(String name)throws NotFoundException;
	public List<Account> AllAccount() throws NotFoundException;
	public List<Transfer> FindTransfers(String name)throws NotFoundException;
	public void MakeTransfer  (String fromAccout, String toAccount,double amount) throws InsufficientAccountBalanceException, NotFoundException;

}
