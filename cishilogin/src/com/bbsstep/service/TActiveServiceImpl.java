package com.bbsstep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbsstep.dao.TActiveMapper;
import com.bbsstep.po.TActive;

@Service
public class TActiveServiceImpl implements TActiveService{

	@Autowired
	private TActiveMapper mapper;
	@Override
	public List<TActive> getActivesByCity(String cityName) throws Exception {
		
		return mapper.getActivesByCity(cityName);
	}

}
