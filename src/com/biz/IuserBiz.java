package com.biz;

import com.entity.Userinfo;

public interface IuserBiz extends IbaseBiz<Userinfo> {

    public Userinfo login(Userinfo user);

}
