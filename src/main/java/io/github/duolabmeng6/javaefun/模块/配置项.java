package io.github.duolabmeng6.javaefun.模块;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.ini4j.Ini;
import org.ini4j.Profile.Section;

public class 配置项 {
    private Ini cfg;

    public 配置项(String 配置项数据) {
        加载配置项从文件(配置项数据);
    }

    public boolean 加载配置项从文件(String filepath) {
        try {
            Ini newCfg = new Ini();
            newCfg.getConfig().setEscape(false);
            newCfg.load(new File(filepath));
            this.cfg = newCfg;
            return true;
        } catch (IOException e) {
            System.out.println("配置项加载失败: " + e.getMessage());
            return false;
        }
    }

    public boolean 加载配置项从内存(String v) {
        try {
            Ini newCfg = new Ini();
            newCfg.getConfig().setEscape(false);
            newCfg.load(new StringReader(v));
            this.cfg = newCfg;
            return true;
        } catch (IOException e) {
            System.out.println("配置项加载失败: " + e.getMessage());
            return false;
        }
    }

    public String 读配置项(String 节名称, String 配置项名称, String 默认文本) {
        Section section = this.cfg.get(节名称);
        if (section == null) {
            return 默认文本;
        }
        return section.get(配置项名称, 默认文本);
    }

    public boolean 写配置项(String 节名称, String 配置项名称, String 设置文本) {
        this.cfg.put(节名称, 配置项名称, 设置文本);
        return true;
    }

    public void 写到文件(String filepath) {
        try {
            this.cfg.store(new File(filepath));
        } catch (IOException e) {
            System.out.println("配置项写入文件失败: " + e.getMessage());
        }
    }

    public List<String> 取节名() {
        Set<String> keys = this.cfg.keySet();
        List<String> keyList = new ArrayList<>(keys);
        return keyList;
    }

    public List<String> 取项名(String 节名称) {
        Set<String> keys = this.cfg.get(节名称).keySet();
        List<String> keyList = new ArrayList<>(keys);
        return keyList;
    }
}
