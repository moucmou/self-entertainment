package com.self.entertainment.mybatis.pojo;

/**
 * @author AmazingZ
 * @date 2019/7/25 21:44
 */

public enum Site {
    guiyang("guiyang", 0),
    luofu("luofu", 1);

    private String name;
    private Integer indexCode;

    Site(String name, Integer indexCode) {
        this.name = name;
        this.indexCode = indexCode;
    }

    public static Integer getValueByname(String name) {
        for (Site site : values()) {
            if (site.name.equals(name)) {
                return site.indexCode;
            }
        }
        return null;
    }

}
