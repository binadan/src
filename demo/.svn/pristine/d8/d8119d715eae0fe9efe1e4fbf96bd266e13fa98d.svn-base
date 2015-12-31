package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Test01 {
	public static void main(String[] args) {
		try {
			DatagramSocket udp = new DatagramSocket(8888);
			String s = "你好啊，朋友！";
			//构造方法中指定发送给对象的数据，对方的地址和端口号
			DatagramPacket data = new DatagramPacket(s.getBytes(),s.getBytes().length, InetAddress.getLocalHost(), 7777);
			// 发送数据
			udp.send(data);
			udp.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
