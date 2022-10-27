package com.relation.onetomany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.relation.models.Transactions;

@Repository
public interface TransactionsDao extends JpaRepository<Transactions, Integer>{
	@Query(value = "SELECT * FROM transactions a WHERE a.sid = ?1", 
			  nativeQuery = true)
	List<Transactions> findTransactionsByShopId(int sid);
}
