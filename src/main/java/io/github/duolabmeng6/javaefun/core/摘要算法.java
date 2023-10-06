package io.github.duolabmeng6.javaefun.core;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static io.github.duolabmeng6.javaefun.core.编码工具类.byteToHexString;

public class 摘要算法 {
    public static String md5(byte[] 明文){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(明文);
        return byteToHexString(md.digest());
    }
    public static String md2(byte[] 明文) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD2");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(明文);
        return byteToHexString(md.digest());
    }
    public static String sha1(byte[] 明文){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(明文);
        return byteToHexString(md.digest());
    }

    public static String sha224(byte[] 明文){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-224");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(明文);
        return byteToHexString(md.digest());
    }
    public static String sha256(byte[] 明文){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(明文);
        return byteToHexString(md.digest());
    }
    public static String sha384(byte[] 明文){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-384");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(明文);
        return byteToHexString(md.digest());
    }
    public static String sha512(byte[] 明文){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(明文);
        return byteToHexString(md.digest());
    }

    public static String HmacSHA1(byte[] 明文,byte[] 密钥){
        SecretKey key = new SecretKeySpec(密钥, "HmacSHA1");
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA1");
            mac.init(key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        mac.update(明文);
        return byteToHexString(mac.doFinal());
    }
    public static String HmacSHA256(byte[] 明文,byte[] 密钥){
        SecretKey key = new SecretKeySpec(密钥, "HmacSHA256");
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA256");
            mac.init(key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        mac.update(明文);
        return byteToHexString(mac.doFinal());
    }
    public static String HmacSHA384(byte[] 明文,byte[] 密钥){
        SecretKey key = new SecretKeySpec(密钥, "HmacSHA384");
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA384");
            mac.init(key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        mac.update(明文);
        return byteToHexString(mac.doFinal());
    }
    public static String HmacSHA512(byte[] 明文,byte[] 密钥){
        SecretKey key = new SecretKeySpec(密钥, "HmacSHA512");
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA512");
            mac.init(key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        mac.update(明文);
        return byteToHexString(mac.doFinal());
    }
    public static String HmacSHA224(byte[] 明文,byte[] 密钥){
        SecretKey key = new SecretKeySpec(密钥, "HmacSHA224");
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA224");
            mac.init(key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        mac.update(明文);
        return byteToHexString(mac.doFinal());
    }
    public static String HmacMD5(byte[] 明文,byte[] 密钥){
        SecretKey key = new SecretKeySpec(密钥, "HmacMD5");
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacMD5");
            mac.init(key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        mac.update(明文);
        return byteToHexString(mac.doFinal());
    }









}
