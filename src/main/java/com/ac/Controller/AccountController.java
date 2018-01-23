package com.ac.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ac.entities.Account;
import com.ac.entities.Transfer;
import com.ac.entities.exception.InsufficientAccountBalanceException;
import com.ac.entities.exception.NotFoundException;
import com.ac.model.IAccount;


@Controller
public class AccountController {
	
	@Autowired
	private IAccount iAccount;
	
	
	@RequestMapping("/account")
	public String index( Model model) {
		
	try {
			List<Account> accounts = iAccount.AllAccount();
			model.addAttribute("list", accounts);
			
		} catch (Exception e) {
		 
			model.addAttribute("ex", e);
			
		}
		return "account";
	}
	
	@RequestMapping("transfers")
	public String Transfers(Model model,String par) {
		
	
		
	try {
		List<Transfer> list_transfers=	iAccount.FindTransfers(par);
		model.addAttribute("transfers",list_transfers);
		model.addAttribute("account",iAccount.FindAccount(par));
		model.addAttribute("list", iAccount.AllAccount());
		
	} catch (NotFoundException e) {
		// TODO Auto-generated catch block
		model.addAttribute("ex",e);
		System.out.println("----------- "+e.getMessage());
	}
		
		
		return "account";
	}
	
	
	@RequestMapping("/pay")
	public String pay() {
		
		
		return"pay";
	}
	
	@RequestMapping(value= "/pay" , method=RequestMethod.POST)
	public String payreq(Model model, String from,String to, double amount) {
		String ex3="Transfer Successfully";
		try {
			System.out.println("---------------------------- "+from);
			System.out.println("---------------------------- "+to);
			System.out.println("---------------------------- "+amount);
			
			iAccount.MakeTransfer(from, to, amount);
			model.addAttribute("ex3", "Transfer Successfully");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			model.addAttribute("ex1", e);
		} 
	
		//return "redirect:/pay?ex3="+ex3;
		return "pay";
	}
	
	
}
