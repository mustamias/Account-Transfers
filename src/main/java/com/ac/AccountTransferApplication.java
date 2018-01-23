package com.ac;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ac.dao.AccountRepository;
import com.ac.dao.TransferRepository;
import com.ac.entities.Account;
import com.ac.entities.Transfer;
import com.ac.model.IAccount;

@SpringBootApplication
public class AccountTransferApplication implements CommandLineRunner {
	
	@Autowired
	private AccountRepository account;
	
	@Autowired
	private TransferRepository transfer;
	
	@Autowired
	private IAccount iAccount;

	public static void main(String[] args) {
		SpringApplication.run(AccountTransferApplication.class, args);
	}
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Account acount1=account.save(new Account("Mustapha", 200.0, "emil@email.fr"));
		Account acount2=account.save(new Account("husten", 200.0, "emil@email.fr"));
		Account acount3=account.save(new Account("Adam", 200.0, "emil@email.fr"));
		
		iAccount.MakeTransfer(acount1.getName(), acount2.getName(), 25);
		iAccount.MakeTransfer(acount2.getName(), acount1.getName(), 33.5);
		
		

		
		
	}
}
