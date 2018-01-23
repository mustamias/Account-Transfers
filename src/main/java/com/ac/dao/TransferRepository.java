package com.ac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ac.entities.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
	
	@Query("select t from Transfer t where t.account.name = :x order by t.date_transfer desc")
	public List<Transfer> TransferList(@Param("x")String AccountName);

}
