package pl.edu.agh.model;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{

    private int orderId;
    private CustomerData customerData;

    private final List<ProductOrder> productOrders = new ArrayList<>();

    public ShoppingCart(){
    }

    public int getOrderId(){
        return orderId;
    }

    public CustomerData getCustomerData(){
        return customerData;
    }

    public List<ProductOrder> getProductOrders() {
        return productOrders;
    }

    private ProductOrder findProductOrder(int productId){
        for(ProductOrder order: productOrders)
            if(order.getProductData().equals(productId))
                return order;
        return null;
    }

    public void addProduct(ProductData productData){
        ProductOrder productOrder = findProductOrder(productData.getProductId());

        if(productOrder == null)
            productOrders.add(new ProductOrder(productData, 1));
        else
            productOrder.setQuantity(productOrder.getQuantity() + 1);

    }

    public void updateQuantity(ProductData productData, int quantity){
        ProductOrder productOrder = findProductOrder(productData.getProductId());

        if(productOrder != null){
            if(quantity > 0)
                productOrder.setQuantity(quantity);
            else
                productOrders.remove(productOrder);
        }
    }

    public void removeProduct(ProductData productData){
        productOrders.remove(findProductOrder(productData.getProductId()));
    }

    public void updateQuantity(ShoppingCart form){

        if(form != null){
            List<ProductOrder> productOrders = form.getProductOrders();
            for(ProductOrder order: productOrders){
                this.updateQuantity(order.getProductData(), order.getQuantity());
            }
        }
    }


}
