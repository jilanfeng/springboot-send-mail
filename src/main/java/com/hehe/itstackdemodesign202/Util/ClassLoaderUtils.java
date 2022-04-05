package com.hehe.itstackdemodesign202.Util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘伟锋
 * @date 2021/12/11
 **/
public class ClassLoaderUtils {

    private static Set<Class> primitiveSet = new HashSet<Class>();

    static {
        primitiveSet.add(Integer.class);
        primitiveSet.add(Long.class);
        primitiveSet.add(Float.class);
        primitiveSet.add(Byte.class);
        primitiveSet.add(Short.class);
        primitiveSet.add(Double.class);
        primitiveSet.add(Character.class);
        primitiveSet.add(Boolean.class);
    }


    /**
     * 得到当前ClassLoader
     *
     * @return classLoader
     */
    public static ClassLoader getCurrentClassLoader() {
        ClassLoader c1 = Thread.currentThread().getContextClassLoader();
        if(c1 == null) {
            c1 = ClassLoaderUtils.class.getClassLoader();
        }
        return c1 == null ? ClassLoader.getSystemClassLoader() : c1;

    }


    public static ClassLoader getClassLoader(Class<?> clazz) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader != null) {
            return loader;
        }
        if (clazz != null) {
            loader = clazz.getClassLoader();
            if (loader!=null) {
                return loader;
            }
            return clazz.getClassLoader();
        }
        return ClassLoader.getSystemClassLoader();
    }


    public static Class forName(String className) throws ClassNotFoundException {
        return forName(className,true);
    }

    public static Class forName(String className, boolean initialize) throws ClassNotFoundException{
        return Class.forName(className,initialize,getCurrentClassLoader());

    }

    public static Class forName(String className,ClassLoader c1) throws ClassNotFoundException{
        return Class.forName(className,true,c1);

    }


    public static <T> T newInstance(Class<T> clazz) throws Exception {

        if (primitiveSet.contains(clazz)) {
            return null;
        }
        if (clazz.isMemberClass() && !Modifier.isStatic(clazz.getModifiers())) {
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            Constructor defaultConstructor = null;
            for (Constructor<?> constructor : constructors) {
                if (constructor.getParameterTypes().length == 1) {
                    defaultConstructor = constructor;
                    break;
                }
            }
            if (defaultConstructor != null) {
                if (defaultConstructor.isAccessible()) {
                    return (T) defaultConstructor.newInstance(new Object[]{null});
                } else {
                    try {
                        defaultConstructor.setAccessible(true);
                        return (T) defaultConstructor.newInstance(new Object[]{null});
                    } finally {
                        defaultConstructor.setAccessible(false);
                    }
                }
            } else {
                throw new Exception("The " + clazz.getCanonicalName() + "has no default constructors!");
            }
        }
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            if (constructor.isAccessible()) {
                throw new Exception("The " + clazz.getCanonicalName() + "has no default constructor!",e);
            } else {
                try {
                    constructor.setAccessible(true);
                    return constructor.newInstance();
                } finally {
                    constructor.setAccessible(false);
                }
            }
        }
    }

    public static Class<?>[] getClazzArgs(Object[] args) {
        Class<?>[] parameterTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ArrayList) {
                parameterTypes[i] = List.class;
                continue;
            }
            if (args[i] instanceof LinkedList) {
                parameterTypes[i] = List.class;
                continue;
            }
            if (args[i] instanceof HashMap) {
                parameterTypes[i] = Map.class;
                continue;
            }
            if (args[i] instanceof Long) {
                parameterTypes[i] = long.class;
                continue;
            }
            if (args[i] instanceof Double) {
                parameterTypes[i] = double.class;
                continue;
            }
            if (args[i] instanceof TimeUnit) {
                parameterTypes[i] = TimeUnit.class;
                continue;
            }
            parameterTypes[i] = args[i].getClass();
        }
        return parameterTypes;
    }
}
