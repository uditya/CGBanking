package com.cg.banking.dao;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
public interface TransactionDAO {
	Transaction save(Transaction transaction);
	boolean update(Transaction transaction);
	Transaction findOne(int transactionId);
	List<Transaction> findAll();
}