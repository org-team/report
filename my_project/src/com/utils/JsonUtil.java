package com.utils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.user.po.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import net.sf.json.JSONObject;

/**
 * @author: zhangKangChuang
 * package: com.utils
 * class_name: JsonUtil
 * describe: json map list String 互转
 * email: 996789881@qq.com
 * @data: 2017/12/26 0026 上午 10:47
 **/
public class JsonUtil {


    public static final Gson gson = new Gson();

    private JsonUtil() {

    }

    public static <T> T fromJson(String jsonStr, Class<T> c)
            throws JsonSyntaxException {
        return gson.fromJson(jsonStr, c);
    }

    public static <T> T fromJsonList(String jsonStr) throws JsonSyntaxException {
        return gson.fromJson(jsonStr, new TypeToken<T>() {
        }.getType());
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static Map<String, Object> mapFromJson(String jsondata) {
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(jsondata, type);
        return map;
    }

    public static Map<String, String> mapStringFromJson(String jsondata) {
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Gson gson = new Gson();
        Map<String, String> map = gson.fromJson(jsondata, type);
        return map;
    }


    public static <T> List<T> listFromJson(String jsondata) {
        Type type = new TypeToken<List<T>>() {
        }.getType();
        Gson gson = new Gson();
        List<T> map = gson.fromJson(jsondata, type);
        return map;
    }

    public static Object toBean(String className, String json) {
        JSONObject obj = JSONObject.fromObject(json);

        Class<?> c = null;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        Object toBean = null;
        try {
            toBean = c.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        toBean = JSONObject.toBean(obj, toBean.getClass());
        return toBean;
    }

    public static String toJson(Object object, String timeType) {
        if (null == timeType || "".equals(timeType.trim())) {
            timeType = "yyyy-MM-dd HH:mm:ss";
        }
        return new GsonBuilder().setDateFormat(timeType).create()
                .toJson(object);
    }

    public static void main(String[] args) {

        Map<String, String> chuanMap = new HashMap<String, String>();
        chuanMap.put("startTime", "2017-11-1 6:32");
        chuanMap.put("quantity", "1");
        //map转String
        String json = JsonUtil.toJson(chuanMap);
        System.out.println(json);
        //String转map
        Map<String,Object > map= JsonUtil.mapFromJson("{}");
        //String转对象
        User a =JsonUtil.fromJson("{}", User.class);
    }


}
