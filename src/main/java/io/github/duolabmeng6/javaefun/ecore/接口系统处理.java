package io.github.duolabmeng6.javaefun.ecore;

import cn.hutool.core.swing.clipboard.ClipboardUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public interface 接口系统处理 {

    static String 取剪辑板文本() {
        return ClipboardUtil.getStr();
    }

    static void 置剪辑板文本(String 文本) {
        ClipboardUtil.setStr(文本);
    }

    static void 置剪辑板图片(Image image) {
        ClipboardUtil.setImage(image);
    }

    static Image 取剪辑板图片() {
        return ClipboardUtil.getImage();
    }

    //清除剪辑版
    static void 清除剪辑版() {
        ClipboardUtil.setStr("");
    }


    /**
     * 获取屏幕当前显示区域的宽度，单位为像素点。
     *
     * @return 屏幕宽度（像素）
     */
    static int 取屏幕宽度() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) screenSize.getWidth();
    }

    /**
     * 获取屏幕当前显示区域的高度，单位为像素点。
     *
     * @return 屏幕高度（像素）
     */
    static int 取屏幕高度() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) screenSize.getHeight();
    }

    /**
     * 返回鼠标指针的当前水平位置，单位为像素点，相对于屏幕左边。
     *
     * @return 鼠标水平位置（像素）
     */
    static int 取鼠标水平位置() {
        Point 鼠标位置 = MouseInfo.getPointerInfo().getLocation();
        return (int) 鼠标位置.getX();
    }

    /**
     * 返回鼠标指针的当前垂直位置，单位为像素点，相对于屏幕顶部。
     *
     * @return 鼠标垂直位置（像素）
     */
    static int 取鼠标垂直位置() {
        Point 鼠标位置 = MouseInfo.getPointerInfo().getLocation();
        return (int) 鼠标位置.getY();
    }

    static void 信息框(String 提示信息, String 窗口标题) {
        javax.swing.JOptionPane.showMessageDialog(null, 提示信息, 窗口标题, javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * 获取自系统启动后经过的毫秒数。
     *
     * @return 自系统启动后经过的毫秒数
     */
    public static long 取启动时间() {
        return System.currentTimeMillis();
    }
    /**
     * 延时指定的毫秒数。
     *
     * @param 欲等待的时间 欲等待的时间（毫秒）
     */
    public static void 延时(int 欲等待的时间) {
        try {
            Thread.sleep(欲等待的时间);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    /**
     * 从 Windows 注册表中读取指定文本注册项的值。
     *
     * @param 根目录          根目录（1、#根类；2、#现行设置；3、#现行用户；4、#本地机器；5、#所有用户）
     * @param 全路径注册项名  全路径注册项名
     * @param 默认文本        默认文本（可选，如果注册项不存在时返回的默认值）
     * @return 注册项的值或默认文本
     */
    public static String 取文本注册项(int 根目录, String 全路径注册项名, String 默认文本) {
        Preferences preferences = null;
        switch (根目录) {
            case 1:
                preferences = Preferences.systemRoot();
                break;
            case 2:
                preferences = Preferences.systemNodeForPackage(接口系统处理.class);
                break;
            case 3:
                preferences = Preferences.userRoot();
                break;
            case 4:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
            case 5:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
        }

        if (preferences != null) {
            return preferences.get(全路径注册项名, 默认文本);
        } else {
            return 默认文本;
        }
    }


    /**
     * 从 Windows 注册表中读取指定数值注册项的值。
     *
     * @param 根目录          根目录（1、#根类；2、#现行设置；3、#现行用户；4、#本地机器；5、#所有用户）
     * @param 全路径注册项名  全路径注册项名
     * @param 默认数值        默认数值（可选，如果注册项不存在时返回的默认值）
     * @return 注册项的值或默认数值
     */
    public static int 取数值注册项(int 根目录, String 全路径注册项名, int 默认数值) {
        Preferences preferences = null;
        switch (根目录) {
            case 1:
                preferences = Preferences.systemRoot();
                break;
            case 2:
                preferences = Preferences.systemNodeForPackage(接口系统处理.class);
                break;
            case 3:
                preferences = Preferences.userRoot();
                break;
            case 4:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
            case 5:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
        }

        if (preferences != null) {
            return preferences.getInt(全路径注册项名, 默认数值);
        } else {
            return 默认数值;
        }
    }


    /**
     * 从 Windows 注册表中读取指定字节集注册项的值。
     *
     * @param 根目录           根目录（1、#根类；2、#现行设置；3、#现行用户；4、#本地机器；5、#所有用户）
     * @param 全路径注册项名   全路径注册项名
     * @param 默认字节集       默认字节集（可选，如果注册项不存在时返回的默认值）
     * @return 注册项的值或默认字节集
     */
    public static byte[] 取字节集注册项(int 根目录, String 全路径注册项名, byte[] 默认字节集) {
        Preferences preferences = null;
        switch (根目录) {
            case 1:
                preferences = Preferences.systemRoot();
                break;
            case 2:
                preferences = Preferences.systemNodeForPackage(接口系统处理.class);
                break;
            case 3:
                preferences = Preferences.userRoot();
                break;
            case 4:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
            case 5:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
        }

        if (preferences != null) {
            String base64Value = preferences.get(全路径注册项名, null);
            if (base64Value != null) {
                return Base64.getDecoder().decode(base64Value);
            }
        }

        return 默认字节集;
    }


    /**
     * 在 Windows 注册表中保存或建立指定的注册表项，并写入值。
     *
     * @param 根目录           根目录（1、#根类；2、#现行设置；3、#现行用户；4、#本地机器；5、#所有用户）
     * @param 全路径注册项名   全路径注册项名
     * @param 欲写入值         欲写入的值（数值、文本或字节集）
     * @return 写入是否成功，成功返回真，失败返回假
     */
    public static boolean 写注册项(int 根目录, String 全路径注册项名, Object 欲写入值) {
        Preferences preferences = null;
        switch (根目录) {
            case 1:
                preferences = Preferences.systemRoot();
                break;
            case 2:
                preferences = Preferences.systemNodeForPackage(接口系统处理.class);
                break;
            case 3:
                preferences = Preferences.userRoot();
                break;
            case 4:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
            case 5:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
        }

        if (preferences != null) {
            try {
                if (欲写入值 instanceof Number) {
                    preferences.put(全路径注册项名, 欲写入值.toString());
                } else if (欲写入值 instanceof String) {
                    preferences.put(全路径注册项名, (String) 欲写入值);
                } else if (欲写入值 instanceof byte[]) {
                    byte[] valueBytes = (byte[]) 欲写入值;
                    String base64Value = Base64.getEncoder().encodeToString(valueBytes);
                    preferences.put(全路径注册项名, base64Value);
                } else {
                    // 不支持的值类型
                    return false;
                }

                preferences.flush();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }


    /**
     * 在 Windows 注册表中删除指定的注册表项或注册表目录。
     *
     * @param 根目录           根目录（1、#根类；2、#现行设置；3、#现行用户；4、#本地机器；5、#所有用户）
     * @param 全路径注册项名   全路径注册项名
     * @return 删除是否成功，成功返回真，失败返回假
     */
    public static boolean 删除注册项(int 根目录, String 全路径注册项名) {
        Preferences preferences = null;
        switch (根目录) {
            case 1:
                preferences = Preferences.systemRoot();
                break;
            case 2:
                preferences = Preferences.systemNodeForPackage(接口系统处理.class);
                break;
            case 3:
                preferences = Preferences.userRoot();
                break;
            case 4:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
            case 5:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
        }

        if (preferences != null) {
            try {
                preferences.remove(全路径注册项名);
                preferences.flush();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }


    /**
     * 检查指定的注册表项是否存在。
     *
     * @param 根目录           根目录（1、#根类；2、#现行设置；3、#现行用户；4、#本地机器；5、#所有用户）
     * @param 全路径注册项名   全路径注册项名
     * @return 注册项是否存在，存在返回真，否则返回假
     */
    public static boolean 注册项是否存在(int 根目录, String 全路径注册项名) {
        Preferences preferences = null;
        switch (根目录) {
            case 1:
                preferences = Preferences.systemRoot();
                break;
            case 2:
                preferences = Preferences.systemNodeForPackage(接口系统处理.class);
                break;
            case 3:
                preferences = Preferences.userRoot();
                break;
            case 4:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
            case 5:
                preferences = Preferences.userNodeForPackage(接口系统处理.class);
                break;
        }

        if (preferences != null) {
            try {
                return preferences.nodeExists(全路径注册项名);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }


    /**
     * 读取指定配置文件中指定项目的文本内容。
     *
     * @param 配置文件名   配置文件名
     * @param 节名称     节名称
     * @param 配置项名称   配置项名称
     * @param 默认文本    默认文本
     * @return 配置项的文本内容
     */
    public static String 读配置项(String 配置文件名, String 节名称, String 配置项名称, String 默认文本) {
        try {
            Path filePath = Paths.get(配置文件名);
            Map<String, String> configData = new HashMap<>();

            for (String line : Files.readAllLines(filePath)) {
                // 假设配置文件的格式为"节名称:配置项名称=配置项值"
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String sectionName = parts[0].trim();
                    String keyValue = parts[1].trim();
                    String[] keyValueParts = keyValue.split("=");
                    if (keyValueParts.length == 2) {
                        String key = keyValueParts[0].trim();
                        String value = keyValueParts[1].trim();
                        configData.put(sectionName + ":" + key, value);
                    }
                }
            }

            String key = 节名称 + ":" + 配置项名称;
            if (configData.containsKey(key)) {
                return configData.get(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 默认文本;
    }


    /**
     * 返回所指定文本转换到Unicode格式文本后的字符数目。
     *
     * @param 待转换常量文本 待转换的常量文本
     * @param 转换到宽文本 是否转换到宽字符文本
     * @return 转换后的文本的字符数目
     */
    public static int 取统一文本长度(String 待转换常量文本, boolean 转换到宽文本) {
        if (转换到宽文本) {
            // 转换为UTF-16宽字符文本
            byte[] 字节集 = 待转换常量文本.getBytes(Charset.forName("UTF-16"));
            // 除去BOM标记的字节数
            int 字节长度 = 字节集.length - 2;
            // 一个UTF-16字符占2字节
            return 字节长度 / 2;
        } else {
            // 转换为UTF-8文本
            byte[] 字节集 = 待转换常量文本.getBytes(Charset.forName("UTF-8"));
            return 字节集.length;
        }
    }


    /**
     * 返回所指定文本的Unicode格式字节集。
     *
     * @param 待转换常量文本 待转换的常量文本
     * @param 转换到宽文本 是否转换到宽字符文本
     * @param 添加结束零字符 是否添加结束零字符
     * @return Unicode格式的字节集
     */
    public static byte[] 取统一文本(String 待转换常量文本, boolean 转换到宽文本, boolean 添加结束零字符) {
        if (转换到宽文本) {
            // 转换为UTF-16宽字符文本
            byte[] 字节集 = 待转换常量文本.getBytes(Charset.forName("UTF-16"));
            // 如果需要添加结束零字符
            if (添加结束零字符) {
                byte[] 带结束零字符的字节集 = new byte[字节集.length + 2];
                System.arraycopy(字节集, 0, 带结束零字符的字节集, 0, 字节集.length);
                return 带结束零字符的字节集;
            } else {
                return 字节集;
            }
        } else {
            // 转换为UTF-8文本
            byte[] 字节集 = 待转换常量文本.getBytes(Charset.forName("UTF-8"));
            // 如果需要添加结束零字符
            if (添加结束零字符) {
                byte[] 带结束零字符的字节集 = new byte[字节集.length + 1];
                System.arraycopy(字节集, 0, 带结束零字符的字节集, 0, 字节集.length);
                return 带结束零字符的字节集;
            } else {
                return 字节集;
            }
        }
    }
}
