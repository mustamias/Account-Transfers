package com.ac.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ac.dao.AccountRepository;
import com.ac.dao.TransferRepository;
import com.ac.entities.Account;
import com.ac.entities.Transfer;
import com.ac.entities.exception.InsufficientAccountBalanceException;
import com.ac.entities.exception.NotFoundException;

@Service

public class AccountModel implements IAccount {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransferRepository transferRepository;
	
	@Autowired
	private Mailsender ms;
	

	@Override
	public Account FindAccount(String name) throws NotFoundException {
		// TODO Auto-generated method stub
		Account account = accountRepository.findOne(name);
		
		if (account==null) throw  new NotFoundException("Account Not Found");
		
		return account;
	}

	@Override
	public List<Account> AllAccount() throws NotFoundException {
		// TODO Auto-generated method stub
		
		List<Account> list_account=accountRepository.findAll();
		
		if (list_account==null) throw  new NotFoundException("No Accounts");
			
		return list_account;
	}

	@Override
	public List<Transfer> FindTransfers(String name) throws NotFoundException {
		// TODO Auto-generated method stub
		List<Transfer> lits_Treansfer=  transferRepository.TransferList(name);
		
		if (lits_Treansfer==null) throw  new NotFoundException("No Tranfers for account ");
		
		return lits_Treansfer;
	}

	
	@Transactional
	@Override
	public void MakeTransfer(String fromAccout, String toAccount, double amount) throws InsufficientAccountBalanceException, NotFoundException {
		// TODO Auto-generated method stub
		
		Account fromAcc , toAcc;
		
		fromAcc=FindAccount(fromAccout);
		toAcc = FindAccount(toAccount);
		
		if (fromAcc.getBalance() < amount || amount < 0)  throw  new InsufficientAccountBalanceException("Insufficient account balance");
		
		Transfer transferFrom,transferTo;
		
		transferFrom = new Transfer(amount, new Date(), "To "+toAccount, "withdraw", fromAcc);
		transferRepository.save(transferFrom);
		fromAcc.setBalance((fromAcc.getBalance()-amount));
		accountRepository.save(fromAcc);
		
		transferTo = new Transfer (amount, new Date(), "From "+fromAccout, "deposit", toAcc);
		transferRepository.save(transferTo);
		toAcc.setBalance((toAcc.getBalance()+amount));
		accountRepository.save(toAcc);
		
		
		
		ms.send("mail", fromAcc.getEmail(), "Transfer Info", "Hello Mr "+fromAcc.getName()+" ,\n\nYour transfer is done .\nBest Reagrds ");
		ms.send("mail", toAcc.getEmail(), "Transfer Info", "Hello Mr "+toAcc.getName()+" ,\n\nYour transfer is done .\nBest Reagrds ");
	}

}
