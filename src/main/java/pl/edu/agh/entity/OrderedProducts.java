package pl.edu.agh.entity;

import javax.persistence.*;

@Entity
@Table(name = "Ordered_products")
public class OrderedProducts {

    @Id
    @Column(name = "orderedProduct_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "order_id", nullable = false)
    private int orderId;

    public OrderedProducts(int productId, int amount, int orderId) {
        this.productId = productId;
        this.quantity = amount;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
