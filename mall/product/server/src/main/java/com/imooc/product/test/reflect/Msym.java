package com.imooc.product.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * invoke 是通过反射执行对应的方法
 */
public class Msym {
    
    public static void main(String[] arg) throws Exception {
       demo1();
    }
    public int sum(String[] a,Integer b){
        System.out.println(a.length);
        return a.length;
    }
    public static void demo1() throws Exception {
        //获取字节码对象
        Class<Msym> clazz = (Class<Msym>) Class.forName("com.imooc.product.test.reflect.Msym");
        //获取一个对象
        Constructor con =  clazz.getConstructor();
        Msym m = (Msym) con.newInstance();
        String[] s = new String[]{"aa","bb"};
        //获取Method对象
        Method method = clazz.getMethod("sum",String[].class,Integer.class);
        //调用invoke方法来调用,获取返回结果
        int invoke = (int)method.invoke(m, (Object) s,1);
        System.err.println(invoke);
    }
}