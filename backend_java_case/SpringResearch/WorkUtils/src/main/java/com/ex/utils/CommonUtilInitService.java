package com.ex.utils;

public class CommonUtilInitService {

	public static void init(String publicKey, String privateKey) {
		
		CommonConstant.Constant_PRIVATE_KEY = privateKey;
		CommonConstant.Constant_PUBLIC_KEY = publicKey;
	}
}
