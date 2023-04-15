package main.service;

public class ProductSalesDTO {
    private Long productId;
    private String productName;
    private Double totalSales;
    private Double totalRevenue;

    public ProductSalesDTO() {}
    
    public ProductSalesDTO(Long productId, String productName, Double totalSales, Double totalRevenue) {
        this.productId = productId;
        this.productName = productName;
        this.totalSales = totalSales;
        this.totalRevenue = totalRevenue;
    }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Double getTotalSales() {
            return totalSales;
        }

        public void setTotalSales(Double totalSales) {
            this.totalSales = totalSales;
        }

        public Double getTotalRevenue() {
            return totalRevenue;
        }

        public void setTotalRevenue(Double totalRevenue) {
            this.totalRevenue = totalRevenue;
        }
    }
