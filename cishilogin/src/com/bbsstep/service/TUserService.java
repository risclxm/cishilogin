package com.bbsstep.service;

import com.bbsstep.po.TUser;

public interface TUserService {
//给他一个用户名和密码，他将密码加密之后到数据库查询有没有这个用户，如果有，返回这个而用户，如果没有返回null
	TUser checkUser(String pwd,String username)throws Exception;
}
