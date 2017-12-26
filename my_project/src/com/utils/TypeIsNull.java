package com.utils;

/**
 * @author: zhangKangChuang
 * package: com.utils
 * class_name: TypeIsNull
 * describe: 方便判断参数是否为空
 * email: 996789881@qq.com
 * @data: 2017/12/26 0026 上午 11:50
 **/
public class TypeIsNull {
    /**
     * 判断包装类是否为空
     * @param args
     * @return 为空返回false 不为空返回true  默认不为空
     */
    public static Boolean typeIsNull(Object... args) {
        Boolean b = true;
        System.out.println(args.length);
        for (int i = 0; i < args.length; i++) {

            if (args[i] == null) {
                b=false;
            } else {
                if ("".equals(args[i].toString())) {
                    b=false;
                }
            }
        }
        return b;
    }
}
