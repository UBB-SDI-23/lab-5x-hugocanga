package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import main.domain.Transaction;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t.product.id, t.product.name, COUNT(t.id), SUM(t.price) " +
            "FROM Transaction t GROUP BY t.product.id, t.product.name")
    List<Object[]> getProductSalesReport();

}

