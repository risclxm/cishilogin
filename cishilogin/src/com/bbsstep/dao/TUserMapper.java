package com.bbsstep.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bbsstep.po.TUser;
@Repository
public interface TUserMapper {

	TUser checkUser(Map<String,String> map) throws Exception;
}
