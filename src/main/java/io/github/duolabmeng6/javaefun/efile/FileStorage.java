package io.github.duolabmeng6.javaefun.efile;

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
