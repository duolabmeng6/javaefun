package io.github.duolabmeng6.javeefun.core;

import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static io.github.duolabmeng6.javeefun.core.日期时间.*;
import static io.github.duolabmeng6.javeefun.core.日期时间函数.*;


public class 日期时间Test {


    @Test
    public void 测试_日期时间() {
        System.out.println("日期时间");
        日期时间 t = 取现行时间();
        日期时间 t2 = 取现行时间();
        System.out.println("到文本" + t.到文本());
        System.out.println("取时间戳" + t.取时间戳());
        System.out.println("取时间戳毫秒" + t.取时间戳毫秒());
        System.out.println("取日期" + t.取日期());
        System.out.println("取年" + t.取年());
        System.out.println("取月" + t.取月());
        System.out.println("取日" + t.取日());
        System.out.println("取小时" + t.取小时());
        System.out.println("取分钟" + t.取分钟());
        System.out.println("取秒" + t.取秒());
        System.out.println("取纳秒" + t.取纳秒());
        System.out.println("取每周的第几天" + t.取每周的第几天());
        System.out.println("取每年的第几天" + t.取每年的第几天());
        System.out.println("取每月的第几周" + t.取每月的第几周());
        System.out.println("取每年的第几周" + t.取每年的第几周());
        System.out.println("取月天数" + t.取月天数());
        t.设置年份(2020);
        t.设置月份(1);
        t.设置日(1);
        t.设置时(1);
        t.设置分钟(1);
        t.设置秒(1);
        System.out.println("到文本" + t.到文本());

        t.增减年份(1);
        t.增减月份(1);
        t.增减日(1);
        t.增减时(1);
        t.增减分钟(1);
        t.增减秒(1);
        System.out.println("到文本" + t.到文本());


        Duration t3 = t2.取时间间隔(t);
        System.out.println("toDays" + t3.toDays());
        System.out.println("toHours" + t3.toHours());
        System.out.println("toMillis" + t3.toMillis());
        System.out.println("toNanos" + t3.toNanos());


        //        日期时间 t = new 日期时间().New("now");
        //        System.out.println(t.到文本());


    }


}
