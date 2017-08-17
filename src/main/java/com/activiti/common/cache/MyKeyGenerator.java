//package com.activiti.common.cache;
//
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
///**
// * Created by 12490 on 2017/8/18.
// */
//@Component
//public class MyKeyGenerator implements KeyGenerator {
//    @Override
//    public Object generate(Object o, Method method, Object... objects) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(target.getClass().getName());
//        sb.append(method.getName());
//        for (Object obj : params) {
//            sb.append(obj.toString());
//        }
//        return sb.toString();
//    }
//}
