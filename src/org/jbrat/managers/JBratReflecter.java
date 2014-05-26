package org.jbrat.managers;

import org.jbrat.combiners.JCombiner;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.views.abstracts.JView;

class JBratReflecter {
    //TODO EXCEPTION HANDLE
    private static Object reflectByPackageName(String packageName){
        Object object = null;
        try {
            object = Class.forName(packageName).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }

    public static JModel reflectModel(String name){
        return  (JModel)reflectByPackageName(name);
    }

    public static JView reflectView(String name){
        return  (JView)reflectByPackageName(name);
    }

    public static JCombiner reflectCombiner(String name){
        return  (JCombiner)reflectByPackageName(name);
    }
}
