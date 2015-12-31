package com.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestUdp {
	 private byte[] buffer = new byte[1024];    
     
	    private DatagramSocket ds = null;    
	    
	    private DatagramPacket packet = null;    
	    
	    private InetSocketAddress socketAddress = null;    
	    
	    private String orgIp;    
	    
	    /**  
	     * 构造函数，绑定主机和端口.  
	     * @param host 主机  
	     * @param port 端口  
	     * @throws Exception  
	     */    
	    public TestUdp(String host, int port){    
	        socketAddress = new InetSocketAddress(host, port);    
	        try {
				ds = new DatagramSocket(socketAddress);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
	        System.out.println("服务端启动!");    
	    }    
	        
	    public final String getOrgIp() {    
	        return orgIp;    
	    }    
	    /**  
	     * 设置超时时间，该方法必须在bind方法之后使用.  
	     * @param timeout 超时时间  
	     * @throws Exception  
	     */    
	    public final void setSoTimeout(int timeout) throws Exception {    
	        ds.setSoTimeout(timeout);    
	    }    
	    /**  
	     * 获得超时时间.  
	     * @return 返回超时时间.  
	     * @throws Exception  
	     */    
	    public final int getSoTimeout() throws Exception {    
	        return ds.getSoTimeout();    
	    }    
	    /**  
	     * 绑定监听地址和端口.  
	     * @param host 主机IP  
	     * @param port 端口  
	     * @throws SocketException  
	     */    
	    public final void bind(String host, int port) throws SocketException {    
	        socketAddress = new InetSocketAddress(host, port);    
	        ds = new DatagramSocket(socketAddress);
	    }    
	    /**  
	     * 接收数据包，该方法会造成线程阻塞.  
	     * @return 返回接收的数据串信息  
	     * @throws IOException   
	     */    
	    public final String receive(){    
	        packet = new DatagramPacket(buffer, buffer.length);    
	        try {
				ds.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
	        orgIp = packet.getAddress().getHostAddress();    
	        String info = new String(packet.getData(), 0, packet.getLength());    
	        System.out.println("接收信息：" + info);    
	        return info;    
	    }    
	    /**  
	     * 将响应包发送给请求端.  
	     * @param bytes 回应报文  
	     * @throws IOException  
	     */    
	    public final void response(String info) throws IOException {    
	        System.out.println("客户端地址 : " + packet.getAddress().getHostAddress()    
	                + ",端口：" + packet.getPort());    
	        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, packet    
	                .getAddress(), packet.getPort());    
	        dp.setData(info.getBytes());    
	        ds.send(dp);    
	    }    
	    /**  
	     * 设置报文的缓冲长度.  
	     * @param bufsize 缓冲长度  
	     */    
	    public final void setLength(int bufsize) {    
	        packet.setLength(bufsize);    
	    }    
	    /**  
	     * 获得发送回应的IP地址.  
	     * @return 返回回应的IP地址  
	     */    
	    public final InetAddress getResponseAddress() {    
	        return packet.getAddress();    
	    }    
	    /**  
	     * 获得回应的主机的端口.  
	     * @return 返回回应的主机的端口.  
	     */    
	    public final int getResponsePort() {    
	        return packet.getPort();    
	    }    
	    /**  
	     * 关闭udp监听口.
	     */    
	    public final void close() {    
	        try {    
	            ds.close();    
	        } catch (Exception ex) {    
	            ex.printStackTrace();    
	        }    
	    }    
	    /**
	     * 测试方法.  
	     * @param args  
	     * @throws Exception  
	     */    
	    public static void start(){    
	        String serverHost = "192.168.31.243"; 
	        //139.196.25.229
	        int serverPort = 8433;    
	        TestUdp udpServerSocket = new TestUdp(serverHost, serverPort);
	        //udpServerSocket.bind(serverHost,serverPort);
	        while (true) {    
	        	String source = udpServerSocket.receive();  
	            try {
					udpServerSocket.response(udpServerSocket.analyze(source));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}    
	        }
	    }
	    
	    public static void main(String[]arg){    
	        String serverHost = "192.168.31.243";    
	        int serverPort = 8888;
	        TestUdp udpServerSocket = new TestUdp(serverHost, serverPort);
	        //System.out.println("服务端启动!");  
	        //udpServerSocket.bind(serverHost,serverPort);
	        while (true) {    
	        	String source = udpServerSocket.receive();  
	            try {
					udpServerSocket.response(udpServerSocket.analyze(source));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}    
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
			if (source.toLowerCase().contains("routeid")) {
				result = rundao("hostManagementState", source,"");
				System.out.println(result);
			} else if (source.toLowerCase().contains("alarmtype")) {
				result = rundao("LarumInfoState", source,"");
			}else if(source.toLowerCase().contains("http")){
				String url = source.replaceAll(",", "&");
				
				result = rundao("","",url);
				
				
			}else if(source.toLowerCase().contains("appid")){
				result = rundao("log",source,"");
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
					url = new URL("http://192.168.31.243:8080/jsonPrcProjectApi/"
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
			System.out.println(url.toString());
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
			InputStream instreams = null;
			try {
				instreams = entity.getContent();
			} catch (UnsupportedOperationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			result = convertStreamToString(instreams);
			if (entity != null) {
				System.out.println(result);
				httpgets.abort();
			}
			return result;
		}
}
