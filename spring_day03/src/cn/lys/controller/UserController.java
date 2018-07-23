package cn.lys.controller;

import java.lang.annotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lys.c3p0.UserService;


@RequestMapping("/user")
@Controller
public class UserController{
	
	private final static String SUCCESS = "success";
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getUser")
	public String getUser(){
		String[] strs = new String[]{"Don't turn off lights", "Here I am","Glory of edge!","Because of you!","5、欧冠主题曲"};
		System.out.println(strs.length);
		for(int i= 0;i< strs.length;i++){
			System.out.println(strs[i]);
		}
		userService.add();
		return "success";
	}



}
