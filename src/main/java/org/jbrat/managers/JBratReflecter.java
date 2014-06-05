package org.jbrat.managers;

import org.jbrat.combiners.JCombiner;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.views.abstracts.JView;

import java.lang.reflect.Constructor;

final class JBratReflecter {

    private static Object reflectByPackageNameAndParams(String packageName, Object... params) throws ReflectiveOperationException{
        Object object;
        if(params != null){
            object = reflectObjectWithParams (packageName,params);
        }else{
            object = reflectObjectWithNoParam(packageName);
        }
        return object;
    }
    private static Object reflectObjectWithParams (String packageName,Object...params) throws ReflectiveOperationException{
        Class[] argumentTypes = new Class[params.length];
        for(int i=0;i<argumentTypes.length;i++){
            argumentTypes[i] = params.getClass();
        }

        Constructor viewConstructor = Class.forName(packageName).getDeclaredConstructor(argumentTypes);
        return  viewConstructor.newInstance(params);
    }
    private static Object reflectObjectWithNoParam(String packageName) throws ReflectiveOperationException{
        return Class.forName(packageName).newInstance();
    }


    public static JModel reflectModel(String name) throws ReflectiveOperationException{
        return  (JModel) reflectByPackageNameAndParams(name);
    }

    public static JView reflectView(String name, Object...params) throws ReflectiveOperationException{
        return  (JView) reflectByPackageNameAndParams(name,params);
    }

    public static JCombiner reflectCombiner(String name) throws ReflectiveOperationException{
        return  (JCombiner) reflectByPackageNameAndParams(name);
    }
}
