package pl.edu.agh.dao;


import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.entity.Product;

import java.util.ArrayList;
import java.util.List;

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

    public List<Product> getAllProducts(){
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product";
        Query query = session.createQuery(hql);
        List<Product> products = query.list();
        return products;
    }
}
