package io.github.duolabmeng6.javaefun.核心支持库;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface 接口磁盘操作 {

    // 取磁盘总空间
    //  取磁盘剩余空间
    //取磁盘卷标
    // 置磁盘卷标
    // 改变驱动器


    /**
     * 改变当前的目录。
     *
     * @param 欲改变到的目录 欲改变到的目录
     * @return 是否成功改变目录，成功返回true，失败返回false
     */
    static boolean 改变目录(String 欲改变到的目录) {
        try {
            // 创建一个File对象，表示欲改变到的目录
            File 目录 = new File(欲改变到的目录);

            // 判断目录是否存在且是一个目录
            if (目录.exists() && 目录.isDirectory()) {
                // 使用File类的方法来改变当前目录
                System.setProperty("user.dir", 目录.getAbsolutePath());
                return true; // 成功改变目录
            } else {
                System.err.println("目录不存在或不是一个有效的目录: " + 欲改变到的目录);
                return false; // 目录不存在或不是有效目录，改变失败
            }
        } catch (SecurityException e) {
            System.err.println("无权限改变目录: " + 欲改变到的目录);
            return false; // 无权限改变目录，改变失败
        }
    }

    /**
     * 获取当前的目录。
     *
     * @return 当前目录的路径，如果失败则返回空文本
     */
    static String 取当前目录() {
        try {
            // 使用系统属性来获取当前目录
            String 当前目录 = System.getProperty("user.dir");
            return 当前目录;
        } catch (SecurityException e) {
            System.err.println("无权限获取当前目录");
            return ""; // 获取失败，返回空文本
        }
    }

    /**
     * 创建一个新的目录。
     *
     * @param 欲创建的目录名称 欲创建的目录名称
     * @return 是否成功创建目录，成功返回true，失败返回false
     */
    static boolean 创建目录(String 欲创建的目录名称) {
        try {
            // 创建一个File对象，表示欲创建的目录
            File 新目录 = new File(欲创建的目录名称);

            // 使用mkdirs()方法创建目录，如果目录已存在，它也会返回true
            boolean 创建成功 = 新目录.mkdirs();

            return 创建成功;
        } catch (SecurityException e) {
            System.err.println("无权限创建目录: " + 欲创建的目录名称);
            return false; // 创建失败，返回false
        }
    }


    static boolean 删除目录(String 目录路径) {
        try {
            FileUtils.deleteDirectory(new File(目录路径));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    static boolean 复制目录(String 被复制的目录, String 复制到的目录) {
        try {
            FileUtils.copyDirectory(new File(被复制的目录), new File(复制到的目录));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    static boolean 移动目录(String 被移动的目录, String 移动到的目录) {
        try {
            FileUtils.moveDirectory(new File(被移动的目录), new File(移动到的目录));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    static boolean 复制文件(String 被复制的文件名, String 复制到的文件名) {
        try {
            FileUtils.copyFile(new File(被复制的文件名), new File(复制到的文件名));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    static boolean 移动文件(String 被移动的文件, String 移动到的位置) {
        try {
            FileUtils.moveFile(new File(被移动的文件), new File(移动到的位置));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    static boolean 删除文件(String 文件路径) {
        return FileUtils.deleteQuietly(new File(文件路径));
    }


    static boolean 文件更名(String 原文件名, String 新文件名) {

        return 移动文件(原文件名, 新文件名);
    }

    static boolean 文件是否存在(String 文件路径) {
        File file = new File(文件路径);
        return file.exists();
    }


    /**
     * 寻找符合条件的文件或目录名称。
     *
     * @param 欲寻找的文件或目录名称 欲寻找的文件或目录名称，支持通配符
     * @param 欲寻找文件的属性    欲寻找文件的属性，可以省略，默认为搜寻除子目录外的所有文件
     * @return 匹配的文件名或目录名，如果没有匹配的则返回空文本
     */
    public static String 寻找文件(String 欲寻找的文件或目录名称, int 欲寻找文件的属性) {
        try {
            File currentDirectory = new File(System.getProperty("user.dir"));
            File[] matchingFiles = currentDirectory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    File file = new File(dir, name);
                    boolean isMatch = true;

                    // 检查文件属性
                    if ((欲寻找文件的属性 & 1) == 1 && !file.canRead()) {
                        isMatch = false;
                    }
                    if ((欲寻找文件的属性 & 2) == 2 && file.isHidden()) {
                        isMatch = false;
                    }
                    if ((欲寻找文件的属性 & 4) == 4 && file.isHidden()) {
                        isMatch = false;
                    }
                    if ((欲寻找文件的属性 & 16) == 16 && !file.isDirectory()) {
                        isMatch = false;
                    }
                    if ((欲寻找文件的属性 & 32) == 32 && !file.canRead()) {
                        isMatch = false;
                    }

                    // 检查文件名是否匹配
                    if (isMatch && name.matches(欲寻找的文件或目录名称)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });

            if (matchingFiles != null && matchingFiles.length > 0) {
                StringBuilder result = new StringBuilder();
                for (File file : matchingFiles) {
                    result.append(file.getName()).append("\n");
                }
                return result.toString().trim();
            } else {
                return ""; // 没有匹配的文件或目录
            }
        } catch (SecurityException e) {
            System.err.println("无权限寻找文件");
            return ""; // 无权限寻找文件，返回空文本
        }
    }

    /**
     * 获取指定文件的创建或最后修改时间。
     *
     * @param 文件名 文件名
     * @return 文件的创建或最后修改时间，如果文件不存在则返回100年1月1日
     */
    static String 取文件时间(String 文件名) {
        try {
            File 文件 = new File(文件名);

            // 检查文件是否存在
            if (!文件.exists()) {
                return "100年1月1日"; // 文件不存在，返回100年1月1日
            }

            // 获取文件的最后修改时间
            long 最后修改时间 = 文件.lastModified();
            Date 时间 = new Date(最后修改时间);
            SimpleDateFormat 格式化器 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            return 格式化器.format(时间);
        } catch (SecurityException e) {
            return "100年1月1日"; // 无权限获取文件时间，返回100年1月1日
        }
    }


    /**
     * 获取指定文件的长度（尺寸）。
     *
     * @param 文件名 文件名
     * @return 文件的长度（尺寸），单位是字节；如果文件不存在则返回 -1
     */
    static long 取文件尺寸(String 文件名) {
        try {
            File 文件 = new File(文件名);

            // 检查文件是否存在
            if (!文件.exists()) {
                System.err.println("文件不存在: " + 文件名);
                return -1; // 文件不存在，返回 -1
            }

            // 获取文件的长度（尺寸）
            return 文件.length();
        } catch (SecurityException e) {
            System.err.println("无权限获取文件尺寸: " + 文件名);
            return -1; // 无权限获取文件尺寸，返回 -1
        }
    }

    static boolean 写到文件(String 文件路径, byte[] 数据) {
        try {
            FileUtils.writeByteArrayToFile(new File(文件路径), 数据);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    static byte[] 读入文件(String 文件路径) {
        byte[] data = new byte[0];
        try {
            data = FileUtils.readFileToByteArray(new File(文件路径));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
