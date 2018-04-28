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

    public Product getProduct(){
        Session session = sessionFactory.getCurrentSession();
        Integer product_id = 1;
        return session.get(Product.class, product_id);
    }
}
