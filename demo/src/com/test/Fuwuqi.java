package com.test;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.http.HttpServletRequest;

public class Fuwuqi {
		public static void main(String[] args){
			ServerSocket server=null;
			try {
				server = new ServerSocket(6000);
				Socket client=server.accept();
				//读数据
				//DataInputStream dis=new DataInputStream(client.getInputStream());
				DataOutputStream dos=new DataOutputStream(client.getOutputStream());
				//--------------------------------------------
				 //接受数据，但不允许有中文，因为会乱码
				 DataInputStream dis = new DataInputStream(client.getInputStream());
				 byte[] buffer = new byte[10000];  //缓冲区的大小
				 dis.read(buffer);               //处理接收到的报文，转换成字符串
				/**
				* C++传递过来的中文字，需要转化一下。C++默认使用GBK。
				* GB2312是GBK的子集，只有简体中文。因为数据库用GB2312，所以这里直接转为GB2312
				* */
				String message = new String(buffer,"GB2312").trim();
				
				while(true){
					System.out.println("-----用户访问服务器-----");
					String mss=dis.readUTF();
					System.out.println(mss);
					System.out.println(message);
					dos.writeUTF(mss);
					dos.flush();
				}		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
}	
