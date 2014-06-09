package org.jbrat.managers;

import org.jbrat.models.abstracts.JModel;

import java.util.HashMap;
import java.util.Map;

final class JBratModelFactory {

    private Map<String,JModel> modelMap;

    public JBratModelFactory(){
        modelMap = new HashMap<>();
    }

    public JModel getOldModel(String packageName) throws ReflectiveOperationException{
        JModel model;
        if(modelMap.containsKey(packageName)){
            model = getModelIfContains(packageName);
        }else{
            model = getModelIfNotContains(packageName);
        }
        return model;
    }
    private JModel getModelIfContains(String packageName){
        return modelMap.get(packageName);
    }
    private JModel getModelIfNotContains(String packageName) throws ReflectiveOperationException{
        JModel model = getNewModel(packageName);
        modelMap.put(packageName,model);
        return model;
    }

    public JModel getNewModel(String packageName) throws ReflectiveOperationException{
        return JBratReflecter.reflectModel(packageName);
    }

}
