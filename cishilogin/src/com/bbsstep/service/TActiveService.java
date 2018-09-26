package com.bbsstep.service;

import java.util.List;

import com.bbsstep.po.TActive;

public interface TActiveService {
	
	List<TActive> getActivesByCity(String cityName) throws Exception;

}
