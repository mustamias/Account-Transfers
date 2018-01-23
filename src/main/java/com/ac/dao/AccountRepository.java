package com.ac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ac.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
