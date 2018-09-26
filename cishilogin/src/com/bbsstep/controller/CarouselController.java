package com.bbsstep.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bbsstep.po.CarouselBean;
import com.bbsstep.po.TUser;
import com.bbsstep.service.CarouselBeanService;
import com.bbsstep.util.DataTablePageUtil;

@Controller
@RequestMapping("/carousel")
public class CarouselController {

	@Autowired
	private CarouselBeanService carouselBeanService;

	@RequestMapping("/guidList")
	@ResponseBody
	public DataTablePageUtil<CarouselBean> list(WebRequest request) {
		DataTablePageUtil<CarouselBean> dataTable = new DataTablePageUtil<CarouselBean>(request);
		// 设置查询类型为引导页
		dataTable.getCondition().put("type", "y");
		return carouselBeanService.list(dataTable);
	}

	@RequestMapping(value="/peacocklist",produces="application/json;charset=utf-8")
	@ResponseBody
	public DataTablePageUtil<CarouselBean> peacocklist(WebRequest request) {
		DataTablePageUtil<CarouselBean> dataTable = new DataTablePageUtil<CarouselBean>(request);
		// 设置查询类型为开屏广告
		dataTable.getCondition().put("type", "a");
		
		return carouselBeanService.list(dataTable);
	}

	@RequestMapping("/peacockAdd")
	public ModelAndView peacockAdd(CarouselBean bean, MultipartFile myfiles, HttpSession session) {
		//頁面上所有的数据都已经提交到了这个方法的参数里面。
		// 1、将文件对象myFiles里面的文件数据保存到服务器的物理路径里面。
		//2、将上传文件在服务的地址设置到引导页bean对象里面去。
		// 3 、将上面的引导页信息保存到数据库里面。
		
		
		ModelAndView mv = new ModelAndView();
		// 原始文件名称
		String pictureFile_name = myfiles.getOriginalFilename();
		// 新文件名称
		String newFileName = UUID.randomUUID().toString()
				+ pictureFile_name.substring(pictureFile_name.lastIndexOf("."));

		// 上传图片
		File uploadPic = new java.io.File("I:\\cishi\\imgs\\" + newFileName);

		if (!uploadPic.exists()) {
			uploadPic.mkdirs();
		}
		// 向磁盘写文件
		try {
			myfiles.transferTo(uploadPic);
		} catch (IllegalStateException | IOException e) {
			mv.addObject("msg", "引导图上传失败");
			e.printStackTrace();
		}
		bean.setPath("pic/" + newFileName);
		TUser user = (TUser) session.getAttribute("loginUser");
		bean.setUserId(user.getId());
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		bean.setCreatetime(time);
		bean.setEdittime(time);
		bean.setType("y");

		// 保存到数据库
		try {
			int row = carouselBeanService.add(bean);
			if (row == 0) {
				mv.addObject("msg", "引导图新增失败");
			} else {
				mv.addObject("msg", "引导图新增成功");
			}
		} catch (Exception ex) {
			mv.addObject("msg", "引导图新增失败");
		}
		mv.setViewName("redirect:/pages/operconfig/carousel/guid_list.jsp");
		return mv;
	}

}
