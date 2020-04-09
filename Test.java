package com.bank.bankaccount;

public class Test {

	public static void main(String[] args) {
		BankAccount b1 = new BankAccount();
		b1.deposit("checking", 1000);
		b1.deposit("saving", 500);
		b1.withdraw("checking", 200);
		b1.withdraw("saving", 501);
		System.out.println(b1.getCheckingBalance());
		System.out.println(b1.getSavingBalance());
		BankAccount.displayTotal();
		System.out.println(b1.getAccountNumber());
	}

}
