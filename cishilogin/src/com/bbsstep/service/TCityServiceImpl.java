package com.bbsstep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbsstep.dao.TCityMapper;
import com.bbsstep.po.TCity;
@Service
public class TCityServiceImpl implements TCityService{

	@Autowired
	private TCityMapper mapper;
	@Override
	public TCity getLoationByName(String cityName) throws Exception {
		return mapper.getCityByName(cityName);
	}

}
