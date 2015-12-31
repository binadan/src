package com.news;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Fuwuqi {
	/**
	 * @param args
	 */
	public static final int SERVER_PORT = 6000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("VNTCenter.main()===TCP SERVER==============");
		try {
			ServerSocket vntServer = new ServerSocket(SERVER_PORT);
			System.out.println("Listening Port is " + vntServer.getLocalPort()
					+ "...");
			while (true) {
				Socket vntClient = vntServer.accept();
				System.out.println("have a client entering , the IP is "
						+ vntClient.getInetAddress() + "...");
				System.out.println("have a client entering , the Port is "
						+ vntClient.getPort() + "...");
				new GetGpsThreadFun(vntClient).start();
			}
			// vntClient.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
