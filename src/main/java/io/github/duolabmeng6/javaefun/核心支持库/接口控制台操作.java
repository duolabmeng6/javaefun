package io.github.duolabmeng6.javaefun.核心支持库;

public interface 接口控制台操作 {

    static void 标准输出(Object... 输出内容) {
        for (Object 内容 : 输出内容) {
            System.out.print(内容);
        }
    }

    static String 标准输入() {
        return System.console().readLine();
    }

}
