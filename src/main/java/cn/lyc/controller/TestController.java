package cn.lyc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lyc.config.InitConfig;
import cn.lyc.service.TestServiceImpl;

import com.alibaba.fastjson.JSON;

@RestController
public class TestController {

	@Autowired
	private TestServiceImpl testService;
	
	@Autowired
	private InitConfig init;
	
	@RequestMapping("/ping")
	public String aa(){
		
		String test = testService.test();
		System.out.println("controller init:" + JSON.toJSONString(init));
		return "ping success " + test;
	}
	
	@RequestMapping("/ping2")
	public Map<String,Object> bb(@RequestBody Map<String,Object> map){
		
		System.out.println(JSON.toJSONString(map));
		return map;
	}
}
