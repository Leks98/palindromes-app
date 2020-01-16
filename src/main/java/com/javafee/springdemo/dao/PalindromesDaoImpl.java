package com.javafee.springdemo.dao;

import com.javafee.springdemo.entity.Numerator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PalindromesDaoImpl implements PalindromesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Numerator> getNumbers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Numerator order by id, value", Numerator.class).getResultList();
    }

    @Override
    public List<Numerator> searchNumbersByValue(int value) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query;
        if (value >= 0) {
            query = currentSession.createQuery("from Numerator where value = :value");
            query.setParameter("value", value);
        } else
            query = currentSession.createQuery("from Numerator", Numerator.class);
        List<Numerator> numbers = query.getResultList();
        return numbers;
    }

    @Override
    public Numerator getNumberById(int id) {
        return sessionFactory.getCurrentSession().get(Numerator.class, id);
    }

    @Override
    public void deleteNumber(Numerator number) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(number);
    }

    @Override
    public void deleteNumberById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Numerator where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void saveNumber(Numerator number) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(number);
    }
}
