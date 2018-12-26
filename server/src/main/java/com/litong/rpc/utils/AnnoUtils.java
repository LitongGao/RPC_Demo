package com.litong.rpc.utils;

import com.litong.rpc.anno.RpcClass;
import com.litong.rpc.anno.RpcMethod;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;

public class AnnoUtils {

    private static Map<String, List<Map<String, List<String>>>> map = new HashMap<>();
    public static void parseAnno(String packageName) {
        /**
         * 1. 需要扽到所有类
         * 2. 解析类是否需要发布
         * 3. 解析方法是否需要发布
         * 4. 发布方法
         */
        String packagePath = packageName.replace(".", "/");
        String bashPath = AnnoUtils.class.getResource("/").getPath();
        System.out.println(bashPath+packagePath);
        File file = new File(bashPath+packagePath);
        String[] classNames = file.list();
        System.out.println("class array are: "+classNames);
        for (String className : classNames) {
            className = className.replaceAll(".class","");
            try {
                Class clazz = Class.forName(packageName+"."+className);
                if (clazz.isAnnotationPresent(RpcClass.class)) {
                    System.out.println("with Rpc Anno: " + clazz.getName());
                    Method[] methods = clazz.getDeclaredMethods();
                    List<Map<String, List<String>>> methodsInfos = new ArrayList<>();
                    for (Method method : methods) {
                        Map<String, List<String>> methodInfo = new HashMap<>();
                        if (method.isAnnotationPresent(RpcMethod.class)) {
                            Class[] parameTypes = method.getParameterTypes();
                            List<String> parames = new ArrayList<>();
                            for (Class parameType : parameTypes) {
                                parames.add(parameType.getSimpleName());
                            }
                            methodInfo.put(method.getName(), parames);
                        }
                        methodsInfos.add(methodInfo);

                    }
                    map.put(packageName+"."+className,methodsInfos);
                    Object object= JSONObject.toJSON(map);
                    System.out.println(object.toString());
                } else {
                    System.out.println("without Rpc Anno: " + clazz.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        AnnoUtils.parseAnno("com.litong.rpc.dao");
    }
}
