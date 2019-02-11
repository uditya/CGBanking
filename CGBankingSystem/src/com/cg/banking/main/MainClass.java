package com.cg.banking.main;

import java.util.Scanner;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {
	public static void main(String[] args) {
		BankingServices bankingServices=new BankingServicesImpl();
		Scanner sc = new Scanner(System.in);
		int choice=0,pinNumber;
		float amount;
		long accountNo,toAccountNo,fromAccountNo;
		Account account;
		String accountType;
		try {
			do { 
				System.out.println("***********************************\n\n1. Open Account \n2. Deposit Amount \n3. Withdraw Amount \n4. Fund Transfer \n5. Get Account Details \n6. Get All Accounts Detail \n7. Get Account All transactions Details \n8. Get Account Status \n9. Exit \n****--------Now Enter Values---------***");
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1:
					System.out.print("Enter account Type : ");
					accountType = sc.nextLine();
					System.out.print("Enter Initial balance : ");
					amount = sc.nextInt();
					account = bankingServices.openAccount(accountType, amount);
					System.out.println("Account Opened Successfully \nAccount Number : "+account.getAccountNo()+" \nPin number : "+account.getPinNumber()+" \nAvailable balance : "+account.getAccountBalance());
					break;
				case 2:
					System.out.print("Enter account number : ");
					accountNo = sc.nextLong();
					System.out.println("Enter amount to deposit : ");
					amount = sc.nextFloat();
					System.out.println("Your Current Account Balance is: "+bankingServices.depositAmount(accountNo, amount));
					break;
				case 3:
					System.out.print("Enter account number : ");
					accountNo = sc.nextLong();
					System.out.println("Enter amount to withdraw : ");
					amount = sc.nextFloat();
					System.out.println("Enter your pinNumber : ");
					pinNumber = sc.nextInt();
					System.out.println("Your Current Account Balance is: "+bankingServices.withdrawAmount(accountNo, amount, pinNumber));
					break;
				case 4:
					System.out.print("Enter your account number : ");
					fromAccountNo = sc.nextLong();
					System.out.print("Enter receiver account number : ");
					toAccountNo= sc.nextLong();
					System.out.print("Enter your transfer amount : ");
					amount = sc.nextFloat();
					System.out.println("Enter your pinNumber : ");
					pinNumber = sc.nextInt();
					if(bankingServices.fundTransfer(toAccountNo, fromAccountNo, amount, pinNumber))
						System.out.println("Funds transferred successfully.");
					break;
				case 5:
					System.out.print("Enter account number : ");
					accountNo = sc.nextLong();
					System.out.println(bankingServices.getAccountDetails(accountNo).toString());
					break;
				case 6:
					System.out.println("All Accounts Details");
					System.out.println(bankingServices.getAllAccountDetails());
					break;
				case 7:
					System.out.print("Enter account number : ");
					accountNo = sc.nextLong();
					System.out.println(bankingServices.getAccountAllTransaction(accountNo));
					break;
				case 8:
					System.out.println("Enter your account Number : ");
					accountNo = sc.nextLong();
					System.out.println("Your status is : "+bankingServices.accountStatus(accountNo));
					break;
				case 9:
					System.out.println("thank you.");
					System.exit(0);
					break;
				default:
					System.out.println("Please Enter Correct Choice!!!");

				}
			}while(choice!=9);
		} catch (InvalidAmountException | InvalidAccountTypeException | BankingServicesDownException
				| AccountNotFoundException | AccountBlockedException | InsufficientAmountException
				| InvalidPinNumberException e) {
			e.printStackTrace();
		}


	}
}
