package io.github.duolabmeng6.javaefun.模块;

import cn.hutool.http.HttpUtil;

public class HTTP {
    public static String 网页_访问_get(String url){
        return HttpUtil.get(url);
    }
    public static String 网页_访问_get(String url,int 超时时长){
        //-1表示默认超时，单位毫秒
        return HttpUtil.get(url,超时时长);
    }
    public static String 网页_访问_post(String url,String 提交内容){
        return HttpUtil.post(url,提交内容);
    }
    public static String 网页_访问_post(String url,String 提交内容,int 超时时长){
        return HttpUtil.post(url,提交内容,超时时长);
    }
    

    

}
