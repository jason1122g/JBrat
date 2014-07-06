package tools

import java.lang.reflect.Method


class ClassChecker {
    static def classIsLoaded(String name){
        Class[] classes = new Class[1];
        classes[0] = String.class;
        Method method = ClassLoader.class.getDeclaredMethod("findLoadedClass", classes);
        method.setAccessible(true);
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return method.invoke(classLoader, name) != null ;
    }
}
