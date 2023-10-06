package io.github.duolabmeng6.javaefun.ecore;

import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
/**
 * 接口文本操作包含了一系列文本操作的方法，包括文本的截取、替换、查找、大小写转换、编码转换等。
 */
public interface 接口文本操作 {

    static int 取文本长度(String 文本数据) {
        return 文本数据.length();
    }

    static String 取文本左边(String 欲取其部分的文本, int 欲取出字符的数目) {
        int l = 取文本长度(欲取其部分的文本);
        if (欲取出字符的数目 > l) {
            欲取出字符的数目 = l;
        }
        return 欲取其部分的文本.substring(0, 欲取出字符的数目);
    }

    static String 取文本右边(String 欲取其部分的文本, int 欲取出字符的数目) {
        int l = 取文本长度(欲取其部分的文本);
        int lpos = l - 欲取出字符的数目;
        if (lpos < 0) {
            lpos = 0;
        }
        欲取出字符的数目 = lpos + 欲取出字符的数目;
        if (欲取出字符的数目 > l) {
            欲取出字符的数目 = l;
        }
        return 欲取其部分的文本.substring(lpos, 欲取出字符的数目);
    }

    static String 取文本中间(String 欲取其部分的文本, int 起始取出位置, int 欲取出字符的数目) {
        欲取出字符的数目 = 起始取出位置 + 欲取出字符的数目;
        if (取文本长度(欲取其部分的文本) < 欲取出字符的数目) {
            欲取出字符的数目 = 取文本长度(欲取其部分的文本);
        }
        return 欲取其部分的文本.substring(起始取出位置, 欲取出字符的数目);
    }

    static String 字符(int 字节型) {
        return String.valueOf((char) 字节型);
    }

    static int 取代码(String 欲取字符代码的文本) {
        if (欲取字符代码的文本.length() == 0) {
            return 0;
        }
        char[] arr = 欲取字符代码的文本.substring(0, 1).toCharArray();
        return (int) arr[0];
    }

    static int 寻找文本(String 被搜寻的文本, String 欲寻找的文本) {
        return 被搜寻的文本.indexOf(欲寻找的文本, 0);
    }

    static int 寻找文本(String 被搜寻的文本, String 欲寻找的文本, int 起始搜寻位置) {
        return 被搜寻的文本.indexOf(欲寻找的文本, 起始搜寻位置);
    }

    static int 倒找文本(String 被搜寻的文本, String 欲寻找的文本, int 起始搜寻位置) {
        if (起始搜寻位置 == 0) {
            return 被搜寻的文本.lastIndexOf(欲寻找的文本);
        }
        return 被搜寻的文本.lastIndexOf(欲寻找的文本, 起始搜寻位置);
    }


    static String 到大写(String 欲变换的文本) {
        return 欲变换的文本.toUpperCase();
    }

    static String 到小写(String 欲变换的文本) {
        return 欲变换的文本.toLowerCase();
    }

    static String 到全角(String input) {// 全角-->半角
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);

            }
        }
        return new String(c);
    }

    static String 到半角(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);

            }
        }
        String returnString = new String(c);

        return returnString;
    }

    static String 删首空(String 欲删除空格的文本) {
        return StringUtils.stripStart(欲删除空格的文本, " ");
    }

    static String 删尾空(String 欲删除空格的文本) {
        return StringUtils.stripEnd(欲删除空格的文本, " ");
    }

    static String 删首尾空(String 欲删除空格的文本) {
        return 欲删除空格的文本.trim();
    }

    static String 删全部空(String 欲删除空格的文本) {
        return 欲删除空格的文本.replaceAll(" ", "");
    }

    static String 子文本替换(String 欲被替换的文本, String 欲被替换的子文本, String 用作替换的子文本) {
        String str;
        str = 欲被替换的文本.replace(欲被替换的子文本, 用作替换的子文本);
        return str;
    }

    static String 取空白文本(int 重复次数) {
        return 取重复文本(重复次数, " ");
    }

    static String 取重复文本(int 重复次数, String 待重复文本) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 重复次数; i++) {
            str.append(待重复文本);
        }
        return str.toString();
    }

    /**
     * 文本比较方法，用于比较两个文本的大小关系。
     *
     * @param 待比较文本一  待比较的第一个文本
     * @param 待比较文本二  待比较的第二个文本
     * @param 是否区分大小写 是否区分大小写，true表示区分，false表示不区分
     * @return 返回值小于0表示文本一小于文本二，等于0表示文本一等于文本二，大于0表示文本一大于文本二
     */
    static int 文本比较(String 待比较文本一, String 待比较文本二, boolean 是否区分大小写) {
        if (是否区分大小写) {
            return 待比较文本一.compareTo(待比较文本二);
        } else {
            return 待比较文本一.compareToIgnoreCase(待比较文本二);
        }
    }

    static String[] 分割文本(String 待分割文本, String 用作分割的文本) {
        return 待分割文本.split(用作分割的文本);
    }

    static String[] 分割文本(String 待分割文本, String 用作分割的文本, int 要返回的子文本数目) {
        return 待分割文本.split(用作分割的文本, 要返回的子文本数目);
    }


    /**
     * 文本到UTF8方法，用于将文本转换为UTF8格式的字节集。
     *
     * @param 待转换的文本 待转换的文本
     * @return 转换后的UTF8格式的字节集
     */
    static byte[] 文本到UTF8(String 待转换的文本) {
        return 待转换的文本.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * UTF8到文本方法，用于将UTF8格式的字节集转换为通常文本。
     *
     * @param 待转换的UTF8文本数据 待转换的UTF8文本数据
     * @return 转换后的通常文本
     */
    static String UTF8到文本(byte[] 待转换的UTF8文本数据) {
        return new String(待转换的UTF8文本数据, StandardCharsets.UTF_8);
    }

    /**
     * 文本到UTF16方法，用于将文本转换为UTF16格式的字节集。
     *
     * @param 待转换的文本 待转换的文本
     * @return 转换后的UTF16格式字节集
     */
    static byte[] 文本到UTF16(String 待转换的文本) {
        return 待转换的文本.getBytes(StandardCharsets.UTF_16);
    }

    /**
     * UTF16到文本方法，用于将UTF16格式的字节集转换为通常文本。
     *
     * @param 待转换的UTF16文本数据 待转换的UTF16文本数据
     * @return 转换后的通常文本
     */
    static String UTF16到文本(byte[] 待转换的UTF16文本数据) {
        return new String(待转换的UTF16文本数据, StandardCharsets.UTF_16);
    }
}
