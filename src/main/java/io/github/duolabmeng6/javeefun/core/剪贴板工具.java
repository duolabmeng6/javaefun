package io.github.duolabmeng6.javeefun.core;

import cn.hutool.core.swing.clipboard.ClipboardUtil;

import java.awt.*;

public class 剪贴板工具 {
    public static String 获取剪贴板文本(){
        return ClipboardUtil.getStr();
    }
    public static void 设置剪贴板文本(String 文本){
         ClipboardUtil.setStr(文本);
    }
    public static void 设置图片到剪贴板(Image image){
        ClipboardUtil.setImage(image);
    }
    public static Image 获取剪贴板图片(){
        return ClipboardUtil.getImage();
    }

}
