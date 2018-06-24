package pl.edu.agh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.entity.OrderedProducts;
import pl.edu.agh.model.ProductOrder;
import pl.edu.agh.model.ShoppingCart;


@Transactional
@Repository
public class OrderedProductsDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public void addProductsOrder(int orderId, ShoppingCart shoppingCart){

        Session session = sessionFactory.getCurrentSession();

        for(ProductOrder order: shoppingCart.getProductOrders()){
            session.persist(new OrderedProducts(order.getProductData().getProductId(), order.getQuantity(), orderId));
        }

        session.flush();
    }

}
