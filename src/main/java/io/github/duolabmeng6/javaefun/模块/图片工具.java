package io.github.duolabmeng6.javaefun.模块;

import cn.hutool.core.img.Img;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;

public class 图片工具 {
    public static void 图片缩放(String 缩放图片,String 保存地址,float 缩放比例){
        //比例大于1时为放大，小于1大于0为缩小
        ImgUtil.scale(FileUtil.file(缩放图片),FileUtil.file(保存地址),缩放比例);
    }
    public static void 图片类型转换(String 旧图片,String 新图片){
        ImgUtil.convert(FileUtil.file(旧图片), FileUtil.file(新图片));
    }
    public static void 图片二值化(String 旧图片,String 新图片){
        ImgUtil.gray(FileUtil.file(旧图片), FileUtil.file(新图片));
    }
    public static void 水平翻转(String 旧图片,String 新图片){
        ImgUtil.flip(FileUtil.file(旧图片), FileUtil.file(新图片));
    }
    public static void 图片压缩(String 旧图片,String 新图片,double 压缩比率){
        //图片压缩只支持输出Jpg文件。 0.8
        Img.from(FileUtil.file(旧图片))
                .setQuality(压缩比率)//压缩比率
                .write(FileUtil.file(新图片));
    }


}
