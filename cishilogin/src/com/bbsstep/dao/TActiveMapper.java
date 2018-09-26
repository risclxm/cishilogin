package com.bbsstep.dao;

import java.util.List;

import com.bbsstep.po.TActive;

public interface TActiveMapper {
	List<TActive> getActivesByCity(String cityName) throws Exception;
}
