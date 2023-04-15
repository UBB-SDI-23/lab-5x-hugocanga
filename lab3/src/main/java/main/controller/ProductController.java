package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import main.Exceptions.ProductNotFoundException;
import main.domain.Product;
import main.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<Product> getAllProducts() {
	    return productRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId)  {
	    Product product = productRepository.findById(productId)
	        .orElseThrow(() -> new ProductNotFoundException( productId));
	    return ResponseEntity.ok().body(product);
	}

	@PostMapping("/")
	public Product createProduct(@RequestBody Product product) {
	    return productRepository.save(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
	                                              @RequestBody Product productDetails) {
	    Product product = productRepository.findById(productId)
	        .orElseThrow(() -> new ProductNotFoundException( productId));

	    product.setName(productDetails.getName());
	    product.setDescription(productDetails.getDescription());
	    product.setPrice(productDetails.getPrice());
	    product.setQuantity(productDetails.getQuantity());
	    product.setBrand(productDetails.getBrand());

	    final Product updatedProduct = productRepository.save(product);
	    return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId) {
	    Product product = productRepository.findById(productId)
	        .orElseThrow(() -> new ProductNotFoundException( productId));

	    productRepository.delete(product);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	}

}

