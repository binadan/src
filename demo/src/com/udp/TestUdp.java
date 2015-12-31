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
	     * ���캯�����������Ͷ˿�.  
	     * @param host ����  
	     * @param port �˿�  
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
	        System.out.println("���������!");    
	    }    
	        
	    public final String getOrgIp() {    
	        return orgIp;    
	    }    
	    /**  
	     * ���ó�ʱʱ�䣬�÷���������bind����֮��ʹ��.  
	     * @param timeout ��ʱʱ��  
	     * @throws Exception  
	     */    
	    public final void setSoTimeout(int timeout) throws Exception {    
	        ds.setSoTimeout(timeout);    
	    }    
	    /**  
	     * ��ó�ʱʱ��.  
	     * @return ���س�ʱʱ��.  
	     * @throws Exception  
	     */    
	    public final int getSoTimeout() throws Exception {    
	        return ds.getSoTimeout();    
	    }    
	    /**  
	     * �󶨼�����ַ�Ͷ˿�.  
	     * @param host ����IP  
	     * @param port �˿�  
	     * @throws SocketException  
	     */    
	    public final void bind(String host, int port) throws SocketException {    
	        socketAddress = new InetSocketAddress(host, port);    
	        ds = new DatagramSocket(socketAddress);
	    }    
	    /**  
	     * �������ݰ����÷���������߳�����.  
	     * @return ���ؽ��յ����ݴ���Ϣ  
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
	        System.out.println("������Ϣ��" + info);    
	        return info;    
	    }    
	    /**  
	     * ����Ӧ�����͸������.  
	     * @param bytes ��Ӧ����  
	     * @throws IOException  
	     */    
	    public final void response(String info) throws IOException {    
	        System.out.println("�ͻ��˵�ַ : " + packet.getAddress().getHostAddress()    
	                + ",�˿ڣ�" + packet.getPort());    
	        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, packet    
	                .getAddress(), packet.getPort());    
	        dp.setData(info.getBytes());    
	        ds.send(dp);    
	    }    
	    /**  
	     * ���ñ��ĵĻ��峤��.  
	     * @param bufsize ���峤��  
	     */    
	    public final void setLength(int bufsize) {    
	        packet.setLength(bufsize);    
	    }    
	    /**  
	     * ��÷��ͻ�Ӧ��IP��ַ.  
	     * @return ���ػ�Ӧ��IP��ַ  
	     */    
	    public final InetAddress getResponseAddress() {    
	        return packet.getAddress();    
	    }    
	    /**  
	     * ��û�Ӧ�������Ķ˿�.  
	     * @return ���ػ�Ӧ�������Ķ˿�.  
	     */    
	    public final int getResponsePort() {    
	        return packet.getPort();    
	    }    
	    /**  
	     * �ر�udp������.
	     */    
	    public final void close() {    
	        try {    
	            ds.close();    
	        } catch (Exception ex) {    
	            ex.printStackTrace();    
	        }    
	    }    
	    /**
	     * ���Է���.  
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
	        //System.out.println("���������!");  
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
			System.out.println("·����" + url.toString());
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
