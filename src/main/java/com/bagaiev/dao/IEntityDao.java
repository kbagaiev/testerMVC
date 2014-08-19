package com.bagaiev.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author nedis
 * @version 1.0
 */
public interface IEntityDao<T> {

    void save(T e);

    void update(T e);

    void delete(T e);

    void remove(T e);

    T findById(Serializable id);

    List<T> findAll();

    void close();
}
