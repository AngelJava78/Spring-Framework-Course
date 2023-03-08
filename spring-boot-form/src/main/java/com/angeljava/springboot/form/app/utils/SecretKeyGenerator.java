package com.angeljava.springboot.form.app.utils;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component 
public class SecretKeyGenerator {
	public static String generateSecretKey() {
	    try {
	        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	        keyGen.init(256); // you can customize the key size here
	        SecretKey secretKey = keyGen.generateKey();
	        byte[] encodedKey = secretKey.getEncoded();
	        return Base64.getEncoder().encodeToString(encodedKey);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
