package io.github.duolabmeng6.javaefun.核心支持库;

import cn.hutool.core.io.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static io.github.duolabmeng6.javaefun.核心支持库.接口文本操作.子文本替换;
import static io.github.duolabmeng6.javaefun.核心支持库.接口文本操作.寻找文本;
import static io.github.duolabmeng6.javaefun.核心支持库.接口磁盘操作.*;

public interface 接口文件操作 {
    static String 取运行目录() {
        File directory = new File(".");
        String dir = "";

        try {
            dir = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dir;
    }

    static String 路径_取扩展名(String 文件路径) {
        return FilenameUtils.getExtension(文件路径);
    }

    static String 路径_取文件名(String 文件路径) {
        return FilenameUtils.getName(文件路径);
    }

    static String 路径_取文件名(String 文件路径, boolean 是否需要拓展名) {
        if (是否需要拓展名 == true) {
            return FilenameUtils.getName(文件路径);
        } else {
            return FilenameUtils.getBaseName(文件路径);
        }
    }

    static String 路径_取目录名(String 文件路径) {
        Path path = Paths.get(文件路径);
        return FilenameUtils.getBaseName(path.getParent().toString());
    }

    static boolean 文件_检查权限(String 文件路径, int 权限) {
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

    static boolean 文件_修改权限(String 文件路径, int 权限, boolean value) {
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


    static boolean 文件_是否为目录(String 文件路径) {
        File file = new File(文件路径);
        return file.isDirectory();
    }

    static boolean 文件_是否为文件(String 文件路径) {
        File file = new File(文件路径);
        return file.isFile();
    }

    /**
     * 通过 返回以毫秒为单位的最后修改时间
     *
     * @param 文件路径
     * @return
     */
    static long 文件_修改文件时间(String 文件路径) {
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

    static long 文件_取文件大小(String 文件路径) {
        if (文件是否存在(文件路径) == false) {
            return 0;
        }

        File file = new File(文件路径);
        return FileUtils.sizeOf(file);
    }

    static String 文件_取友好文件大小(long 文件大小) {
        return FileUtils.byteCountToDisplaySize(文件大小);
    }


    static List<String> 文件_枚举(String 欲寻找的目录) {
        Collection<File> listFiles = FileUtils.listFiles(new File(欲寻找的目录), null, true);
        List<String> result = new ArrayList<String>();
        for (File file : listFiles) {
            result.add(file.getAbsolutePath());
        }
        return result;
    }

    static List<String> 文件_枚举(String 欲寻找的目录, String 过滤扩展名) {
        String[] arr = 过滤扩展名.split(","); // txt,jpg,jpeg,exe

        Collection<File> listFiles = FileUtils.listFiles(new File(欲寻找的目录), arr, true);
        List<String> result = new ArrayList<String>();
        for (File file : listFiles) {
            result.add(file.getAbsolutePath());
        }
        return result;
    }

    static List<String> 目录_枚举(String 欲寻找的目录) {
        Collection<File> listFiles = FileUtils.listFilesAndDirs(new File(欲寻找的目录), TrueFileFilter.INSTANCE, null);
        List<String> result = new ArrayList<String>();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                result.add(file.getAbsolutePath());

            }
        }
        return result;
    }

    static String 文件_取父目录(String 文件路径) {
        return 路径_取目录名(文件路径);
    }

    static boolean 文件_写出(String 文件路径, byte[] 欲写入文件的数据) {
        String dir = 文件_取父目录(文件路径);
        if (文件是否存在(dir)) {
            创建目录(dir);
        }
        return 写到文件(文件路径, 欲写入文件的数据);
    }

    static boolean 文件_追加文本(String 文件路径, String 欲追加的文本) {
        try {
            FileUtils.write(new File(文件路径), 欲追加的文本, "utf-8", true);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    static String 读入文本(String 文件路径) {
        try {
            return FileUtils.readFileToString(new File(文件路径), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    static boolean 文件_保存(String 文件路径, byte[] 欲写入文件的数据) {
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


    static String 文件从列表中选取存在的文件路径(String[] 文件路径) {
        for (String v : 文件路径) {
            if (文件是否存在(v)) {
                return v;
            }
        }
        return "";
    }


    static String 路径优化(String path) {
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

    static boolean 清空文件夹(String 文件夹路径) {
        return FileUtil.clean(文件夹路径);
    }

    static boolean 是否为Windows环境() {
        return FileUtil.isWindows();
    }

    static String 获取用户路径() {
        return FileUtil.getUserHomePath();
    }

    static String 清除文件名中的在Windows下不支持的非法字符(String 文件名) {
        //（必须不包括路径，否则路径符将被替换）
        return FileUtil.cleanInvalid(文件名);
    }

    static boolean 文件名中是否包含在Windows下不支持的非法字符(String 文件名) {
        //（必须不包括路径，否则路径符将被替换）
        return FileUtil.containsInvalid(文件名);
    }

    static String 修复路径(String 路径) {
        return FileUtil.normalize(路径);
    }

    static String 获取文件名(String 文件路径) {
        return FileUtil.getName(文件路径);
    }

    static String 获取文件后缀名(String 文件路径) {
        return FileUtil.getSuffix(文件路径);
    }

    static String 获取当前系统的换行分隔符() {
        return FileUtil.getLineSeparator();
    }

    static String 取桌面目录() {
        return FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
    }


}
