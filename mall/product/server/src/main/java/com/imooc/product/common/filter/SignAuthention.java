package com.imooc.product.common.filter;

import java.lang.annotation.*;

/**
 * 主要学习java反射，自定义注解，拦截器
 *
 *
 * ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
 * ElementType.CONSTRUCTOR 可以给构造方法进行注解
 * ElementType.FIELD 可以给属性进行注解
 * ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
 * ElementType.METHOD 可以给方法进行注解
 * ElementType.PACKAGE 可以给一个包进行注解
 * ElementType.PARAMETER 可以给一个方法内的参数进行注解
 * ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
 *
 *
 * @Repeatable
 * Repeatable 自然是可重复的意思。@Repeatable 是 Java 1.8 才加进来的，所以算是一个新的特性。
 *
 */                                             //Target 是目标的意思，@Target 指定了注解运用的地方。
@Target({ElementType.TYPE, ElementType.METHOD}) //ElementType.TYPE，ElementType.METHOD表示注解可以标记类和方法
@Retention(RetentionPolicy.RUNTIME) //运行时起作用   它解释说明了这个注解的的存活时间。
@Inherited //注解 Test 被 @Inherited 修饰，之后类 A 被 Test 注解，类 B 继承 A,类 B 也拥有 Test 这个注解。
@Documented //顾名思义，这个元注解肯定是和文档有关。它的作用是能够将注解中的元素包含到 Javadoc 中去
public @interface SignAuthention {
    String value() default "";
    String[] result() default {};
}
