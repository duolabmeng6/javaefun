package io.github.duolabmeng6.javeefun.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import static io.github.duolabmeng6.javeefun.core.文本处理.*;


public class 文件操作 {
    public static String 取运行目录() {
        File directory = new File(".");
        String dir = "";

        try {
            dir = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dir;
    }

    public static String 取当前目录() {
        return System.getProperty("user.dir");
    }

    public static boolean 写到文件(String 文件路径, byte[] 数据) {
        try {
            FileUtils.writeByteArrayToFile(new File(文件路径), 数据);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static byte[] 读入文件(String 文件路径) {
        byte[] data = new byte[0];
        try {
            data = FileUtils.readFileToByteArray(new File(文件路径));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


    public static boolean 删除文件(String 文件路径) {
        return FileUtils.deleteQuietly(new File(文件路径));
    }


    public static boolean 复制文件(String 被复制的文件名, String 复制到的文件名) {
        try {
            FileUtils.copyFile(new File(被复制的文件名), new File(复制到的文件名));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean 移动文件(String 被移动的文件, String 移动到的位置) {
        try {
            FileUtils.moveFile(new File(被移动的文件), new File(移动到的位置));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean 文件更名(String 原文件名, String 新文件名) {

        return 移动文件(原文件名, 新文件名);
    }


    public static boolean 创建目录(String 目录路径) {
        try {
            FileUtils.forceMkdir(new File(目录路径));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean 删除目录(String 目录路径) {
        try {
            FileUtils.deleteDirectory(new File(目录路径));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean 复制目录(String 被复制的目录, String 复制到的目录) {
        try {
            FileUtils.copyDirectory(new File(被复制的目录), new File(复制到的目录));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean 移动目录(String 被移动的目录, String 移动到的目录) {
        try {
            FileUtils.moveDirectory(new File(被移动的目录), new File(移动到的目录));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static String 路径_取扩展名(String 文件路径) {
        return FilenameUtils.getExtension(文件路径);
    }

    public static String 路径_取文件名(String 文件路径) {
        return FilenameUtils.getName(文件路径);
    }

    public static String 路径_取文件名(String 文件路径, boolean 是否需要拓展名) {
        if (是否需要拓展名 == true) {
            return FilenameUtils.getName(文件路径);
        } else {
            return FilenameUtils.getBaseName(文件路径);
        }
    }

    public static String 路径_取目录名(String 文件路径) {
        Path path = Paths.get(文件路径);
        return FilenameUtils.getBaseName(path.getParent().toString());
    }

    public static boolean 文件_检查权限(String 文件路径, int 权限) {
        // 1 是否可读 2 是否可写 3 是否可执行，返回 true 代表有 false 代表没有权限
        File file = new File(文件路径);
        if (权限 == 1) {
            return file.canRead();
        }
        if (权限 == 2) {
            return file.canWrite();
        }
        if (权限 == 3) {
            return file.canExecute();
        }
        return false;
    }

    public static boolean 文件_修改权限(String 文件路径, int 权限, boolean value) {
        // 1 是否可读 2 是否可写 3 是否可执行，返回 true 代表有 false 代表没有权限
        File file = new File(文件路径);
        if (权限 == 1) {
            return file.setReadable(value);
        }
        if (权限 == 2) {
            return file.setWritable(value);
        }
        if (权限 == 3) {
            return file.setExecutable(value);
        }
        return false;
    }

    public static boolean 文件是否存在(String 文件路径) {
        File file = new File(文件路径);
        return file.exists();
    }

    public static boolean 文件_是否为目录(String 文件路径) {
        File file = new File(文件路径);
        return file.isDirectory();
    }

    public static boolean 文件_是否为文件(String 文件路径) {
        File file = new File(文件路径);
        return file.isFile();
    }

    /**
     * 通过 返回以毫秒为单位的最后修改时间
     *
     * @param 文件路径
     * @return
     */
    public static long 文件_修改文件时间(String 文件路径) {
        if (文件是否存在(文件路径) == false) {
            return 0;
        }
        File file = new File(文件路径);
        try {
            return FileUtils.lastModified(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static long 文件_取文件大小(String 文件路径) {
        if (文件是否存在(文件路径) == false) {
            return 0;
        }

        File file = new File(文件路径);
        return FileUtils.sizeOf(file);
    }

    public static String 文件_取友好文件大小(long 文件大小) {
        return FileUtils.byteCountToDisplaySize(文件大小);
    }


    public static List<String> 文件_枚举(String 欲寻找的目录) {
        Collection<File> listFiles = FileUtils.listFiles(new File(欲寻找的目录), null, true);
        List<String> result = new ArrayList<String>();
        for (File file : listFiles) {
            result.add(file.getAbsolutePath());
        }
        return result;
    }

    public static List<String> 文件_枚举(String 欲寻找的目录, String 过滤扩展名) {
        String[] arr = 过滤扩展名.split(","); // txt,jpg,jpeg,exe

        Collection<File> listFiles = FileUtils.listFiles(new File(欲寻找的目录), arr, true);
        List<String> result = new ArrayList<String>();
        for (File file : listFiles) {
            result.add(file.getAbsolutePath());
        }
        return result;
    }

    public static List<String> 目录_枚举(String 欲寻找的目录) {
        Collection<File> listFiles = FileUtils.listFilesAndDirs(new File(欲寻找的目录), TrueFileFilter.INSTANCE, null);
        List<String> result = new ArrayList<String>();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                result.add(file.getAbsolutePath());

            }
        }
        return result;
    }

    public static String 文件_取父目录(String 文件路径) {
        return 路径_取目录名(文件路径);
    }

    public static boolean 文件_写出(String 文件路径, byte[] 欲写入文件的数据) {
        String dir = 文件_取父目录(文件路径);
        if (文件是否存在(dir)) {
            创建目录(dir);
        }
        return 写到文件(文件路径, 欲写入文件的数据);
    }

    public static boolean 文件_追加文本(String 文件路径, String 欲追加的文本) {
        try {
            FileUtils.write(new File(文件路径), 欲追加的文本, "utf-8", true);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String 读入文本(String 文件路径) {
        try {
            return FileUtils.readFileToString(new File(文件路径), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static boolean 文件_保存(String 文件路径, byte[] 欲写入文件的数据) {
        String dir = 文件_取父目录(文件路径);
        if (文件是否存在(dir)) {
            创建目录(dir);
            return 写到文件(文件路径, 欲写入文件的数据);
        } else {
            byte[] data = 读入文件(文件路径);
            if (欲写入文件的数据.equals(data)) {

            } else {
                return 写到文件(文件路径, 欲写入文件的数据);
            }

        }
        return true;

    }

    public static String 文件从列表中选取存在的文件路径(String[] 文件路径) {
        for (String v : 文件路径) {
            if (文件是否存在(v)) {
                return v;
            }
        }
        return "";
    }


    public static String 路径优化(String path) {
        if (寻找文本(path, "\\") > -1) {
            path = 子文本替换(path, "\\", "/");
        }
        if (寻找文本(path, "\\\\") > -1) {
            path = 子文本替换(path, "\\\\", "/");
        }
        if (寻找文本(path, "/\\") > -1) {
            path = 子文本替换(path, "/\\", "/");
        }
        if (寻找文本(path, "//") > -1) {
            path = 子文本替换(path, "//", "/");
        }
        Path nPath = Paths.get(path);
        path = nPath.toString();
        return path;
    }

}
