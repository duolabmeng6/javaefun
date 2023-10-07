package io.github.duolabmeng6.javaefun.核心支持库;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * 接口算数运算包含了一系列数学运算的静态方法，以及一个随机数生成器。
 */
public interface 接口算数运算 {

    /**
     * 获取指定数值的符号。
     *
     * @param 欲取其符号的数值 需要获取符号的数值
     * @return 如果小于零，返回 -1；如果等于零，返回 0；如果大于零，返回 1。
     */
    static int 取符号(double 欲取其符号的数值) {
        if (欲取其符号的数值 < 0) {
            return -1; // 如果小于零，返回负数
        } else if (欲取其符号的数值 == 0) {
            return 0; // 如果等于零，返回零
        } else {
            return 1; // 如果大于零，返回正数
        }
    }

    /**
     * 获取指定数值的绝对值。
     *
     * @param 双精度小数型 需要获取绝对值的数值
     * @return 绝对值
     */
    static double 取绝对值(Object 双精度小数型) {
        return Math.abs(Double.parseDouble(双精度小数型.toString()));
    }

    /**
     * 获取指定双精度小数的整数部分，保留符号。
     *
     * @param 欲取整的小数 需要获取整数部分的小数
     * @return 整数部分，如果小于零则向上取整，如果大于零则向下取整
     */
    static int 取整(double 欲取整的小数) {
        if (欲取整的小数 >= 0) {
            return (int) Math.floor(欲取整的小数);
        } else {
            return (int) Math.ceil(欲取整的小数);
        }
    }

    /**
     * 获取指定数值的整数部分，保留符号。
     *
     * @param 欲取整的小数 需要获取整数部分的小数
     * @return 整数部分，如果小于零则向上取整，如果大于零则向下取整
     */
    static int 绝对取整(double 欲取整的小数) {
        if (欲取整的小数 >= 0) {
            return (int) Math.floor(欲取整的小数);
        } else {
            return (int) Math.ceil(欲取整的小数);
        }
    }

    /**
     * 对指定数值进行四舍五入。
     *
     * @param 欲被四舍五入的数值 需要进行四舍五入的数值
     * @param 被舍入的位置    指定要保留的小数位数
     * @return 四舍五入后的数值
     */
    static double 四舍五入(Object 欲被四舍五入的数值, int 被舍入的位置) {
        BigDecimal b = BigDecimal.valueOf(Double.parseDouble(欲被四舍五入的数值.toString()));
        return b.setScale(被舍入的位置, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 计算指定数值的指定次方。
     *
     * @param 欲求次方数值 底数
     * @param 次方数    指数
     * @return 计算结果
     */
    static double 求次方(double 欲求次方数值, double 次方数) {
        return Math.pow(欲求次方数值, 次方数);
    }

    /**
     * 计算指定数值的平方根。
     *
     * @param 欲求次方数值 需要计算平方根的数值
     * @return 平方根值
     */
    static double 求平方根(double 欲求次方数值) {
        return Math.sqrt(欲求次方数值);
    }

    /**
     * 计算指定角度的正弦值。
     *
     * @param 欲进行计算的角 需要计算正弦值的角度（以弧度为单位）
     * @return 正弦值
     */
    static double 求正弦(double 欲进行计算的角) {
        return Math.sin(欲进行计算的角);
    }

    /**
     * 计算指定角度的余弦值。
     *
     * @param 欲进行计算的角 需要计算余弦值的角度（以弧度为单位）
     * @return 余弦值
     */
    static double 求余弦(double 欲进行计算的角) {
        return Math.cos(欲进行计算的角);
    }

    /**
     * 计算指定角度的正切值。
     *
     * @param 欲进行计算的角 需要计算正切值的角度（以弧度为单位）
     * @return 正切值
     */
    static double 求正切(double 欲进行计算的角) {
        return Math.tan(欲进行计算的角);
    }

    /**
     * 计算指定数值的反正切值。
     *
     * @param 欲求其反正切值的数值 需要计算反正切值的数值
     * @return 反正切值
     */
    static double 求反正切(double 欲求其反正切值的数值) {
        return Math.atan(欲求其反正切值的数值);
    }

    /**
     * 计算指定数值的自然对数值。
     *
     * @param 欲求其自然对数的数值 需要计算自然对数的数值
     * @return 自然对数值
     */
    static double 求自然对数(double 欲求其自然对数的数值) {
        return Math.log(欲求其自然对数的数值);
    }

    /**
     * 计算 e（自然对数的底）的指定次方。
     *
     * @param 欲求其反对数的数值 需要计算反对数的数值
     * @return 计算结果
     */
    static double 求反对数(double 欲求其反对数的数值) {
        return Math.exp(欲求其反对数的数值);
    }

    Random 随机数生成器 = new Random();

    /**
     * 获取指定范围内的随机整数。
     *
     * @param 欲取随机数的最小值 随机数范围的最小值
     * @param 欲取随机数的最大值 随机数范围的最大值
     * @return 随机整数
     */
    static int 取随机数(int 欲取随机数的最小值, int 欲取随机数的最大值) {
        return 随机数生成器.nextInt(欲取随机数的最大值 - 欲取随机数的最小值 + 1) + 欲取随机数的最小值;
    }

    /**
     * 设置随机数生成器的种子。
     *
     * @param 欲置入的种子数值 欲设置的种子数值
     * @return 设置后的种子数值
     */
    static long 置随机数种子(long 欲置入的种子数值) {
        if (欲置入的种子数值 == 0) {
            欲置入的种子数值 = System.currentTimeMillis();
        }
        随机数生成器.setSeed(欲置入的种子数值);
        return 欲置入的种子数值;
    }

    static long 置随机数种子() {
        long 欲置入的种子数值 = System.currentTimeMillis();
        随机数生成器.setSeed(欲置入的种子数值);
        return 欲置入的种子数值;
    }

    /**
     * 保留指定小数位数的小数。
     *
     * @param 双精度小数型 需要保留小数位数的数值
     * @param 位数     要保留的小数位数
     * @return 保留指定小数位数后的数值
     */
    static double 保留位数(double 双精度小数型, int 位数) {
        BigDecimal bg = new BigDecimal(双精度小数型);
        return bg.setScale(位数, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 向下取整，返回不大于指定数值的最大整数。
     *
     * @param 双精度小数型 需要向下取整的数值
     * @return 向下取整后的整数
     */
    static double 向下取整(double 双精度小数型) {
        return Math.floor(双精度小数型);
    }

    /**
     * 向上取整，返回不小于指定数值的最小整数。
     *
     * @param 双精度小数型 需要向上取整的数值
     * @return 向上取整后的整数
     */
    static double 向上取整(double 双精度小数型) {
        return Math.ceil(双精度小数型);
    }


}
