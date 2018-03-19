package test;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.lyc.dao.UserMapper;
import cn.lyc.entity.User;
import cn.lyc.entity.UserExample;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class TestMyBatis {  
    
//	private Logger logger = Logger.getLogger(TestMyBatis.class);
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private UserMapper um;
    
    @Autowired
	private MongoTemplate mongoTemplate;
  
    @Test
    public void test1(){
    	
    	User user = new User();
    	user.setName("lisi");
    	user.setSex("女");
    	user.setLikes("哈哈");
    	um.insertSelective(user);
    }
    
    @Test
    public void test2(){
    	
    	UserExample example = new UserExample();
		List<User> list = um.selectByExample(example );
		System.out.println(JSONObject.toJSONString(list));
    }
    
    @Test
    public void test3(){
    	
    	List<Map<String, String>> map = um.test();
    	System.out.println(JSON.toJSONString(map));
    }
    
    @Test
    public void test4(){
    	
    	String a = null;
    	try {
			boolean b = a.equals("2");
			System.out.println(b);
		} catch (Exception e) {
//			System.out.println("print------------------------");
//			e.printStackTrace();
//			System.out.println("logger+e------------------------");
//			logger.info("异常+e :" + e);
			System.out.println("logger,e------------------------");
			logger.info("异常,e :{},{},{}", "womenshiceshi", "ceshiyichangshucu", e);
			
		}
    }
  
}  