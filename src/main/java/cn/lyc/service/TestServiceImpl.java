package cn.lyc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.lyc.config.InitConfig;

import com.alibaba.fastjson.JSON;

@Service
public class TestServiceImpl {

	@Value("${driver}")
	private String driver;
	
	@Autowired
	private InitConfig init;
	
	@Value("${aa}")
	private String aa;
	
	public String test(){
		
		System.out.println("service init:" + JSON.toJSONString(init));
		return driver + "  " + aa;
	}
}
