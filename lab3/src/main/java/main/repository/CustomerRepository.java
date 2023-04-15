package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.domain.Customer;
import main.domain.Order;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	 List<Customer> findByAgeGreaterThan(double price);
}
