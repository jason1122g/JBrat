package org.jbrat.managers;

import org.jbrat.combiners.JCombiner;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.views.abstracts.JView;

import java.lang.reflect.Constructor;

final class JBratReflecter { //TODO EXCEPTION HANDLE

    private static Object reflectByPackageNameAndParams(String packageName, Object... params){
        Object object = null;
        try {
            if(params != null){
                object = reflectObjectWithParams (packageName,params);
            }else{
                object = reflectObjectWithNoParam(packageName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }
    private static Object reflectObjectWithParams (String packageName,Object...params) throws Exception{
        Class[] argumentTypes = new Class[params.length];
        for(int i=0;i<argumentTypes.length;i++){
            argumentTypes[i] = params.getClass();
        }

        Constructor viewConstructor = Class.forName(packageName).getDeclaredConstructor(argumentTypes);
        return  viewConstructor.newInstance(params);
    }
    private static Object reflectObjectWithNoParam(String packageName) throws Exception{
        return Class.forName(packageName).newInstance();
    }


    public static JModel reflectModel(String name){
        return  (JModel) reflectByPackageNameAndParams(name);
    }

    public static JView reflectView(String name, Object...params){
        return  (JView) reflectByPackageNameAndParams(name,params);
    }

    public static JCombiner reflectCombiner(String name){
        return  (JCombiner) reflectByPackageNameAndParams(name);
    }
}
