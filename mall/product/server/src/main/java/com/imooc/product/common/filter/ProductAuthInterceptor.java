package com.imooc.product.common.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

@Component
public class ProductAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //处理自定义注解
        if(this.hasPermission(handler)){

            return true;
        }
        response.sendRedirect("http://www.baidu.com");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 鉴权
     * @param handler
     * @return
     */
    private boolean hasPermission(Object handler){
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //获取方法上的注解对象
            SignAuthention authention = handlerMethod.getMethod().getAnnotation(SignAuthention.class);
            //如果该方法为空则获取类上的注解
            if (authention == null){
                authention = handlerMethod.getMethod().getDeclaringClass().getAnnotation(SignAuthention.class);
            }
            //如果标记了注解，则判断权限  && StringUtils.isNotBlank(authention.value())
            if (authention != null){
                String[] result = authention.result();
                if(result!=null && result.length>0){
                    String str = "";
                    for (String s :
                            result) {
                        str+=str+",";
                    }
                    System.err.println(str);
                }
                //redis获取数据库获取该用户的权限信息，并判断是否有权限
                System.err.println("设置商品访问的权限一！" + authention.value());
                //满足
                System.err.println("this is change ---- ");

               //========上边获取类上的注解的名字========下边是获取请求参数 方法名 controller内容=============================================

                System.out.println("=================获取方法所在类上的所有注解==================");
                Method method = handlerMethod.getMethod();
                Annotation[] annotations = method.getDeclaringClass().getAnnotations();
                for (Annotation annotation :annotations) {
                    System.out.println(annotation.annotationType());
                }
                System.out.println("=================获取方法上的所有注解==================");
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                for (Annotation annotation : declaredAnnotations) {
                    System.out.println(annotation.annotationType());
                }
                System.out.println("=================获取方法所在的类反射对象，进而可以查到该类中所有的属性和方法==================");
                Class<?> declaringClass = method.getDeclaringClass();
                Method[] methods = declaringClass.getMethods();
                for(Method method1 : methods){
                    String name = method1.getName();//查询方法名  如：listForOrder
                    System.err.println(name+"-----method");
                    Parameter[] parameters = method.getParameters();
                    for (Parameter parameter : parameters) {
                        Type parameterizedType = parameter.getParameterizedType();
                        System.err.println(parameterizedType.getTypeName() + " ----type");
                        System.err.println(parameter.getName() +" -----name");//获取参数的名字；如 name
                    }
                }
                return true;
            }
        }
        return false;
    }
}
