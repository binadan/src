package com.news;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GetGpsThreadFun extends Thread{
	public static final int SERVER_PORT = 8433;
	public static void main(String[] args) {
		System.out.println("VNTCenter.main()===TCP SERVER==============");
		try {
			ServerSocket vntServer = new ServerSocket(SERVER_PORT);
			System.out.println("Listening Port is " + vntServer.getLocalPort()
					+ "...");
			while (true) {
				Socket  vntClient = vntServer.accept();
				System.out.println("have a client entering , the IP is "
						+ vntClient.getInetAddress() + "...");
				System.out.println("have a client entering , the Port is "
						+ vntClient.getPort() + "...");
				new GetGpsThreadFun(vntClient).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    private Socket vntThreadClient;
    public GetGpsThreadFun(Socket vntThreadSocket){
        vntThreadClient=vntThreadSocket;
    }
    public void run(){
        try{
            BufferedReader vntThreadIS=new BufferedReader(new InputStreamReader(vntThreadClient.getInputStream()));
            DataOutputStream vntThreadOS = new DataOutputStream(vntThreadClient.getOutputStream());
            while(true){
            	String vntReceiveString = "";
            	char[] cbuf = new char[1024];
            	int i =-1;
            	if((i = vntThreadIS.read(cbuf))!=-1){
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
			//System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String sbs = "";
		System.out.println(sb+"------------");
		try {
			sbs = (new String(sb.toString().getBytes(),"utf-8"));
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sbs;
	}

	public String analyze(String source) {
		String result = "Error command!";
		if ("hello".equals(source)) {
			result = "Hello world.";
		}
		if ("fuck".equals(source)) {
			result = "Fuck you!";
		}
		if (source.toLowerCase().contains("routeid")) {
			result = rundao("hostManagementState", source,"");
			System.out.println(result);
		} else if (source.toLowerCase().contains("alarmtype")) {
			result = rundao("LarumInfoState", source,"");
		}else if(source.toLowerCase().contains("http")){
			result = rundao("","",source);
			
		}
		return result;
	}
	HttpGet httpgets = null;
	public String rundao(String method,String source,String xieyi) {
		URL url = null;
		String result = "Error command!";
		if (source.trim().length()!=0 && method.trim().length()!=0) {
			String newstr = source.toLowerCase();
			String newstr1 = newstr.replace("<", "");
			String newstr2 = newstr1.replace(">", "");
			String repAll = newstr2.replaceAll(",", "&");
			try {
				url = new URL("http://192.168.1.104:8080/jsonPrcProjectApi/"
						+ method + "?" + repAll);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else{
			try {
				url = new URL(xieyi);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		httpgets = new HttpGet(url.toString());
		System.out.println("路径：" + url.toString());
		@SuppressWarnings("deprecation")
		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpgets);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
			System.out.println(result);
			httpgets.abort();
		}
		return result;
	}
}
//http：//平台软件IP地址：8080/api/paycost?id=家庭主机ID,cost=具体金额,time=32656778