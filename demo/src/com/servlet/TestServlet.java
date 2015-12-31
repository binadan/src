package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TestServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	    ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
	    try {
			engine.eval("function test(){alert('调用成功');}");
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		/*Compilable compilable = (Compilable) engine;
		Bindings bindings = engine.createBindings(); // Local级别的Binding
		String script = ""; //
		// 定义函数并调用
		CompiledScript JSFunction = null;
		try {
			JSFunction = compilable.compile(script);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 解析编译脚本函数
		bindings.put("a", 1);
		bindings.put("b", 2); // 通过Bindings加入参数
		Object result = null;
		try {
			result = JSFunction.eval(bindings);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result); // 调用缓存着的脚本函数对象，Bindings作为参数容器传入
		response.sendRedirect("index.jsp");*/
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		//r.forward(request, response);
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
