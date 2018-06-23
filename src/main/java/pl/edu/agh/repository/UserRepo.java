package pl.edu.agh.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.agh.entity.Product;
import pl.edu.agh.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepo {

    @Autowired
    private SessionFactory sessionFactory;


    public User findByEmail(String email){

        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM User WHERE email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        if(!query.list().isEmpty())
            return (User)(query.list().get(0));
        return null;
    }

    public User save(User user){
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        session.flush();
        return user;
    }

}
