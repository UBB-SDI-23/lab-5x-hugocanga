package main.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.domain.Customer;
import main.domain.Product;
import main.domain.Transaction;
import main.service.ProductSalesDTO;
import main.repository.CustomerRepository;
import main.repository.ProductRepository;
import main.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public Transaction getTransactionById(Long id) {
		return transactionRepository.findById(id).orElse(null);
	}

	public Transaction createTransaction(Transaction transaction) {
		Customer customer = customerRepository.findById(transaction.getCustomer().getId()).orElse(null);
		Product product = productRepository.findById(transaction.getProduct().getId()).orElse(null);
		if (customer == null || product == null) {
			return null;
		}
		transaction.setCustomer(customer);
		transaction.setProduct(product);
		return transactionRepository.save(transaction);
	}

	public Transaction updateTransaction(Long id, Transaction transaction) {
		Transaction existingTransaction = transactionRepository.findById(id).orElse(null);
		if (existingTransaction == null) {
			return null;
		}
		Customer customer = customerRepository.findById(transaction.getCustomer().getId()).orElse(null);
		Product product = productRepository.findById(transaction.getProduct().getId()).orElse(null);
		if (customer == null || product == null) {
			return null;
		}
		return existingTransaction;
	}
	
	public List<ProductSalesDTO> getProductSalesReport() {
	    List<Object[]> resultList = transactionRepository.getProductSalesReport();
	    List<ProductSalesDTO> report = new ArrayList<>();
	    for (Object[] result : resultList) {
	        ProductSalesDTO dto = new ProductSalesDTO();
	        dto.setProductId((Long) result[0]);
	        dto.setProductName((String) result[1]);
	        dto.setTotalSales((Double) result[2]);
	        dto.setTotalRevenue((Double) result[3]);
	        report.add(dto);
	    }
	    return report;
	}

	
	
}
