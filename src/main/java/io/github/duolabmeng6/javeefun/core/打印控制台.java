package io.github.duolabmeng6.javeefun.core;

import cn.hutool.core.lang.Console;
import com.sun.nio.zipfs.ZipDirectoryStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class 打印控制台 {
    public static void 打印l(String 文本模板, Object... 值){
        //"sf{},士大夫{}","1","2"
        Console.log(文本模板, 值);
    }
    public static void 打印x(Object... 值){
        //给python一样 多个参数可以用,隔开
        if (值!=null&&值.length>0){
            for (Object x: 值){
                System.out.print(x);
                System.out.print(" ");
            }
        }
    }
    public static void 打印(String 文本模板, Object... 值){
        //"sf{},士大夫{}","1","2"
        Console.print(文本模板, 值);
    }



}
