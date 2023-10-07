package io.github.duolabmeng6.javaefun.模块;

import junit.framework.TestCase;

public class 配置项Test extends TestCase {

    public void test加载配置项() {
        配置项 配置项= new 配置项("/Users/ll/Documents/GitHub/javaefun/src/main/java/io/github/duolabmeng6/javaefun/模块/1.ini");
        String a = 配置项.读配置项("a","b","");
        System.out.println(a);

    }
}