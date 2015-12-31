package com.news;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class Fuwuqi2 {
    /**
     * @param args
     */
    public static final int SERVER_PORT=6000;
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("VNTCenter.main()===TCP SERVER==============");
        try{
            ServerSocket vntServer= new ServerSocket(SERVER_PORT);
            System.out.println("Listening Port is "+vntServer.getLocalPort()+"...");
            while(true){
                Socket vntClient=vntServer.accept();
                System.out.println("have a client entering , the IP is "+vntClient.getInetAddress()+"...");
                System.out.println("have a client entering , the Port is "+vntClient.getPort()+"...");
                new GetGpsThreadFun(vntClient).start();
            }
        }catch (Exception e) {

            e.printStackTrace();
        }
    }
}

class GetGpsThreadFun2 extends Thread{
    private Socket vntThreadClient;
    public GetGpsThreadFun2(Socket vntThreadSocket){
        vntThreadClient=vntThreadSocket;
    }
    public void run(){
        try{
            BufferedReader vntThreadIS=new BufferedReader(new InputStreamReader(vntThreadClient.getInputStream()));
            DataOutputStream vntThreadOS = new DataOutputStream(vntThreadClient.getOutputStream());
            while(true){
            	String vntReceiveString = "";
                //String vntReceiveString=vntThreadIS.readLine();
            	char[] cbuf = new char[1024];
            	int i =-1;
            	if((i = vntThreadIS.read(cbuf) )!=-1){
            		System.out.println("len is:"+i);
            		vntReceiveString = new String(cbuf, 0, i);
            		System.out.println("result is:" + vntReceiveString);
            		
            	}

                if("quit".equals(vntReceiveString)){
                    break;
                }else {
                	String result = analyze(vntReceiveString);
                	vntThreadOS.writeBytes(result);
                	vntThreadOS.flush();
                }
            }
            vntThreadIS.close();
            vntThreadClient.close();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	//传递参数调用方法
	public String callMethod(String method,String repall){
		HttpGet httpgets = null;
		String result=null;
    
    		httpgets = new HttpGet(
    			"http://192.168.1.123:8080/jsonPrcProjectApi/method?"+repall);
    		//测试打印路径：
    			System.out.println("路径："+"http://192.168.1.123:8080/jsonPrcProjectApi/method?"+repall);
    			
    		@SuppressWarnings("deprecation")
    		HttpClient httpclient  = new DefaultHttpClient();
    		HttpResponse response = null;
			try {
				response = httpclient.execute(httpgets);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    		HttpEntity entity = response.getEntity();
    		if (entity != null) {
    			InputStream instreams = null;
				try {
					instreams = entity.getContent();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				result = convertStreamToString(instreams);
    			System.out.println("Do something");
    			System.out.println(result);
    			// Do not need the rest
    			httpgets.abort();
    		}    
    	return result;		
	}
    //处理客户  url  字符串 ，判断调用的是那个方法名。。
    public String analyze(String source){
    
    	String result = "Error command!";    	
    	String newstr = source.toLowerCase();
		String newstr1 = newstr.replace("<","");
		String newstr2 = newstr1.replace(">","");
		String repAll = newstr2.replaceAll(",","&");
		
		//src= & state= &method= 
		String method=repAll.substring(repAll.lastIndexOf("=")+1);
		
		//判断方法
		if("hearTest".equals(method)){ 
			result=callMethod(method,repAll);
			
		}else if("laruminfo".equals(method)){
			result=callMethod(method,repAll);
			
		}else if("".equals(method)){
			result=callMethod(method,repAll);
			
		}else if("".equals(method)){
			result=callMethod(method,repAll);
			
		}else if("".equals(method)){
			result=callMethod(method,repAll);
			
		}else if("".equals(method)){
			result=callMethod(method,repAll);
			
		}else if("".equals(method)){
			result=callMethod(method,repAll);
			
		}else if("".equals(method)){
			result=callMethod(method,repAll);
			
		}else if("".equals(method)){
			result=callMethod(method,repAll);
		}
		else{
			result="您输入的参数有误，请重新输入。";
		}
			
		return result;
    }
}
		/*HttpGet httpgets = null;
    	if("heartTest".equals(method)){
    		httpgets = new HttpGet(
    				"http://192.168.1.123:8080/jsonPrcProjectApi/hostManagementState?"+repAll);
    		System.out.println("路径："+"http://192.168.1.123:8080/jsonPrcProjectApi/hostManagementState?"+repAll);
    		@SuppressWarnings("deprecation")
    		HttpClient httpclient  = new DefaultHttpClient();
    		HttpResponse response = null;
			try {
				response = httpclient.execute(httpgets);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    		HttpEntity entity = response.getEntity();
    		if (entity != null) {
    			InputStream instreams = null;
				try {
					instreams = entity.getContent();
				} catch (UnsupportedOperationException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				result = convertStreamToString(instreams);
    			System.out.println("Do something");
    			System.out.println(result);
    			// Do not need the rest
    			httpgets.abort();
    		}
    	}else if("laruminfo".equals(method))){
    		
    	}
    	return result;*/
   //==============================================================
    	
    	
    /*	
    	
		HttpGet httpgets = null;
    	if (source.toLowerCase().contains("routeid")) {
    		System.out.println("进来了");
    		String newstr = source.replace(">","");
    		String [] sou = newstr.split(",");
    		System.out.println(sou.length);
    		for (int i = 0; i < sou.length; i++) {
				int ind = sou[i].indexOf("=");
				str.add(sou[i].substring(ind+1));
			}
    		
    		String newstr = source.toLowerCase();
    		String newstr1 = newstr.replace("<","");
    		String newstr2 = newstr1.replace(">","");
    		String repAll = newstr2.replaceAll(",","&");
    		httpgets = new HttpGet(
    				"http://192.168.1.123:8080/jsonPrcProjectApi/hostManagementState?"+repAll);
    		System.out.println("路径："+"http://192.168.1.123:8080/jsonPrcProjectApi/hostManagementState?"+repAll);
    		@SuppressWarnings("deprecation")
    		HttpClient httpclient  = new DefaultHttpClient();
    		HttpResponse response = null;
			try {
				response = httpclient.execute(httpgets);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    		HttpEntity entity = response.getEntity();
    		if (entity != null) {
    			InputStream instreams = null;
				try {
					instreams = entity.getContent();
				} catch (UnsupportedOperationException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				result = convertStreamToString(instreams);
    			System.out.println("Do something");
    			System.out.println(result);
    			// Do not need the rest
    			httpgets.abort();
    		}
		}else if(source.toLowerCase().contains("alarmtype")){
    		String newstr = source.toLowerCase();
    		String newstr1 = newstr.replace("<","");
    		String newstr2 = newstr1.replace(">","");
    		String repAll = newstr2.replaceAll(",","&");
    		httpgets = new HttpGet(
    				"http://192.168.1.123:8080/jsonPrcProjectApi/hostManagementState?"+repAll);
    		System.out.println("路径："+"http://192.168.1.123:8080/jsonPrcProjectApi/hostManagementState?"+repAll);
    		@SuppressWarnings("deprecation")
    		HttpClient httpclient  = new DefaultHttpClient();
    		HttpResponse response = null;
			try {
				response = httpclient.execute(httpgets);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    		HttpEntity entity = response.getEntity();
    		if (entity != null) {
    			InputStream instreams = null;
				try {
					instreams = entity.getContent();
				} catch (UnsupportedOperationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				result = convertStreamToString(instreams);
    			System.out.println("Do something");
    			System.out.println(result);
    			// Do not need the rest
    			httpgets.abort();
    		}
		}
    	return result;

    }
}
*/