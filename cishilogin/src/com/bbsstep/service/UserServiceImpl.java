package com.bbsstep.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbsstep.dao.UserMpper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMpper mapper;
	
	@Override
	public Map<String, Integer> getAllIndexUserCount() throws Exception {
		 Map<String, Integer> userMap = new HashMap<>();
		 userMap.put("dayUserCount", mapper.getDayUserCount());
		 userMap.put("monthUserCount", mapper.getMonthUserCount());
		 userMap.put("allUserCount", mapper.getAllUserCount());
		return userMap;
	}

}
