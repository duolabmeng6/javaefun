package io.github.duolabmeng6.javeefun.core;

import cn.hutool.json.JSONUtil;

public class Json工具类 {

    public static void main(String[] args) {
        String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
        JSONUtil.parseObj(jsonStr);
    }
}
