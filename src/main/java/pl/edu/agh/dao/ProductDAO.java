package pl.edu.agh.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.entity.Product;

@Transactional
@Repository
public class ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product){
        Session session = sessionFactory.getCurrentSession();

        session.persist(product);

        session.flush();
    }

    public Product getProduct(int productID){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, productID);
    }
}
