package com.biz;

import java.io.Serializable;
import java.util.List;

public interface IbaseBiz<T> {

    public T getById(T t, Serializable id);

    public Boolean add(T t);

    public Boolean dell(T t, Serializable id);

    public Boolean update(T t);

    public List<T> findList(String hql);

    public List<T> findPageList(String hql, int index, int size);
}
