package cn.lyc.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;


@WebService
public class ServerFunction {

	@WebMethod
	public String sum(@WebParam(name="a") String a,
			@WebParam(name="b") Integer b){
		
		System.out.println("接收到参数为 : a = " + a + "\n b = " + b);
		return a + b;
	}
	
//	@WebMethod
//	public String sum(String a, Integer b){
//		
//		System.out.println("接收到参数为 : a = " + a + "\n b = " + b);
//		return a + b;
//	}
	
	public  static void main(String[] args){  
		
        Endpoint.publish("http://10.1.31.157:9001/Service/ServerFunction",new ServerFunction());  
        System.out.println("Publish Success~");  
    }  
}
