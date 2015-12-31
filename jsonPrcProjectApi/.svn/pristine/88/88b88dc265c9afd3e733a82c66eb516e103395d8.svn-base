package com.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Kehuduan {
	public void main() {
			try {
				Socket socket = new Socket("127.0.0.1", 4000); 
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				writer.write("服务器，你好啊！");
				System.out.println("服务器，你好啊！");
				writer.newLine();
				writer.write("我是Java程序编写的客户端！");
				System.out.println("我是Java程序编写的客户端！");
				writer.newLine();
				writer.flush();
				socket.close();
				System.out.println("我说完了");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
