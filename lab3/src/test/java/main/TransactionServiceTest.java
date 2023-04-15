package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import main.repository.TransactionRepository;
import main.service.ProductSalesDTO;
import main.service.TransactionService;

@SpringBootTest
public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    public void testGetProductSalesReport() {
        // Mock the repository method to return a list of transaction data
        List<Object[]> mockData = new ArrayList<>();
        mockData.add(new Object[] { 1L, "Product A", 5L, 50.0 });
        mockData.add(new Object[] { 2L, "Product B", 10L, 100.0 });
        when(transactionRepository.getProductSalesReport()).thenReturn(mockData);

        // Call the service method and check the result
        List<ProductSalesDTO> report = transactionService.getProductSalesReport();
        assertEquals(2, report.size());

        ProductSalesDTO dtoA = report.get(0);
        assertEquals(1L, dtoA.getProductId());
        assertEquals("Product A", dtoA.getProductName());
        assertEquals(5L, dtoA.getTotalSales());
        assertEquals(50.0, dtoA.getTotalRevenue());

        ProductSalesDTO dtoB = report.get(1);
        assertEquals(2L, dtoB.getProductId());
        assertEquals("Product B", dtoB.getProductName());
        assertEquals(10L, dtoB.getTotalSales());
        assertEquals(100.0, dtoB.getTotalRevenue());
    }
}
 
