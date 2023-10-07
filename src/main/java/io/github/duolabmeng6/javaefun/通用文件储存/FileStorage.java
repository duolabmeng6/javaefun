package io.github.duolabmeng6.javaefun.通用文件储存;

import java.util.HashMap;
import java.util.Map;

public class FileStorage {
    private Map<String, FileStorageInterface> storageMap;

    public FileStorage() {
        storageMap = new HashMap<>();

    }

    public void setStorage(String name, FileStorageInterface storage) {
        storageMap.put(name, storage);
    }

    public FileStorageInterface disk(String name) {
        return storageMap.get(name);
    }
}
