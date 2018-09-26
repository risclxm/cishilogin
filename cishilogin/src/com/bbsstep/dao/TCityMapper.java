package com.bbsstep.dao;

import com.bbsstep.po.TCity;

public interface TCityMapper {
	TCity getCityByName(String cityName) throws Exception;
}
