package com.bagaiev.dao.impl.hibernate;

import com.bagaiev.dao.IEntityDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kostya on 12.08.2014.
 */
public abstract class AbstractEntityDao<T> implements IEntityDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    protected abstract Class<T> getEntityClass();

    @Override
    public void save(final T e) {
        getSession().save(e);
    }

    @Override
    public void update(T e){
        getSession().update(e);
    }

    @Override
    public void delete(T e){
        getSession().delete(e);
    }

    @Override
    public void remove(T e) {
        delete(e);
    }

    @Override
    public T findById(Serializable id) {
        return (T)getSession().get(getEntityClass(), id);
    }

    @Override
    public List<T> findAll() {
        return getSession().createCriteria(getEntityClass()).list();
    }

    @Override
    public void close() {

    }


}
