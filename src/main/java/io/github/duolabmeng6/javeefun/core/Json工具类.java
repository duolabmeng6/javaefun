package io.github.duolabmeng6.javeefun.core;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.Date;

public class Json工具类 {
    public static JSONObject 字符串转json对象(String 字符串){
        return JSONUtil.parseObj(字符串);
    }
    public static JSONObject java对象转json对象(Object obj){
        return JSONUtil.parseObj(obj);
    }
    public static JSONObject java对象转json对象(Object obj,boolean 是否跳过空值){
        return JSONUtil.parseObj(obj,是否跳过空值);
    }
    public static JSONObject java对象转json对象(Object obj,boolean 是否跳过空值,boolean 是否有序){
        return JSONUtil.parseObj(obj,是否跳过空值,是否有序);
    }

    public static String json对象转字符串(JSONObject json对象,boolean 是否格式化){
        if(是否格式化){
            return json对象.toStringPretty();
        }else {
            return json对象.toString();
        }

    }

}
