package io.github.duolabmeng6.javaefun.通用文件储存;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocalFileStorageTest {
    private static final String TEST_STORAGE_PATH = "./test_storage/";

    private LocalFileStorage fileStorage;

    @Before
    public void setUp() {
        // 在每个测试方法之前创建 LocalFileStorage 实例
        fileStorage = new LocalFileStorage(TEST_STORAGE_PATH);
    }

    @Test
    public void testPutAndGetFile() {
        String key = "test_file.txt";
        byte[] testData = "This is a test.".getBytes();

        // 测试存储文件
        assertTrue(fileStorage.put(key, testData));

        // 测试获取文件
        byte[] retrievedData = fileStorage.get(key);
        assertNotNull(retrievedData);
        assertArrayEquals(testData, retrievedData);
    }

    @Test
    public void testDeleteFile() {
        String key = "test_delete_file.txt";
        byte[] testData = "This is a file to be deleted.".getBytes();

        // 存储测试文件
        assertTrue(fileStorage.put(key, testData));

        // 测试删除文件
        assertTrue(fileStorage.delete(key));

        // 文件应该不存在
        assertFalse(fileStorage.exists(key));
    }

    // 添加其他测试方法，测试其他功能

    @Test
    public void testListFilesInDirectory() {
        String directoryKey = "test_directory/";
        String[] filesToCreate = {"file1.txt", "file2.txt", "file3.txt"};

        // 创建一个测试目录并存储文件
        for (String file : filesToCreate) {
            byte[] testData = ("Contents of " + file).getBytes();
            assertTrue(fileStorage.put(directoryKey + file, testData));
        }

        // 测试列出目录中的文件
        String[] fileList = fileStorage.list(directoryKey);
        assertNotNull(fileList);
        assertEquals(filesToCreate.length, fileList.length);
        for (String file : filesToCreate) {
            assertTrue("File " + file + " should be in the list", contains(fileList, file));
        }
    }

    private boolean contains(String[] array, String value) {
        for (String item : array) {
            if (item.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
