package io.github.duolabmeng6.javaefun.通用文件储存;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileStorageTest extends TestCase {
    public static void 判断是否相同(Object func, Object value) {
        assertEquals(func, value);
    }

    @Test
    public void testSomeMethod() {

        FileStorage fileStorage = new FileStorage();
        fileStorage.setStorage("local", new LocalFileStorage("./aa/"));
        fileStorage.setStorage("local2", new LocalFileStorage("./aa/a"));
        fileStorage.disk("local").put("key.txt", "hello".getBytes());
        byte[] data = fileStorage.disk("local").get("key.txt");
//        System.out.println(new String(data));
        判断是否相同(new String(data), "hello");
        fileStorage.disk("local2").put("key.txt", "hello".getBytes());
        byte[] data2 = fileStorage.disk("local2").get("key.txt");
//        System.out.println(new String(data2));
        判断是否相同(new String(data2), "hello");

    }
}