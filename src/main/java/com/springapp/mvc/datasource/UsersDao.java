package com.springapp.mvc.datasource;

import com.springapp.mvc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDao {

    @Autowired
    private SessionFactory sessionFactory;

    public UsersDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getListOfUsers() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List items = null;
        try {
            tx = session.beginTransaction();
            items = session.createQuery("FROM User").list();
            tx.commit();
        }
        catch (HibernateException hibernateException) {
            if(tx != null)
                tx.rollback();

            hibernateException.printStackTrace();
        }
        finally {
            session.close();
        }
        return items;
    }

}
