package com.zx.tianjing.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thetransactioncompany.jsonrpc2.JSONRPC2ParseException;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.server.Dispatcher;
import com.zx.tianjing.handler.Handler;

public class MessageServlet extends HttpServlet {
	StringBuilder sb;

	Gson gson = new Gson();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		Dispatcher dispatcher = new Dispatcher();
		dispatcher.register(new Handler());
		BufferedReader br;
		try {
			 request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain");
			PrintWriter writer = response.getWriter();
			br = new BufferedReader(new InputStreamReader(
					(ServletInputStream) request.getInputStream()));
			String line = null;
			sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println("Request: \n" + sb.toString());
			// hanzi = toUnicode(hanzi, false);
			String newString = null;
			if (sb.toString().contains("keyword\":[")) {

				int index_begin = sb.toString().indexOf("keyword\":[");
				int index_end = sb.toString().indexOf("]},\"jsonrpc\":\"2.0\"");
				String[] a = sb.toString().substring(index_begin + 10,
						index_end).split(",");
				System.out.println(a + "++++++++++");
				byte[] b = new byte[a.length];

				for (int i = 0; i < a.length; i++) {
					int bi = Integer.parseInt(a[i]);
					byte temp = (byte) bi;
					b[i] = temp;
				}
				String s = new String(b, "unicode");
				newString = sb.toString()
						.replace(
								sb.toString().substring(index_begin + 9,
										index_end + 1), "\"" + s + "\"");
			}else 
				newString = sb.toString();
			JSONRPC2Request req = JSONRPC2Request.parse(newString);
			System.out.println(req.getMethod());
			JSONRPC2Response resp = dispatcher.dispatch(JSONRPC2Request
					.parse(newString), null);
			System.out.println("Response: \n" + resp);
			writer.print(resp);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONRPC2ParseException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		this.doGet(request, response);

	}
}
