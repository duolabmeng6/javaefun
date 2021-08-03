package io.github.duolabmeng6.javeefun.core;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class 编码工具类 {
    public static String base64_字符串_加密(String text){
        //对字符串进行加密和解密
        String jieguo = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        return jieguo;
    }
    public static String base64_字符串_解密(String encoded) {
        //Base64 解密
        byte[] decoded = Base64.getDecoder().decode(encoded);
        //String decodeStr = new String(decoded);
        //System.out.println("Base 64 解密后：" + decodeStr);
        //结果强转成字符串进行返回
        return new String(decoded);
    }
    public static byte[] base64_解密_字符串_到字节(String text){
        byte [] decode=Base64.getDecoder().decode(text);
        return decode;
    }
    public static String base64_加密_字节_到字符串(byte[] b){
        String jieguo = Base64.getEncoder().encodeToString(b);
        return jieguo;
    }
    public static String 字符串_到byte(String text){
        return Arrays.toString(text.getBytes());
    }

    public static String byteToHexString(byte[] by) {
        //byte数组转hex文本
        StringBuffer SB = new StringBuffer();
        for (byte k : by) {
            int j = k;
            if (k < 0) {
                j = k + 256;
            }
            if (j < 16) {
                SB.append("0");
            }
            SB.append(Integer.toHexString(j));
        }
        return SB.toString();
    }

}
