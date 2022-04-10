package com.example.natwest.natwest.repository;

import com.example.natwest.natwest.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionInterface extends JpaRepository<AccountTransaction,Long> {

}
