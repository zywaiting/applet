package com.zy.applet.test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

public class TestAse {

    public static String encrypt(String data, String key) throws Exception {
        String iv = MD5_16(key);//加密向量
        Cipher cipher = Cipher.getInstance("AES/CBC/NOPadding");
        int blockSize = cipher.getBlockSize();

        byte[] dataBytes = data.getBytes();
        int plaintextLength = dataBytes.length;
        if (plaintextLength % blockSize != 0) {
            plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
        }

        byte[] plaintext = new byte[plaintextLength];
        System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encrypted = cipher.doFinal(plaintext);

        return new String(Base64.getEncoder().encode(encrypted));
    }


    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    public static String MD5_16(String s) throws Exception {
        return MD5(s).substring(8, 24);
    }

    public static String MD5(String src) throws Exception {
        final byte[] bytes = src.getBytes();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bytes);
        byte[] digestBytes = messageDigest.digest();
        char[] chars = new char[digestBytes.length * 2];
        int k = 0;
        for (byte b : digestBytes) {
            chars[k++] = hexDigits[b >>> 4 & 15];
            chars[k++] = hexDigits[b & 15];
        }
        return new String(chars);
    }


    public static void main(String[] args) throws Exception {

        System.out.println(encrypt("123456", "shoukala.1234~~!"));//加密前卡密123456

    }
}
