package io.github.duolabmeng6.javaefun.核心支持库;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 接口数值转换包含进制转换和金额转换等功能。
 */
public interface 接口数值转换 {

    /**
     * 将通用类型转换为浮点数。
     *
     * @param 待转换的文本或数值 待转换的文本或数值
     * @return 转换后的浮点数
     */
    static float 到数值(Object 待转换的文本或数值) {
        return Float.parseFloat(待转换的文本或数值.toString());
    }

    // 数值到大写

    // 数值到金额

    // 数值到格式文本

    /**
     * 获取指定整数的十六进制文本表示。
     *
     * @param 欲取进制文本的数值 欲取进制文本的数值
     * @return 十六进制文本
     */
    static String 取十六进制文本(int 欲取进制文本的数值) {
        return Integer.toHexString(欲取进制文本的数值);
    }

    /**
     * 获取指定整数的八进制文本表示。
     *
     * @param 欲取进制文本的数值 欲取进制文本的数值
     * @return 八进制文本
     */
    static String 取八进制文本(int 欲取进制文本的数值) {
        return Integer.toOctalString(欲取进制文本的数值);
    }

    /**
     * 将通用类型转换为字节型方法。
     *
     * @param 待转换的文本或数值 待转换的文本或数值
     * @return 字节值
     */
    static byte 到字节(Object 待转换的文本或数值) {
        if (待转换的文本或数值 instanceof String) {
            // 如果输入是字符串，尝试将其解析为字节值
            try {
                return Byte.parseByte((String) 待转换的文本或数值);
            } catch (NumberFormatException e) {
                // 处理无法解析为字节的情况
                System.err.println("无法将文本解析为字节: " + 待转换的文本或数值);
            }
        } else if (待转换的文本或数值 instanceof Number) {
            // 如果输入是数字，尝试将其转换为字节
            return ((Number) 待转换的文本或数值).byteValue();
        }

        // 默认返回0，你可以根据需求修改此行
        return 0;
    }

    /**
     * 将通用类型转换为短整数型方法。
     *
     * @param 待转换的文本或数值 待转换的文本或数值
     * @return 短整数值
     */
    static short 到短整数(Object 待转换的文本或数值) {
        if (待转换的文本或数值 instanceof String) {
            // 如果输入是字符串，尝试将其解析为短整数值
            try {
                return Short.parseShort((String) 待转换的文本或数值);
            } catch (NumberFormatException e) {
                // 处理无法解析为短整数的情况
                System.err.println("无法将文本解析为短整数: " + 待转换的文本或数值);
            }
        } else if (待转换的文本或数值 instanceof Number) {
            // 如果输入是数字，尝试将其转换为短整数
            return ((Number) 待转换的文本或数值).shortValue();
        }

        // 默认返回0，你可以根据需求修改此行
        return 0;
    }

    /**
     * 将通用类型转换为长整数型方法。
     *
     * @param 待转换的文本或数值 待转换的文本或数值
     * @return 长整数值
     */
    static long 到长整数(Object 待转换的文本或数值) {
        if (待转换的文本或数值 instanceof String) {
            // 如果输入是字符串，尝试将其解析为长整数值
            try {
                return Long.parseLong((String) 待转换的文本或数值);
            } catch (NumberFormatException e) {
                // 处理无法解析为长整数的情况
                System.err.println("无法将文本解析为长整数: " + 待转换的文本或数值);
            }
        } else if (待转换的文本或数值 instanceof Number) {
            // 如果输入是数字，尝试将其转换为长整数
            return ((Number) 待转换的文本或数值).longValue();
        }

        // 默认返回0，你可以根据需求修改此行
        return 0L;
    }

    /**
     * 获取指定双精度小数的整数部分，舍弃小数部分。
     *
     * @param 双精度小数型 需要获取整数部分的数值
     * @return 整数部分
     */
    static int 到整数(Object 双精度小数型) {
        BigDecimal b = BigDecimal.valueOf(Double.parseDouble(双精度小数型.toString()));
        return (int) b.setScale(0, RoundingMode.DOWN).doubleValue();
    }

    /**
     * 将通用类型转换为浮点数方法。
     *
     * @param 待转换的文本或数值 待转换的文本或数值
     * @return 浮点数值
     */
    static float 到小数(Object 待转换的文本或数值) {
        if (待转换的文本或数值 instanceof String) {
            // 如果输入是字符串，尝试将其解析为浮点数值
            try {
                return Float.parseFloat((String) 待转换的文本或数值);
            } catch (NumberFormatException e) {
                // 处理无法解析为浮点数的情况
                System.err.println("无法将文本解析为浮点数: " + 待转换的文本或数值);
            }
        } else if (待转换的文本或数值 instanceof Number) {
            // 如果输入是数字，尝试将其转换为浮点数
            return ((Number) 待转换的文本或数值).floatValue();
        }

        // 默认返回0.0，你可以根据需求修改此行
        return 0.0f;
    }

    /**
     * 获取指定十六进制文本常量的整数值。
     *
     * @param 十六进制文本常量 十六进制文本常量
     * @return 整数值
     */
    static int 十六进制(String 十六进制文本常量) {
        return Integer.parseInt(十六进制文本常量, 16);
    }

    /**
     * 获取指定二进制文本常量的整数值。
     *
     * @param 二进制文本常量 二进制文本常量
     * @return 整数值
     */
    static int 二进制(String 二进制文本常量) {
        return Integer.parseInt(二进制文本常量, 2);
    }

    /**
     * 反转指定整数的字节序。
     *
     * @param 待反转的整数值 待反转的整数值
     * @return 反转后的整数值
     */
    static int 反转整数字节序(int 待反转的整数值) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (3 - i) * 8;
            result |= ((待反转的整数值 >> (i * 8)) & 0xFF) << shift;
        }
        return result;
    }
}
