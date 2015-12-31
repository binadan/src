package com.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Kehuduan {
	public static void main(String[] args) {
		Socket client=null;
		try {
			client = new Socket("127.0.0.1",6000);
			BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
			//BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			while(true){			
				String s=console.readLine();
				dos.writeUTF(s);
				dos.flush();
				//dos.writeUTF("发送完毕");
				System.out.println(dis.readUTF());
			}
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
