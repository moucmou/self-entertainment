package com.self.entertainment.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: zhutao
 * @date: 2020/10/19 5:30 下午
 *
 *
 *
 * 从
 * "baseInfo.test.hahah.bb";
 * "baseInfo.test.gg"
 * 生成
 * {"test":{"gg":"","hahah":{"bb":""}}}
 */
public class String2Utils {

    //String a = "baseInfo.test.hahah";
    String b = "baseInfo.test.hahah.bb";
    String c = "baseInfo.test.gg";
    //String d = "baseInfo.test";



    /**
     * 补充父节点构建json树 根据层级关系补路径,如根据子节点补出其父节点路径 子节点： datail_data.baseInfo.resourceName datail_data.professionalInfo.square
     * 补出来的父节点： datail_data.baseInfo datail_data.professionalInfo
     *
     * @param list
     * @return
     */
    private static Set<String> supplement(List<String> list) {
        Set<String> all = new HashSet<>();
        if (!CollectionUtils.isEmpty(list)) {
            for (String path : list) {
                while (path.contains(".")) {
                    path = StringUtils.substringBeforeLast(path, ".");
                    if (!list.contains(path) && path.contains(".")) {
                        all.add(path);
                    }
                }
            }
        }
        return all;
    }


    public static void main(String[] args) {
        //String a = "baseInfo.test.hahah";
        String b = "baseInfo.test.hahah.bb";
        String c = "baseInfo.test.gg";
        //String d = "baseInfo.test";

        List<String> list = Stream.of(b, c).collect(Collectors.toList());
        List<FieldBeanBO> tem = new ArrayList<>();
        Set<String> set= supplement(list);
        list.addAll(set);
        for (String temp : list) {
            tem.add(new FieldBeanBO(temp, StringUtils.substringBeforeLast(temp, ".")));
        }

        Map<String, List<FieldBeanBO>> zoneByParentIdMap = tem.stream()
                .collect(Collectors.groupingBy(FieldBeanBO::getParentPath));
        for (FieldBeanBO zone : tem) {
            List<FieldBeanBO> tem1 = zoneByParentIdMap.getOrDefault(zone.getPath(), Collections.emptyList());
            zone.getFieldBeanBO().addAll(tem1);
        }
        List<FieldBeanBO> treeList = tem.stream().filter(v -> v.getParentPath().equals("baseInfo"))
                .collect(Collectors.toList());
        Object map = doBuildJsonTree(treeList);

    }

    static Map<String, Object> doBuildJsonTree(List<FieldBeanBO> treeList) {

        Map<String, Object> jsonObject = new LinkedHashMap<>();
        for (FieldBeanBO fieldBeanBO : treeList) {
            if (!CollectionUtils.isEmpty(fieldBeanBO.getFieldBeanBO())) {
                jsonObject.put(StringUtils.substringAfterLast(fieldBeanBO.getPath(), "."),
                        doBuildJsonTree(fieldBeanBO.getFieldBeanBO()));
            } else {
                jsonObject.put(StringUtils.substringAfterLast(fieldBeanBO.getPath(), "."), fieldBeanBO.getValue());
            }
        }
        return jsonObject;

    }

    public static class FieldBeanBO {

        private String path;
        private String parentPath;
        private List<FieldBeanBO> fieldBeanBO = new ArrayList<>();
        private String value = "";

        public FieldBeanBO(String path, String parentPath) {
            this.path = path;
            this.parentPath = parentPath;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getParentPath() {
            return parentPath;
        }

        public void setParentPath(String parentPath) {
            this.parentPath = parentPath;
        }

        public List<FieldBeanBO> getFieldBeanBO() {
            return fieldBeanBO;
        }

        public void setFieldBeanBO(List<FieldBeanBO> fieldBeanBO) {
            this.fieldBeanBO = fieldBeanBO;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
