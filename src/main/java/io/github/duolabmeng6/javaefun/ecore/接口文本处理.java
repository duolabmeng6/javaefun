package io.github.duolabmeng6.javaefun.ecore;

import com.github.promeg.pinyinhelper.Pinyin;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface 接口文本处理 {

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
//        try {
        str = 欲被替换的文本.replace(欲被替换的子文本, 用作替换的子文本);
//        }catch (Exception e){
//            return 欲被替换的文本;
//        }
        return str;
    }

    static String 取重复文本(int 重复次数, String 待重复文本) {
        String str = "";
        for (int i = 0; i < 重复次数; i++) {
            str = str + 待重复文本;
        }
        return str;
    }

    static String 取空白文本(int 重复次数) {
        return 取重复文本(重复次数, " ");
    }

    static String[] 分割文本(String 待分割文本, String 用作分割的文本) {
        return 待分割文本.split(用作分割的文本);
    }

    static String[] 分割文本(String 待分割文本, String 用作分割的文本, int 要返回的子文本数目) {
        return 待分割文本.split(用作分割的文本, 要返回的子文本数目);
    }


    static String 文本_取左边(String 需取文本, String 欲寻找的文本) {
        int 位置 = 需取文本.indexOf(欲寻找的文本);
        if (位置 == -1) {
            return "";
        }
        return 需取文本.substring(0, 位置);
    }

    static String 文本_取右边(String 需取文本, String 欲寻找的文本) {
        int 位置 = 需取文本.lastIndexOf(欲寻找的文本);
        if (位置 == -1) {
            return "";
        }
        位置 = 位置 + 欲寻找的文本.length();

        return 需取文本.substring(位置);
    }

    static String 文本_取出中间文本(String 需取文本, String 左边文本, String 右边文本) {
        int 位置;
        if (左边文本.equals("")) {
            位置 = 0;
        } else {
            位置 = 需取文本.lastIndexOf(左边文本);

        }
        if (位置 == -1) {
            return "";
        }
        位置 = 位置 + 左边文本.length();
        int 位置2;
        if (右边文本.equals("")) {
            位置2 = 需取文本.length();
        } else {
            位置2 = 需取文本.lastIndexOf(右边文本);
        }
        if (位置2 == -1) {
            return "";
        }
        return 需取文本.substring(位置, 位置2);
    }

    static String strCut(String 内容, String 表达式) {
        String[] subbds = 表达式.split("\\$", -1);
        if (subbds.length == 2) {
            return 文本_取出中间文本(内容, subbds[0], subbds[1]);
        }
        return 内容;
    }


    static String 文本_取随机字母(int 取出的数量, int 类型) {
        //类型：0.小写 1.大写 2.混合
        String str = null;
        if (类型 == 0) {
            str = "abcdefghijklmnopqrstuvwxyz";
        }
        if (类型 == 1) {
            str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (类型 == 2) {
            str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 取出的数量; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    static String 文本_取随机字母(int 取出的数量) {
        return 文本_取随机字母(取出的数量, 2);
    }

    static String 文本_取随机字母和数字(int 取出的数量) {
        return RandomStringUtils.randomAlphanumeric(取出的数量);
    }

    static String 文本_取随机数字(int 取出的数量) {
        return RandomStringUtils.randomNumeric(取出的数量);
    }

    static String 文本_取随机汉字(int 取出的数量) {
        String str = "的一是了我不人在他有这个上们来到时大地为子中你说生国年着就那和要她出也得里后自以会家可下而过天去能对小多然于心学么之都好看起发当没成只如事把还用第样道想作种开美总从无情己面最女但现前些所同日手又行意动方期它头经长儿回位分爱老因很给名法间斯知世什两次使身者被高已亲其进此话常与活正感见明问力理尔点文几定本公特做外孩相西果走将月十实向声车全信重三机工物气每并别真打太新比才便夫再书部水像眼等体却加电主界门利海受听表德少克代员许稜先口由死安写性马光白或住难望教命花结乐色更拉东神记处让母父应直字场平报友关放至张认接告入笑内英军候民岁往何度山觉路带万男边风解叫任金快原吃妈变通师立象数四失满战远格士音轻目条呢病始达深完今提求清王化空业思切怎非找片罗钱紶吗语元喜曾离飞科言干流欢约各即指合反题必该论交终林请医晚制球决窢传画保读运及则房早院量苦火布品近坐产答星精视五连司巴奇管类未朋且婚台夜青北队久乎越观落尽形影红爸百令周吧识步希亚术留市半热送兴造谈容极随演收首根讲整式取照办强石古华諣拿计您装似足双妻尼转诉米称丽客南领节衣站黑刻统断福城故历惊脸选包紧争另建维绝树系伤示愿持千史谁准联妇纪基买志静阿诗独复痛消社算义竟确酒需单治卡幸兰念举仅钟怕共毛句息功官待究跟穿室易游程号居考突皮哪费倒价图具刚脑永歌响商礼细专黄块脚味灵改据般破引食仍存众注笔甚某沉血备习校默务土微娘须试怀料调广蜖苏显赛查密议底列富梦错座参八除跑亮假印设线温虽掉京初养香停际致阳纸李纳验助激够严证帝饭忘趣支春集丈木研班普导顿睡展跳获艺六波察群皇段急庭创区奥器谢弟店否害草排背止组州朝封睛板角况曲馆育忙质河续哥呼若推境遇雨标姐充围案伦护冷警贝著雪索剧啊船险烟依斗值帮汉慢佛肯闻唱沙局伯族低玩资屋击速顾泪洲团圣旁堂兵七露园牛哭旅街劳型烈姑陈莫鱼异抱宝权鲁简态级票怪寻杀律胜份汽右洋范床舞秘午登楼贵吸责例追较职属渐左录丝牙党继托赶章智冲叶胡吉卖坚喝肉遗救修松临藏担戏善卫药悲敢靠伊村戴词森耳差短祖云规窗散迷油旧适乡架恩投弹铁博雷府压超负勒杂醒洗采毫嘴毕九冰既状乱景席珍童顶派素脱农疑练野按犯拍征坏骨余承置臓彩灯巨琴免环姆暗换技翻束增忍餐洛塞缺忆判欧层付阵玛批岛项狗休懂武革良恶恋委拥娜妙探呀营退摇弄桌熟诺宣银势奖宫忽套康供优课鸟喊降夏困刘罪亡鞋健模败伴守挥鲜财孤枪禁恐伙杰迹妹藸遍盖副坦牌江顺秋萨菜划授归浪听凡预奶雄升碃编典袋莱含盛济蒙棋端腿招释介烧误乾坤";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 取出的数量; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    static String 文本_取随机姓氏(Boolean 取常见姓氏) {
        String 百家姓 = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫柯房裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊于惠甄曲家封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭历戎祖武符刘景詹束龙叶幸司韶郜黎蓟溥印宿白怀蒲邰从鄂索咸籍赖卓蔺屠蒙池乔阳郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庾终暨居衡步都耿满弘匡国文寇广禄阙东欧殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后荆红游竺权逮盍益桓公";
        String 常见百家姓 = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛范彭郎鲁韦昌马苗凤花方俞任袁柳史唐费薛雷贺罗毕于齐萧尹姚顾孟平黄宋庞项祝董梁杜阮刘万丁石洪白田夏";
        String str = "";
        if (取常见姓氏) {
            str = 百家姓;
        } else {
            str = 常见百家姓;
        }
        Random random = new Random();
        int number = random.nextInt(str.length());
        String 返回值 = String.valueOf(str.charAt(number));
        return 返回值;
    }

    static String 文本_取随机手机号() {
        String[] 号码前缀 = {"130", "131", "132", "134", "135", "136", "137", "138", "139", "147", "150", "151", "152", "153", "155", "156", "157", "158", "159", "170", "171", "180", "182", "183", "185", "186", "187", "188", "189"};
        String 尾号 = "";
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int number = random.nextInt(9);
            尾号 = 尾号 + String.valueOf(number);
        }
        String 前面 = 号码前缀[random.nextInt(号码前缀.length)];
        return 前面 + 尾号;
    }

    static String 文本_取随机邮箱() {
        String[] 邮箱后缀 = {"@qq.com", "@sina.com", "@126.com", "@163.com", "@hotmail.com", "@139.com", "@189.com", "@sohu.com", "@21cn.com", "@189.com", "@tom.com", "@aol.com", "@263.com", "@aliyun.com", "@foxmail.com", "@yeah.net"};
        int number = new Random().nextInt(11 - 5) + 5;
        String 前面 = 文本_取随机字母和数字(number);
        String 后面 = 邮箱后缀[new Random().nextInt(邮箱后缀.length)];
        return 前面 + 后面;
    }

    static String 文本_删左边(String 欲处理文本, int 删除长度) {
        return 取文本右边(欲处理文本, 取文本长度(欲处理文本) - 删除长度);
    }

    static String 文本_删右边(String 欲处理文本, int 删除长度) {
        return 取文本左边(欲处理文本, 取文本长度(欲处理文本) - 删除长度);
    }

    static String 文本_删中间(String 欲处理文本, int 起始位置, int 删除长度) {
        return 取文本左边(欲处理文本, 起始位置) + 文本_删左边(欲处理文本, 起始位置 + 删除长度);
    }

    static boolean 文本_是否为汉字(String 欲处理文本) {
        return 欲处理文本.matches("[^\u4e00-\u9fa5]");
    }

    static String 文本区分_只取字母(String 欲处理文本, int type) {
        //type 0大小写字母 1大写字母 2小写字母
        String re = null;
        if (type == 0) {
            re = "[^(a-zA-Z)]";
        } else if (type == 1) {
            re = "[^(A-Z)]";
        } else if (type == 2) {
            re = "[^(a-z)]";
        }
        return 欲处理文本.replaceAll(re, "");
    }

    static String 文本区分_只取数字(String 欲处理文本) {
        //type 0大小写字母 1大写字母 2小写字母
        String re = null;
        re = "[^(0-9)]";
        return 欲处理文本.replaceAll(re, "");
    }


    static boolean 判断文本(String 欲处理文本, String 关键字) {
        return 欲处理文本.indexOf(关键字) != -1;
    }

    static boolean 判断文本(String 欲处理文本, String[] 关键字) {
        for (String v : 关键字) {
            if (判断文本(欲处理文本, v)) {
                return true;
            }
        }
        return false;
    }

    static String 判断文本s(String 欲处理文本, String[] 关键字) {
        for (String v : 关键字) {
            if (判断文本(欲处理文本, v)) {
                return v;
            }
        }
        return "";
    }

    static List<String> 文本_取正则匹配结果(String 欲处理文本, String 正则表达式) {
        Matcher m = Pattern.compile(正则表达式).matcher(欲处理文本);
        List<String> result = new ArrayList<String>();
        while (m.find()) {
            result.add(m.group());
        }
        return result;
    }

    static List<String> 文本_取手机号码(String 欲处理文本) {
        return 文本_取正则匹配结果(欲处理文本, "(1[3,4,5,6,7,8,9]\\d{9})");
    }

    static List<String> 文本_取IP地址(String 欲处理文本) {
        return 文本_取正则匹配结果(欲处理文本, "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    }

    static List<String> 文本_取电话号码(String 欲处理文本) {
        return 文本_取正则匹配结果(欲处理文本, "\\d{3,4}[\\s,-]?\\d{7,8}");
    }

    static List<String> 文本_取QQ号码(String 欲处理文本) {
        return 文本_取正则匹配结果(欲处理文本, "[1-9][0-9]{4,10}");
    }

    static List<String> 文本_取邮政编码(String 欲处理文本) {
        return 文本_取正则匹配结果(欲处理文本, "[1-9]\\d{5}(?!\\d)");
    }

    static List<String> 文本_取身份证号码(String 欲处理文本) {
        return 文本_取正则匹配结果(欲处理文本, "[1-9][0-9,X]{14,17}");
    }

    static String 文本_取双字节字符(String 欲处理文本) {
        List<String> strarr = 文本_取正则匹配结果(欲处理文本, "[^\\x00-\\xff]");

        return String.join("", strarr);
    }

    static List<String> 文本_取网址(String 欲处理文本) {
        return 文本_取正则匹配结果(欲处理文本, "[a-zA-z]+://[^\\s]*");
    }

    static List<String> 文本_取IP跟端口(String 欲处理文本) {
        return 文本_取正则匹配结果(欲处理文本, "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}:\\d{2,5}");
    }

    static List<String> 文本_取邮箱号码(String 欲处理文本) {
        return 文本_取正则匹配结果(欲处理文本, "[a-z0-9\\.\\-+_]{1,30}@[a-z0-9\\.\\-+_]{1,30}\\.[a-z]{1,10}");
    }

    static String 文本_大小写翻转(String 欲处理文本) {
        return StringUtils.swapCase(欲处理文本);
    }

    static boolean 文本_正则是否匹配(String regex, String input) {
        if (StringUtils.isBlank(input))
            return false;
        if (input.matches(regex))
            return true;
        return false;
    }

    static boolean 文本_是否为大写字母(String 欲处理文本) {
        return String.join("", 文本_取正则匹配结果(欲处理文本, "[A-Z]")).equals(欲处理文本);
    }

    static boolean 文本_是否为小写字母(String 欲处理文本) {
        return String.join("", 文本_取正则匹配结果(欲处理文本, "[a-z]")).equals(欲处理文本);
    }

    static boolean 文本_是否为字母(String 欲处理文本) {
        return String.join("", 文本_取正则匹配结果(欲处理文本, "[A-za-z]")).equals(欲处理文本);
    }

    static boolean 文本_是否为数字字母(String 欲处理文本) {
        return String.join("", 文本_取正则匹配结果(欲处理文本, "[0-9A-za-z]")).equals(欲处理文本);
    }

    static boolean 文本_是否为数字(String 欲处理文本) {
        return String.join("", 文本_取正则匹配结果(欲处理文本, "[0-9]")).equals(欲处理文本);
    }


    static int 文本_取出现次数(String 欲处理文本, String 欲查询的文本) {
        return StringUtils.countMatches(欲处理文本, 欲查询的文本);
    }

    static String 文本_填充空格_居中(String 欲处理文本, int 填充目标长度) {
        return StringUtils.center(欲处理文本, 填充目标长度);
    }

    static String 文本_填充空格_左对齐(String 欲处理文本, int 填充目标长度) {
        return StringUtils.rightPad(欲处理文本, 填充目标长度);
    }

    static String 文本_填充空格_右对齐(String 欲处理文本, int 填充目标长度) {
        return StringUtils.leftPad(欲处理文本, 填充目标长度);
    }

    static String 文本_自动补零(String 欲处理文本, int 填充目标长度) {
        return StringUtils.leftPad(欲处理文本, 填充目标长度, "0");
    }

    static String 文本_单词首字母大写(String s) {
        String[] split = s.split(" ");
        //按空格分隔成数组
        String s2 = null;
        for (int i = 0; i < split.length; i++) {
            // .substring(0,1) 截取数组的首字母   +split[i].substring(1); 再加上后面
            s2 = split[i].substring(0, 1).toUpperCase() + split[i].substring(1);
        }
        return s2;
    }

    static String 数组_转文本(String[] 文本数组, String 分隔符) {
        return StringUtils.join(文本数组, 分隔符);
    }

    static boolean 文本_判断文本前缀(String 欲处理文本, String 开头的文本) {
        return StringUtils.startsWith(欲处理文本, 开头的文本);
    }

    static boolean 文本_判断文本后缀(String 欲处理文本, String 结尾的文本) {
        return StringUtils.endsWith(欲处理文本, 结尾的文本);
    }

    static List<String> 文本_取中间_批量(String 欲处理文本, String 前面的文本, String 后面的文本) {
        Matcher m = Pattern.compile(前面的文本 + "([\\s\\S]*?)" + 后面的文本).matcher(欲处理文本);
        List<String> result = new ArrayList<String>();
        while (m.find()) {
            result.add(m.group(1));
        }
        return result;
    }


    static String 文本_取随机IP() {
        Random r = new Random();
        return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
    }


    static List<String> 文本_逐字分割(String 欲处理文本) {
        List<String> result = new ArrayList<String>();
        char ss[] = 欲处理文本.toCharArray(); //利用toCharArray方法转换
        for (int i = 0; i < ss.length; i++) {
            result.add(String.valueOf(ss[i]));
        }
        return result;
    }

    static String 文本_颠倒(String 欲处理文本) {
        return new StringBuffer(欲处理文本).reverse().toString();
    }

    static String 文本_转拼音(String 欲处理文本) {
        char[] strArr = 欲处理文本.toCharArray();
        String str = "";
        for (char v : strArr) {
            if (Pinyin.isChinese(v)) {
                str += Pinyin.toPinyin(v) + " ";
            } else
                str += v;
        }
        return str;


    }
}
