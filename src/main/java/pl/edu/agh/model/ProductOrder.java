package pl.edu.agh.model;


public class ProductOrder {

    private ProductData productData;
    private int quantity;


    public ProductOrder(ProductData productData, int quantity) {
        this.productData = productData;
        this.quantity = quantity;
    }

    public ProductData getProductData() {
        return productData;
    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
