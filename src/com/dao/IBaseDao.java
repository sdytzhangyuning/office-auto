package com.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {

    public T getByID(T obj, Serializable id);

    public Boolean add(T t);

    public Boolean dell(T obj, Serializable id);

    public Boolean update(T t);

    public List<T> findList(String hql);

    public List<T> findPageList(final String hql, final int index, final int size);
}
