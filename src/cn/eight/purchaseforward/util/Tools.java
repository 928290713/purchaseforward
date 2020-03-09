package cn.eight.purchaseforward.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Base64;
import java.util.Base64.Encoder;

public class Tools
{
	public static String md5(String str){
		MessageDigest md5=null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Encoder encoder =   Base64.getEncoder();
		String security_str = null;
		try {
			security_str = encoder.encodeToString(md5.digest(str.getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return security_str;
    }
}
