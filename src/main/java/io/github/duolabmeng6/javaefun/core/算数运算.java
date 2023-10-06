package io.github.duolabmeng6.javaefun.core;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.RandomUtils;

public class 算数运算 {

    public static double 四舍五入(Object 欲被四舍五入的数值, int 被舍入的位置) {

        BigDecimal b = new BigDecimal(Double.parseDouble(欲被四舍五入的数值.toString()));
        return b.setScale(被舍入的位置, RoundingMode.HALF_UP).doubleValue();
    }

    public static double 取绝对值(Object 双精度小数型) {
        return Math.abs(Double.parseDouble(双精度小数型.toString()));
    }

    public static int 取整(double 双精度小数型) {
        return (int) Math.floor(双精度小数型);
    }

    public static double 求次方(double 欲求次方数值, double 次方数) {
        return Math.pow(欲求次方数值, 次方数);
    }

    public static double 求平方根(double 欲求次方数值) {
        return Math.sqrt(欲求次方数值);
    }

    public static double 求正弦(double 欲进行计算的角) {
        return Math.sin(欲进行计算的角);
    }

    public static double 求余弦(double 欲进行计算的角) {
        return Math.cos(欲进行计算的角);

    }

    public static double 求正切(double 欲进行计算的角) {
        return Math.tan(欲进行计算的角);
    }

    public static double 求反正切(double 欲求其反正切值的数值) {
        return Math.atan(欲求其反正切值的数值);
    }
    //    public static int 置随机数种子(long 欲置入的种子数值) {
    //        java.util.Random.Random(欲置入的种子数值);
    //    }


    public static int 取随机数(int 欲取随机数的最小值, int 欲取随机数的最大值) {
        return RandomUtils.nextInt(欲取随机数的最小值, 欲取随机数的最大值);
    }

    public static double 保留位数(double 双精度小数型, int 位数) {
        BigDecimal bg = new BigDecimal(双精度小数型);
        return bg.setScale(位数, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static double 向下取整(double 双精度小数型) {
        return Math.floor(双精度小数型);
    }

    public static double 向上取整(double 双精度小数型) {
        return Math.ceil(双精度小数型);
    }

    public static int 到整数(Object 双精度小数型) {
        BigDecimal b = new BigDecimal(Double.parseDouble(双精度小数型.toString()));
        return (int) b.setScale(0, RoundingMode.DOWN).doubleValue();

    }
    public static int 取整数(Object 双精度小数型) {
        return 到整数(双精度小数型);
    }
}
