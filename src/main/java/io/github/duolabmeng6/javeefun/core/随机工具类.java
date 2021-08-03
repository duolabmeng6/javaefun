package io.github.duolabmeng6.javeefun.core;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import io.github.duolabmeng6.javeefun.util.GuuidUtil;
import java.util.List;

public class 随机工具类 {
    public static <T> T 随机获取列表中的元素(List<T> 列表){
        return RandomUtil.randomEle(列表);
    }
    public static <T> T 随机获取数组中的元素(T[] 数组){
        return RandomUtil.randomEle(数组);
    }
    public static <T>List<T> 随机获取列表中的元素_多个(List<T> 列表, int 获取数量){
        return RandomUtil.randomEles(列表,获取数量);
    }
    public static String 随机获取字符串(int 长度){
        //获得一个随机的字符串（只包含数字和字符）
        return RandomUtil.randomString(长度);
    }
    public static String 随机获取字符串_大写(int 长度){
        //获得一个随机的字符串（只包含数字和大写字符）
        return RandomUtil.randomStringUpper(长度);
    }
    public static String 随机获取数字字符串(int 长度){
        return RandomUtil.randomNumbers(长度);
    }
    public static String 随机从文本中获取字符串(String 文本,int 长度){
        return RandomUtil.randomString(文本, 长度);
    }
    public static char 随机获取单个数字(){
        return RandomUtil.randomNumber();
    }
    public static String 随机生成UUID(boolean 是否去除横线){
        if(是否去除横线){
            return IdUtil.simpleUUID();
        }else {
            return IdUtil.randomUUID();
        }
    }
    public static String 随机生成UUID_高效(boolean 是否去除横线){
        if(是否去除横线){
            return IdUtil.fastSimpleUUID();
        }else {
            return IdUtil.fastUUID();
        }
    }

    public static long 生成订单UUID_雪花算法(){
        return GuuidUtil.getUUID();
    }



}
