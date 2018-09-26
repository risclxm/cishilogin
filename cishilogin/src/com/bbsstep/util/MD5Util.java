package com.bbsstep.util;

import java.math.BigInteger;
import java.security.MessageDigest;


/**
 * MD5加密工具类
 * 
 * @author zhule_000
 * 
 */
public class MD5Util {
	/**
	 * 给密码MD5加密
	 * @param password
	 * @return 返回加密后字符串
	 */
	public static String makePassword(String password) {
		MessageDigest md;
		try {
			// 生成一个MD5加密计算摘要
			md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(password.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			String pwd = new BigInteger(1, md.digest()).toString(16);
			return pwd;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
}
