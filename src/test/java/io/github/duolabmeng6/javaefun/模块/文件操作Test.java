package io.github.duolabmeng6.javaefun.模块;

import org.junit.Test;

import static io.github.duolabmeng6.javaefun.核心支持库.接口文件操作.*;
import static io.github.duolabmeng6.javaefun.核心支持库.接口磁盘操作.*;
import static org.junit.Assert.assertEquals;

public class 文件操作Test {
    public static void 判断是否相同(Object func, Object value) {
        assertEquals(func, value);
    }

    @Test
    public void 测试_文件操作() {
        System.out.println("取运行目录 " + 取运行目录());
        System.out.println("取当前目录 " + 取当前目录());
        System.out.println("写到文件 " + 写到文件("C:\\java\\javaefun\\test\\1.txt", "abc".getBytes()));
        System.out.println("读入文件 " + 读入文件("C:\\java\\javaefun\\test\\1.txt").length);
        System.out.println("复制文件 " + 复制文件("C:\\java\\javaefun\\test\\1.txt", "C:\\java\\javaefun\\test\\2.txt"));
        System.out.println("复制文件 " + 复制文件("C:\\java\\javaefun\\test\\1.txt", "C:\\java\\javaefun\\test\\3.txt"));
        System.out.println("复制文件 " + 复制文件("C:\\java\\javaefun\\test\\1.txt", "C:\\java\\javaefun\\test\\5.txt"));
        System.out.println("删除文件 " + 删除文件("C:\\java\\javaefun\\test\\2.txt"));
        System.out.println("移动文件 " + 移动文件("C:\\java\\javaefun\\test\\3.txt", "C:\\java\\javaefun\\test\\4.txt"));
        System.out.println("文件更名 " + 文件更名("C:\\java\\javaefun\\test\\5.txt", "C:\\java\\javaefun\\test\\6.txt"));

        System.out.println("删除文件 " + 删除文件("C:\\java\\javaefun\\test\\1.txt"));
        System.out.println("删除文件 " + 删除文件("C:\\java\\javaefun\\test\\3.txt"));
        System.out.println("删除文件 " + 删除文件("C:\\java\\javaefun\\test\\4.txt"));
        System.out.println("删除文件 " + 删除文件("C:\\java\\javaefun\\test\\6.txt"));


        System.out.println("创建目录 " + 创建目录("C:\\java\\javaefun\\test\\a"));
        System.out.println("复制目录 " + 复制目录("C:\\java\\javaefun\\test\\a", "C:\\java\\javaefun\\test\\b"));
        System.out.println("删除目录 " + 删除目录("C:\\java\\javaefun\\test\\b"));
        System.out.println("删除目录 " + 删除目录("C:\\java\\javaefun\\test\\a"));

        System.out.println("创建目录 " + 创建目录("C:\\java\\javaefun\\test\\c"));
        System.out.println("复制目录 " + 复制目录("C:\\java\\javaefun\\test\\c", "C:\\java\\javaefun\\test\\d"));
        System.out.println("删除目录 " + 删除目录("C:\\java\\javaefun\\test\\c"));
        System.out.println("删除目录 " + 删除目录("C:\\java\\javaefun\\test\\d"));


        System.out.println("创建目录 " + 创建目录("C:\\java\\javaefun\\test\\a1"));
        System.out.println("移动目录 " + 移动目录("C:\\java\\javaefun\\test\\a1", "C:\\java\\javaefun\\test\\a2"));
        System.out.println("删除目录 " + 删除目录("C:\\java\\javaefun\\test\\a2"));


        System.out.println("文件_写出 " + 文件_写出("C:\\java\\javaefun\\test\\c\\c\\1.txt", "abc".getBytes()));
        System.out.println("文件_写出 " + 文件_写出("C:\\java\\javaefun\\test\\a\\1.txt", "abc".getBytes()));

        System.out.println("文件_追加文本 " + 文件_追加文本("C:\\java\\javaefun\\test\\app.txt", "abc"));
        System.out.println("文件_追加文本 " + 文件_追加文本("C:\\java\\javaefun\\test\\app.txt", "abc"));
        System.out.println("文件_追加文本 " + 文件_追加文本("C:\\java\\javaefun\\test\\app.txt", "abc"));

        System.out.println("读入文本 " + 读入文本("C:\\java\\javaefun\\test\\app.txt"));

        System.out.println("文件_保存 " + 文件_保存("C:\\java\\javaefun\\test\\c\\c\\1.txt", "abc".getBytes()));


        String 文件路径 = 文件从列表中选取存在的文件路径(new String[]{
                "C:\\java\\javaefun\\test\\a.txt",
                "C:\\java\\javaefun\\test\\b.txt",
                "C:\\java\\javaefun\\test\\c.txt",
                "C:\\java\\javaefun\\test\\app.txt",
        });
        System.out.println("文件从列表中选取存在的文件路径 " + 文件路径);

        System.out.println("删除目录 " + 删除目录("C:\\java\\javaefun\\test"));

    }

    @Test
    public void 测试_路径操作() {
        System.out.println("路径_取扩展名 " + 路径_取扩展名("C:\\java\\javaefun\\test\\a2\\11.txt"));
        System.out.println("路径_取文件名 " + 路径_取文件名("C:\\java\\javaefun\\test\\a2\\11.txt"));
        System.out.println("路径_取文件名 " + 路径_取文件名("C:\\java\\javaefun\\test\\a2\\11.txt", false));

        System.out.println("路径_取目录名 " + 路径_取目录名("C:\\java\\javaefun\\test\\a2\\目录名字"));
        System.out.println("路径_取目录名 " + 路径_取目录名("C:\\java\\javaefun\\test\\a2\\目录名字\\11.txt"));


    }

    @Test
    public void 测试_文件权限() {
        System.out.println("写到文件 " + 写到文件("C:\\java\\javaefun\\test\\1.txt", "abc".getBytes()));

        System.out.println("路径_取目录名 可读" + 文件_检查权限("C:\\java\\javaefun\\test\\1.txt", 1));
        System.out.println("路径_取目录名 可写" + 文件_检查权限("C:\\java\\javaefun\\test\\1.txt", 2));
        System.out.println("路径_取目录名 可执行" + 文件_检查权限("C:\\java\\javaefun\\test\\1.txt", 3));

        System.out.println("路径_取目录名 可读" + 文件_修改权限("C:\\java\\javaefun\\test\\1.txt", 1, false));
        System.out.println("路径_取目录名 可写" + 文件_修改权限("C:\\java\\javaefun\\test\\1.txt", 2, false));
        System.out.println("路径_取目录名 可执行" + 文件_修改权限("C:\\java\\javaefun\\test\\1.txt", 3, false));

        System.out.println("路径_取目录名 可读" + 文件_检查权限("C:\\java\\javaefun\\test\\1.txt", 1));
        System.out.println("路径_取目录名 可写" + 文件_检查权限("C:\\java\\javaefun\\test\\1.txt", 2));
        System.out.println("路径_取目录名 可执行" + 文件_检查权限("C:\\java\\javaefun\\test\\1.txt", 3));


    }

    @Test
    public void 测试_文件操作2() {

        System.out.println("文件是否存在" + 文件是否存在("C:\\java\\javaefun\\test\\1.txt"));
        System.out.println("文件是否存在" + 文件是否存在("C:\\java\\javaefun\\test\\2.txt"));

        System.out.println("文件_是否为目录" + 文件_是否为目录("C:\\java\\javaefun\\test\\2.txt"));
        System.out.println("文件_是否为目录" + 文件_是否为目录("C:\\java\\javaefun\\test"));
        System.out.println("文件_是否为文件" + 文件_是否为文件("C:\\java\\javaefun\\test\\2.txt"));

        System.out.println("文件_修改文件时间" + 文件_修改文件时间("C:\\java\\javaefun\\test\\1.txt"));
        System.out.println("文件_取文件大小" + 文件_取文件大小("C:\\java\\javaefun\\test\\1.txt"));
        System.out.println("文件_取友好文件大小" + 文件_取友好文件大小(文件_取文件大小("C:\\java\\javaefun\\test\\1.txt")));


        System.out.println("文件_枚举");
        System.out.println(文件_枚举("C:\\java\\javaefun\\test\\").toString());
        System.out.println(文件_枚举("C:\\java\\javaefun\\test\\", "txt").toString());
        System.out.println(文件_枚举("C:\\java\\javaefun\\test\\", "exe").toString());
        System.out.println(目录_枚举("C:\\java\\javaefun\\test\\").toString());


        System.out.println("路径优化" + 路径优化("C://\\java\\//javaefun\\//test\\1.txt"));
        System.out.println("路径优化" + 路径优化("C:/java/javaefun/test\\1.txt"));
        System.out.println("路径优化" + 路径优化("./javaefun/test\\1.txt"));

    }
    @Test
    public void 测试3(){
        System.out.println("123");
        System.out.println(创建目录("C:\\Users\\Erin\\Desktop/1/1"));
    }

}