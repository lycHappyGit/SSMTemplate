package test;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.lyc.bean.PdfOut;
import cn.lyc.bean.Person;

import com.alibaba.fastjson.JSON;
import com.mongodb.WriteResult;
  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class TestMongo {  
    
    @Autowired
	private MongoTemplate mongoTemplate;
  
    
    @Test
    public void test2(){
    	
    	Query query = new Query(Criteria.where("id").is("5a44b2fb82cea9276f95d73a"));
		PdfOut pdfOut = mongoTemplate.findOne(query, PdfOut.class);
		System.out.println("获取到的pdf为: " + JSON.toJSONString(pdfOut));
		byte[] pdfFileData = pdfOut.getPdfFileData();
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File("d:/pdfTest/" + pdfOut.getFileName()));
			fos.write(pdfFileData);
			System.out.println("pdf写入成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void test3(){
    	
		Query query = new Query(Criteria.where("name").is("lyc"));
		mongoTemplate.remove(query, "ab");
    }
    
    @Test
    public void test4() throws ParseException{
    	
    	for(int i=1;i<=12;i++){
    		
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Person person = new Person();
    		person.setName("lyc");
    		person.setAge(188);
    		String time = "2017-"+ i +"-10 11:22:33";
    		person.setTime(time);
    		person.setDate(dateFormat.parse(time));
    		mongoTemplate.insert(person, "ab");
    	}
	
    }
    
    @Test
    public void test5() throws ParseException{
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = dateFormat.parse("2017-02-10 00:00:00");
    	Query query = new Query(Criteria.where("date").lt(date));
		List<Person> list = mongoTemplate.find(query , Person.class, "ab");
		System.out.println("获取到的数据为:---------" + JSON.toJSONString(list));
		WriteResult remove = mongoTemplate.remove(query, Person.class, "ab");
		System.out.println("----" + JSON.toJSONString(remove));
    }
    
    @Test
    public void test6() throws ParseException{
    	
    	Query query = new Query(Criteria.where("name").is("lisi"));
    	Update update = new Update();
    	update.set("age", 17);
		mongoTemplate.upsert(query, update, Person.class);
    }
}  