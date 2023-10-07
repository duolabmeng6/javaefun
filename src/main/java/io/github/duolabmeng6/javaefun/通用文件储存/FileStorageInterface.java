package io.github.duolabmeng6.javaefun.通用文件储存;

public interface FileStorageInterface {
    boolean put(String key, byte[] data); //保存文件
    byte[] get(String key); //获取文件
    boolean delete(String key); //删除文件
    boolean move(String oldKey, String newKey); //移动文件
    boolean copy(String oldKey, String newKey); //复制文件
    boolean exists(String key); //文件是否存在
    int size(String key); //文件大小
    String[] list(String key); //文件列表
    String mimeType(String key); //文件类型

}