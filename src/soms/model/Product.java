package soms.model;

public class Product {

    private long productId;

    private String productName;

    private String productDesc;

    private Double productPrice;

    private int productQty;

    public Product() {
    }

    public Product( String productName, String productDesc, Double productPrice, int productQty) {

        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productQty = productQty;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productPrice=" + productPrice +
                ", productQty=" + productQty +
                '}';
    }
}
