package com.bank.bankaccount;
import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingBalance;
	private static int numberOfAccounts = 0;
	private static double totalAmount = 0;
	
	public BankAccount() {
		this.accountNumber = generateAccountNumber();
		this.checkingBalance = 0;
		this.savingBalance = 0;
		numberOfAccounts++;
	}
	
	private String generateAccountNumber() {
		String randomAccountNo = "";
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			int num = r.nextInt(10);
			randomAccountNo = randomAccountNo.concat(String.valueOf(num));
		}
		return randomAccountNo;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public void deposit(String accountType, double cash) {
		if(accountType.equals("checking")) {
			checkingBalance += cash;
		} else if (accountType.equals("saving")) {
			savingBalance += cash;
		}
		addTotalAmount(cash);
	}
	
	public void withdraw(String accountType, double cash) {
		if(accountType.equals("checking")) {
			if(checkingBalance >= cash) {
				checkingBalance -= cash;
				addTotalAmount(-cash);
			}
		} else if (accountType.equals("saving")) {
			if(savingBalance >= cash) {
				savingBalance -= cash;
				addTotalAmount(-cash);
			}
		}
	}
	
	public static double getTotalAmount() {
		return totalAmount;
	}

	public static void addTotalAmount(double addAmount) {
		BankAccount.totalAmount += addAmount;
	}

	public static void displayTotal() {
		System.out.println(getTotalAmount());
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
}
