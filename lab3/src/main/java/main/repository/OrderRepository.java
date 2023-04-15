package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByTotalPriceGreaterThan(double price);
}
