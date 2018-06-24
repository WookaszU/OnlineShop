package pl.edu.agh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.entity.Order;

@Transactional
@Repository
public class OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public int addOrder(Order order){
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
        session.flush();
        return order.getId();
    }

}
