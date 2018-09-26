package com.bbsstep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbsstep.dao.CarouselBeanMapper;
import com.bbsstep.po.CarouselBean;
import com.bbsstep.util.DataTablePageUtil;


@Service
public class CarouselBeanServiceImpl implements CarouselBeanService {

	@Autowired
	private CarouselBeanMapper carouselBeanMapper;
	
	public DataTablePageUtil<CarouselBean> list(DataTablePageUtil<CarouselBean> param) {
		int total=carouselBeanMapper.selectNumByParam(param);
		param.setRecordsTotal(total);
		param.setRecordsFiltered(total);
		param.setData(carouselBeanMapper.selectByParam(param));
		return param;
	}

	@Override
	public int add(CarouselBean record) {
		
		return carouselBeanMapper.insert(record);
	}

	

	
}
