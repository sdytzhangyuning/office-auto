package com.dao;

import java.util.List;

import com.entity.Userinfo;

public interface IuserDao extends IBaseDao<Userinfo> {

    public List<Userinfo> login(Userinfo user);

}
 