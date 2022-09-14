package com.hspedu.reflection.question;

import com.hspedu.Cat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 项目名：    chapter23
 * 文件名：    ReflectionQuestion
 * 创建时间：   2022/9/12 10:00
 *
 * @author crazy Chen
 * 描述： 反射问题的引入     TODO
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //根据配置文件 re.properties 指定信息，创建Cat对象并调用方法hi
        //传统方式 new 对象，调用方法
        //使用反射机制
        //1,加载类，返回一个类aClass
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classFullPath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        Class aClass = Class.forName(classFullPath);
        //通过 aClass得到加载的类 com.hspedu.Cat的对象实例
        Object o = aClass.newInstance();
        System.out.println(o.getClass());
        //通过aClass对象得到加载类的method对象,在反射中，可以把方法视作对象
        Method method1 = aClass.getMethod(methodName);
        //通过method1来调用方法
        System.out.println("=======================");
        method1.invoke(o);//传统方法是对象.方法(),而反射是方法.invoke(对象)
    }
}
