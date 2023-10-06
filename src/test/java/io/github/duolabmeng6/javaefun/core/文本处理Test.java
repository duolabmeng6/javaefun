package io.github.duolabmeng6.javaefun.core;

import org.junit.Test;

import java.util.List;

import static io.github.duolabmeng6.javaefun.ecore.接口文本处理.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;



public class 文本处理Test {
    @Test
    public void 测试_文本处理() {
        assertEquals("12", 文本_取左边("1234567890", "3"));
        assertEquals("67890", 文本_取右边("1234567890", "5"));
        assertEquals("234", 文本_取出中间文本("1234567890", "1", "5"));
        assertEquals("2", strCut("1234567890", "1$3"));
        assertEquals("12", strCut("1234567890", "$3"));
        assertEquals("4567890", strCut("1234567890", "3$"));

        assertEquals(3, 取文本长度("123"));
        assertEquals("123", 取文本左边("123456", 3));
        assertEquals("123456", 取文本左边("123456", 7));
        assertEquals("456", 取文本右边("123456", 3));
        assertEquals("123456", 取文本右边("123456", 7));
        assertEquals("23", 取文本中间("123456", 1, 2));
        assertEquals("A", 字符(65));
        assertEquals(65, 取代码("A"));
        assertEquals(0, 取代码(""));

        assertEquals(2, 寻找文本("123456", "3", 0));
        assertEquals(2, 倒找文本("123456", "3", 0));
        assertEquals("ABC", 到大写("abc"));
        assertEquals("abc", 到小写("ABC"));
        assertEquals("abc123456789,./;'[]abc123456789,./;'[]", 到半角("abc123456789,./;'[]ａｂｃ１２３４５６７８９，．／；＇［］"));
        assertEquals("ａｂｃ１２３４５６７８９，．／；＇［］", 到全角("abc123456789,./;'[]"));

        assertEquals("abc", 删首空("     abc"));
        assertEquals("abc", 删尾空("abc          "));
        assertEquals("abc", 删首尾空("         abc          "));
        assertEquals("abc", 删全部空("a   b     c          "));


        assertEquals("4567890", 子文本替换("1234567890123", "123", ""));
        assertEquals("          ", 取空白文本(10));
        assertEquals("aaaaaaaaaa", 取重复文本(10, "a"));

        String[] resarr = {"1", "2", "3"};
        assertArrayEquals(resarr, 分割文本("1 2 3", " "));

    }

    @Test
    public void 测试_工具类函数() {
        String 内容;
        内容 = 文本_取随机字母(10, 0);
        System.out.println(内容);
        内容 = 文本_取随机字母(10, 1);
        System.out.println(内容);
        内容 = 文本_取随机字母(10, 2);
        System.out.println(内容);
        内容 = 文本_取随机字母和数字(10);
        System.out.println(内容);
        内容 = 文本_取随机数字(10);
        System.out.println(内容);

        内容 = 文本_取随机汉字(10);
        System.out.println(内容);

        内容 = 文本_取随机姓氏(true);
        System.out.println(内容);
        内容 = 文本_取随机姓氏(false);
        System.out.println(内容);
        内容 = 文本_取随机手机号();
        System.out.println(内容);
        内容 = 文本_取随机邮箱();
        System.out.println(内容);
        内容 = 文本_取随机IP();
        System.out.println(内容);

    }

    @Test
    public void 测试_工具类函数2() {
        assertEquals("abc123", 文本_删左边("123abc123", 3));
        assertEquals("123abc", 文本_删右边("123abc123", 3));
        assertEquals("123123", 文本_删中间("123abc123", 3, 3));
    }

    @Test
    public void 测试_工具类函数3() {


        assertEquals("abc", 文本区分_只取字母("123abc123", 0));
        assertEquals("123123", 文本区分_只取数字("123abc123"));
        assertEquals(true, 判断文本("123abc123", "123"));
        assertEquals(false, 判断文本("123abc123", "aaa"));
        assertEquals(true, 判断文本("123abc123", new String[]{"123", "456", "789"}));
        assertEquals("123", 判断文本s("123abc123", new String[]{"123"}));

        List<String> 内容;
        内容 = 文本_取手机号码("手机号:13588899988 手机号:13588899987");
        assertArrayEquals(new String[]{"13588899988", "13588899987"}, 内容.toArray());

        内容 = 文本_取IP地址("192.168.1.1");
        assertArrayEquals(new String[]{"192.168.1.1"}, 内容.toArray());

        内容 = 文本_取电话号码("010-33366669");
        assertArrayEquals(new String[]{"010-33366669"}, 内容.toArray());

        内容 = 文本_取QQ号码("666655555");
        assertArrayEquals(new String[]{"666655555"}, 内容.toArray());

        内容 = 文本_取邮政编码("520420");
        assertArrayEquals(new String[]{"520420"}, 内容.toArray());

        内容 = 文本_取身份证号码("44666655559999666");
        assertArrayEquals(new String[]{"44666655559999666"}, 内容.toArray());

        String 内容2 = 文本_取双字节字符("你好 hello123,./");
        assertEquals("你好", 内容2);

        内容 = 文本_取网址("http://www.github,com");
        assertArrayEquals(new String[]{"http://www.github,com"}, 内容.toArray());

        内容 = 文本_取IP跟端口("192.168.0.1:9998");
        assertArrayEquals(new String[]{"192.168.0.1:9998"}, 内容.toArray());

        内容 = 文本_取邮箱号码("666666@qq.com");
        assertArrayEquals(new String[]{"666666@qq.com"}, 内容.toArray());

        内容2 = 文本_大小写翻转("abc ABC");
        assertEquals("ABC abc", 内容2);


        assertEquals(false, 文本_是否为大写字母("abc ABC"));
        assertEquals(true, 文本_是否为大写字母("ABC"));
        assertEquals(true, 文本_是否为小写字母("abc"));
        assertEquals(true, 文本_是否为字母("abc"));
        assertEquals(false, 文本_是否为字母("abcABC123"));
        assertEquals(true, 文本_是否为数字字母("abcABC123"));
        assertEquals(false, 文本_是否为数字("abcABC123"));
        assertEquals(true, 文本_是否为数字("123465"));
        assertEquals(3, 文本_取出现次数("AAAaaaBBBbbb", "b"));
        assertEquals("Apple", 文本_单词首字母大写("apple"));

        assertEquals("  apple   ", 文本_填充空格_居中("apple", 10));
        assertEquals("apple     ", 文本_填充空格_左对齐("apple", 10));
        assertEquals("     apple", 文本_填充空格_右对齐("apple", 10));
        assertEquals("00000apple", 文本_自动补零("apple", 10));

        assertEquals("a-b-c", 数组_转文本(new String[]{"a", "b", "c"}, "-"));

        内容 = 文本_取中间_批量("aaa123bbb aaa456bbb aaa789bbb", "aaa", "bbb");
        assertArrayEquals(new String[]{"123", "456", "789"}, 内容.toArray());


        List<String> 内容3 = 文本_逐字分割("你好祖国hello");
        assertArrayEquals(new String[]{"你", "好", "祖", "国", "h", "e", "l", "l", "o"}, 内容3.toArray());


        assertEquals("olleh,国祖,好你", 文本_颠倒("你好,祖国,hello"));

    }

    @Test
    public void 测试_工具类函数4() {
        assertEquals("NI HAO ,ZU GUO ,hello", 文本_转拼音("你好,祖国,hello"));

    }
}