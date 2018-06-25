package pl.edu.agh.model;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{

    private int orderId;
    private CustomerData customerData;

    private final List<ProductOrder> productOrders = new ArrayList<ProductOrder>();

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
            if(order.getProductData().getProductId() == (productId))
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

    public void updateQuantity(int productId, int quantity){
        ProductOrder productOrder = findProductOrder(productId);

        if(productOrder != null){
            if(quantity > 0)
                productOrder.setQuantity(quantity);
            else
                productOrders.remove(productOrder);
        }
    }

    public void removeProduct(int productId){
        productOrders.remove(findProductOrder(productId));
    }

    private boolean orderExist(int productId, List<ProductOrder> productOrders){
        for(ProductOrder order: productOrders){
            if(order.getProductData().getProductId() == productId)
                return true;
        }
        return false;
    }

    private void updateProductsQuantities(List<ProductOrder> productOrders){
        for(ProductOrder order: productOrders){
            this.updateQuantity(order.getProductData().getProductId(), order.getQuantity());
        }
    }

    private void removeDeletedProducts(List<ProductOrder> productOrders){
        for(ProductOrder order: this.productOrders){
            int productId = order.getProductData().getProductId();
            if(!orderExist(productId, productOrders))
                removeProduct(productId);
        }
    }

    public void updateCart(ShoppingCart form){

        if(form != null){
            List<ProductOrder> productOrders = form.getProductOrders();

            updateProductsQuantities(productOrders);
            removeDeletedProducts(productOrders);
        }
    }


}
