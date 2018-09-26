package com.bbsstep.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbsstep.po.TActive;
import com.bbsstep.po.TCity;
import com.bbsstep.service.TActiveService;
import com.bbsstep.service.TCityService;

@Controller
@RequestMapping("/active")
public class TActiveController {
	@Autowired
	private TActiveService tActiveService;
	@Autowired
	private TCityService tCityService;
	@RequestMapping(value="/getActivesByCity",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getActivesByCityName(String cityName) {
		
		List<TActive> activeList = new ArrayList<>();
		TCity city = null;
		int statues=1;
		Map<String,Object> reslut=new HashMap<String,Object>();
		
		try {
			activeList=tActiveService.getActivesByCity(cityName);
			city = tCityService.getLoationByName(cityName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if( city !=null) {
			statues=0;
			
		}
		reslut.put("status", statues);
		reslut.put("city", city);
		reslut.put("activeList", activeList);
		return reslut;
	}

}
