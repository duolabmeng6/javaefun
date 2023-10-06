package io.github.duolabmeng6.javaefun.core;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Calendar;

import static io.github.duolabmeng6.javaefun.ecore.接口文本处理.*;
import static io.github.duolabmeng6.javaefun.ecore.接口文本操作.*;

public class 日期时间 {
    public LocalDateTime t = null;

    public 日期时间 创建(String 时间文本, String 时间格式文本) {
        if (时间文本 == "now") {
            this.t = LocalDateTime.now();
        } else if (时间格式文本 == "时间戳") {
            this.t = LocalDateTime.ofInstant(Instant.ofEpochSecond(Integer.valueOf(时间文本)), ZoneId.systemDefault());
        } else {
            if (时间格式文本 == "") {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                this.t = LocalDateTime.parse(时间文本, formatter);
            } else {
                this.t = LocalDateTime.parse(时间文本);
            }
        }
        return this;
    }

    public String 到文本(String 时间格式文本) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (时间格式文本 != "") {
            formatter = DateTimeFormatter.ofPattern(时间格式文本);
        }
        return this.t.format(formatter).toString();
    }

    public String 到文本() {
        return this.到文本("");
    }

    public long 取时间戳() {
        return this.t.toEpochSecond(ZoneOffset.of("+8"));
    }

    public long 取时间戳毫秒() {
        return this.t.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public long 取日期() {
        return this.t.toLocalDate().getDayOfMonth();
    }

    public long 取年() {
        return this.t.getYear();
    }

    public long 取月() {
        return this.t.getMonthValue();
    }

    public long 取日() {
        return this.t.getDayOfMonth();
    }

    public long 取小时() {
        return this.t.getHour();
    }

    public long 取分钟() {
        return this.t.getMinute();
    }

    public long 取秒() {
        return this.t.getSecond();
    }

    public long 取纳秒() {
        return this.t.getNano();
    }

    public long 取每周的第几天() {
        return this.t.getDayOfWeek().getValue();
    }

    public long 取每年的第几天() {
        return this.t.getDayOfYear();
    }

    public long 取每月的第几周() {
        return this.t.getDayOfWeek().getValue();
    }

    public long 取每年的第几周() {
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        int weeks = this.t.get(weekFields.weekOfYear());
        return weeks;
    }

    public long 取月天数() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.t.getYear(), this.t.getMonthValue() - 1, this.t.getDayOfMonth(), this.t.getHour(), this.t.getMinute(), this.t.getSecond());
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public void 设置年份(int 年) {
        this.t = this.t.withYear(年);
    }

    public void 设置月份(int 月) {
        this.t = this.t.withMonth(月);
    }

    public void 设置日(int 日) {
        this.t = this.t.withDayOfMonth(日);
    }

    public void 设置时(int 时) {
        this.t = this.t.withHour(时);
    }

    public void 设置分钟(int 分钟) {
        this.t = this.t.withMinute(分钟);
    }

    public void 设置秒(int 秒) {
        this.t = this.t.withSecond(秒);
    }

    public void 增减年份(int 年) {
        this.t = this.t.plusYears(年);
    }

    public void 增减月份(int 月) {
        this.t = this.t.plusMonths(月);
    }

    public void 增减日(int 日) {
        this.t = this.t.plusDays(日);
    }

    public void 增减时(int 时) {
        this.t = this.t.plusHours(时);
    }

    public void 增减分钟(int 分钟) {
        this.t = this.t.plusMinutes(分钟);
    }

    public void 增减秒(int 秒) {
        this.t = this.t.plusSeconds(秒);
    }


    public Duration 取时间间隔(日期时间 time) {
        Duration duration = Duration.between(this.t, time.t);
        return duration;
    }


}

class 日期时间函数 {
    public static 日期时间 取现行时间() {
        return new 日期时间().创建("now", "");
    }

    public static 日期时间 Now() {
        return new 日期时间().创建("now", "");
    }

    public static 日期时间 到时间(String 时间文本) {
        return new 日期时间().创建(时间文本, "");
    }

    public static 日期时间 到时间(long 时间戳) {
        return new 日期时间().创建(String.valueOf(时间戳), "时间戳");
    }


    /**
     * @param 时间文本   丽日 2020-1-1 01:11:11
     * @param 时间格式文本 例如 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static 日期时间 到时间(String 时间文本, String 时间格式文本) {
        return new 日期时间().创建(时间文本, 时间格式文本);
    }

    public static String date(日期时间 日期时间, String 时间格式文本) {
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