package com.cg.banking.services;
import java.util.List;
import java.util.Random;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.dao.AccountDAO;
import com.cg.banking.dao.AccountDAOImpl;
import com.cg.banking.dao.TransactionDAO;
import com.cg.banking.dao.TransactionDAOImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

public class BankingServicesImpl implements BankingServices {
	AccountDAO accountDAO= new AccountDAOImpl();
	TransactionDAO transactionDAO=new TransactionDAOImpl();

	@Override
    public Account openAccount(String accountType, float initBalance)
            throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
        Account account= new Account();
        if(!(accountType.equals("Salary")||accountType.equals("Saving")||accountType.equals("Current"))) throw new InvalidAccountTypeException("Please Choose a correct Account type.");
        account.setAccountType(accountType);
        if(initBalance<500) throw new InvalidAmountException("Please enter a Initial amount more than 500.");
        account.setAccountBalance(initBalance);
        account.setPinNumber(Integer.parseInt(String.format("%04d", new Random().nextInt(8999)+1000)));
        account.setStatus("Active");
        if(accountDAO.save(account)==null) throw new BankingServicesDownException();
        else return account;
    }

    @Override
    public float depositAmount(long accountNo, float amount)
            throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
        Account account= accountDAO.findOne(accountNo);
        if(account== null) throw new AccountNotFoundException("Please Enter Valid Account Number.");
        if(!account.getStatus().equals("Active")) throw new AccountBlockedException("Your Account is not working now.");
        account.setAccountBalance(account.getAccountBalance()+ amount);
        Transaction transaction= new Transaction(amount, "Deposit", account);
        transactionDAO.save(transaction);
        accountDAO.update(account);     
            return account.getAccountBalance();
    }

    @Override
    public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
    AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
        Account account= accountDAO.findOne(accountNo);
        if(accountDAO.findOne(accountNo)== null) throw new AccountNotFoundException("Please Enter Valid Acc Number.");
        if(!accountDAO.findOne(accountNo).getStatus().equals("Active")) throw new AccountBlockedException("Your Account Is Currently Blocked.");
        if(pinNumber!= account.getPinNumber()) throw new InvalidPinNumberException();
        if(account.getAccountBalance()< amount) throw new InsufficientAmountException();
        account.setAccountBalance(account.getAccountBalance()-amount);
        accountDAO.update(account);
        Transaction transaction= new Transaction(amount, "Withdraw", account);
        transactionDAO.save(transaction);
        return account.getAccountBalance();
    }

    @Override
    public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
            throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
            BankingServicesDownException, AccountBlockedException {
        Account payer= accountDAO.findOne(accountNoFrom);
        Account payee= accountDAO.findOne(accountNoTo);
        if(payer== null || payee== null) throw new AccountNotFoundException("Enter valid details");
        if(pinNumber!= payer.getPinNumber()) throw new InvalidPinNumberException();
        if(!payer.getStatus().equals("Active")|| !payee.getStatus().equals("Active")) throw new AccountBlockedException();
        if(payer.getAccountBalance()< transferAmount) throw new InsufficientAmountException();
        payer.setAccountBalance(payer.getAccountBalance()- transferAmount);
        payee.setAccountBalance(payee.getAccountBalance()+ transferAmount);
        accountDAO.update(payee);
        accountDAO.update(payer);
        return true;
    }

    @Override
    public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
        if(accountDAO.findOne(accountNo)==null) throw new AccountNotFoundException();
        return accountDAO.findOne(accountNo);
    }

    @Override
    public List<Account> getAllAccountDetails() throws BankingServicesDownException {
        return accountDAO.findAll();
    }

    @Override
    public List<Transaction> getAccountAllTransaction(long accountNo)
            throws BankingServicesDownException, AccountNotFoundException {
        Account account= accountDAO.findOne(accountNo);
        if(account== null) throw new AccountNotFoundException();
        return transactionDAO.findAll();
    }

    @Override
    public String accountStatus(long accountNo)
            throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
        Account account= accountDAO.findOne(accountNo);
        if(account== null) throw new AccountNotFoundException();
        if(!account.getStatus().equals("Active")) throw new AccountBlockedException();
        return account.getStatus();
    }
}
