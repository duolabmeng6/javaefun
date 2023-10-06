package io.github.duolabmeng6.javaefun.ecore;


import static io.github.duolabmeng6.javaefun.ecore.接口文本操作.子文本替换;

/**
 * 接口时间操作是操作时间的快捷方法
 */
public interface 接口时间操作 {

    static 日期时间 取现行时间() {
        return new 日期时间().创建("now", "");
    }

    static 日期时间 Now() {
        return new 日期时间().创建("now", "");
    }

    static 日期时间 到时间(String 时间文本) {
        return new 日期时间().创建(时间文本, "");
    }

    static 日期时间 到时间(long 时间戳) {
        return new 日期时间().创建(String.valueOf(时间戳), "时间戳");
    }


    /**
     * @param 时间文本   丽日 2020-1-1 01:11:11
     * @param 时间格式文本 例如 yyyy-MM-dd HH:mm:ss
     * @return
     */
    static 日期时间 到时间(String 时间文本, String 时间格式文本) {
        return new 日期时间().创建(时间文本, 时间格式文本);
    }

    static String date(日期时间 日期时间, String 时间格式文本) {
        String str = 时间格式文本;
        str = 子文本替换(str, "Y", String.valueOf(日期时间.取年()));
        str = 子文本替换(str, "m", String.valueOf(日期时间.取月()));
        str = 子文本替换(str, "d", String.valueOf(日期时间.取日()));
        str = 子文本替换(str, "H", String.valueOf(日期时间.取小时()));
        str = 子文本替换(str, "i", String.valueOf(日期时间.取分钟()));
        str = 子文本替换(str, "s", String.valueOf(日期时间.取秒()));
        return str;
    }

}
