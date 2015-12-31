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
		public void main(){
			ServerSocket server = null;
			InputStream is = null;
			OutputStream os = null;
			int count = 1;
			try {
				server = new ServerSocket(4000);
				System.out.println("等待客户端连接");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (true) {
				Socket client = null;
				try {
					client = server.accept();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedWriter writer = null;
				try {
					writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
/*				is = client.getInputStream();
				os = client.getOutputStream();
				DataInputStream dis = new DataInputStream(is);
				DataOutputStream dos = new DataOutputStream(os);*/
/*				if ((s = dis.readUTF()) != null) {
					System.out.println(s);
					System.out.println("from" + client.getInetAddress());
					System.out.println("from" + client.getPort());
				}
				dos.writeUTF("hello,this is serverSocket");*/
				System.out.println("恭喜你 连接成功 您是第"+count+++"位用户");
				try {
					writer.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}	
