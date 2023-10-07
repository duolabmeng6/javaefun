package io.github.duolabmeng6.javaefun.加密解密;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MD5 {
    public static String 加密(String 文本) {
        return (new cn.hutool.crypto.digest.MD5()).digestHex(文本);
    }
    public static byte[] 加密从文件(String 文件路径) throws IOException {
        cn.hutool.crypto.digest.MD5 m = new cn.hutool.crypto.digest.MD5();
        byte[] data = FileUtils.readFileToByteArray(new File(文件路径));
        return m.digest(data);
    }
}
