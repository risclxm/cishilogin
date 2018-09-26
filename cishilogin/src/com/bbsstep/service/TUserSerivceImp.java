package com.bbsstep.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbsstep.dao.TUserMapper;
import com.bbsstep.po.TUser;
import com.bbsstep.util.MD5Util;

@Service
public class TUserSerivceImp implements TUserService{
	@Autowired
	private TUserMapper mapper ;

	@Override
	public TUser checkUser(String pwd, String username) throws Exception {
		Map<String,String> map = new HashMap<>();	
		//1 将密码加密
	    String md5Pwd = MD5Util.makePassword(pwd);
	    
		// 将所有数值放到map中
	    map.put("pwd",md5Pwd);
	    map.put("name", username);
		
		return mapper.checkUser(map);
	}

}
