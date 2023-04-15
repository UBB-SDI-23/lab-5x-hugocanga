package main.domain;

import java.time.LocalDate;
import java.util.Objects;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "orders")
	public class Order{
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "order_date")
	    private LocalDate orderDate;
	    
	    @Column(name = "status")
	    private String status;
	    
	    @Column(name = "total_price")
	    private Double totalPrice;
	    
	    @Column(name = "quantity")
	    private Integer quantity;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "customer_id", nullable = false)
	    @JsonIgnoreProperties("orders")
	    private Customer customer;

		public Order(Long id, LocalDate orderDate, String status, Double totalPrice, Integer quantity,
				Customer customer) {
			super();
			this.id = id;
			this.orderDate = orderDate;
			this.status = status;
			this.totalPrice = totalPrice;
			this.quantity = quantity;
			this.customer = customer;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDate getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(Double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "Order [id=" + id + ", orderDate=" + orderDate + ", status=" + status + ", totalPrice=" + totalPrice
					+ ", quantity=" + quantity + ", customer=" + customer + "]";
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Order))
				return false;
			Order other = (Order) obj;
			return Objects.equals(customer, other.customer) && Objects.equals(id, other.id)
					&& Objects.equals(orderDate, other.orderDate) && Objects.equals(quantity, other.quantity)
					&& Objects.equals(status, other.status) && Objects.equals(totalPrice, other.totalPrice);
		}
	    
	    // constructors, getters, and setters
	    
	}

	

