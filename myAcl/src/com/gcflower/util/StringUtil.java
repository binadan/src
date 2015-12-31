package com.gcflower.util;

public class StringUtil {
	
    public static String getString(int str) {
        return String.valueOf(str);
    }
    public static String getString(Object str) {
        return String.valueOf(str);
    }
    
	/**
	 * 获取编码+1并返回,截取后三位出来+1，再和前段数字组合
	 * 
	 * @param date
	 * @return
	 */
	public static String getOrderNumNext(String num) {
		
		if (num == null) {
			return "0001";
		}
		
		//取最后四位
		String lastNum = num.substring(num.length() - 4, num.length()); // 后段

		// 把后段转成数字类型
		int temp = Integer.parseInt(lastNum);
		temp = temp + 1;

		// 补0	
		if (temp < 10) {
			return DateUtil.getTodayString()+"000" + temp;	// 一位
		} else if (temp < 100) {
			return DateUtil.getTodayString()+"00" + temp;		// 两位
		}else if (temp < 1000) {
			return DateUtil.getTodayString()+"0" + temp;		// 三位
		}  else {
			return DateUtil.getTodayString()+ temp;		// 四位
		}

	}
	
	
	
}
