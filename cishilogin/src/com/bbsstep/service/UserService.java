package com.bbsstep.service;

import java.util.Map;

public interface UserService {
	// 获取首页里面需要的所有的关于用户的数据
	Map<String,Integer> getAllIndexUserCount()throws Exception;
	

}
