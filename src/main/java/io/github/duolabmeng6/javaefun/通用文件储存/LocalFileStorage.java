package io.github.duolabmeng6.javaefun.通用文件储存;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LocalFileStorage extends FileStorageAbstract implements FileStorageInterface{
    private String storagePath; // 储存路径

    // 使用互斥锁来保护文件操作
    private final Object lock = new Object();

    public LocalFileStorage(String path) {
        storagePath = path;
        if (storagePath.isEmpty()) {
            storagePath = "./storage/";
        }
        if (storagePath.charAt(storagePath.length() - 1) != '/') {
            storagePath = storagePath + "/";
        }
    }

    @Override
    public boolean put(String key, byte[] data) {
        synchronized (lock) {
            try {
                Path filePath = Path.of(storagePath + key);
                // 确保目录存在，如果不存在则创建
                Path directoryPath = filePath.getParent();
                if (!Files.exists(directoryPath)) {
                    Files.createDirectories(directoryPath);
                }
                Files.write(filePath, data);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public byte[] get(String key) {
        synchronized (lock) {
            try {
                Path filePath = Path.of(storagePath + key);
                return Files.readAllBytes(filePath);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public boolean delete(String key) {
        synchronized (lock) {
            try {
                Path filePath = Path.of(storagePath + key);
                Files.delete(filePath);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public boolean move(String oldKey, String newKey) {
        synchronized (lock) {
            Path targetFilePath = null;
            try {
                Path sourceFilePath = Path.of(storagePath + oldKey);
                targetFilePath = Path.of(storagePath + newKey);
                Files.move(sourceFilePath, targetFilePath);
                return true;
            } catch (FileAlreadyExistsException e) {
                System.out.println("File already exists: " + targetFilePath);
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public boolean copy(String oldKey, String newKey) {
        synchronized (lock) {
            try {
                Path sourceFilePath = Path.of(storagePath + oldKey);
                Path targetFilePath = Path.of(storagePath + newKey);
                Files.copy(sourceFilePath, targetFilePath);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public boolean exists(String key) {
        synchronized (lock) {
            Path filePath = Path.of(storagePath + key);
            return Files.exists(filePath);
        }
    }

    @Override
    public int size(String key) {
        synchronized (lock) {
            try {
                Path filePath = Path.of(storagePath + key);
                return (int) Files.size(filePath);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    @Override
    public String[] list(String key) {
        synchronized (lock) {
            try {
                Path directoryPath = Path.of(storagePath + key);
                List<String> fileList = new ArrayList<>();
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {
                    for (Path file : stream) {
                        fileList.add(file.getFileName().toString());
                    }
                }
                return fileList.toArray(new String[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return new String[0];
            }
        }
    }

    @Override
    public String mimeType(String key) {
        synchronized (lock) {
            try {
                Path filePath = Path.of(storagePath + key);
                return Files.probeContentType(filePath);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
