package com.test;

public class aaa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String repall="src=22&method=find";
		//System.out.println(aa.substring(aa.lastIndexOf("=")+1));
		String id=repall.substring(repall.indexOf("=")+1,repall.indexOf("&"));
		String id2=repall.substring(repall.lastIndexOf("=")+1);
		System.out.println(id);
	}

}
