package pl.edu.agh.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.agh.entity.Users;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepo {

    @Autowired
    private SessionFactory sessionFactory;


    public Users findByEmail(String email){

        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Users WHERE email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        if(!query.list().isEmpty())
            return (Users)(query.list().get(0));
        return null;
    }

    public Users save(Users user){
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        session.flush();
        return user;
    }

}
