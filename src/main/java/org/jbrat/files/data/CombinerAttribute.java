package org.jbrat.files.data;


import org.jbrat.files.data.abstracts.JCombinerAttribute;

import java.util.Collection;
import java.util.LinkedList;

public final class CombinerAttribute implements JCombinerAttribute {

    private String combinerName    = "";
    private String combinerPackage = "";
    private Collection<String> nameList    = new LinkedList<>();
    private Collection<Boolean> persistList = new LinkedList<>();

    @Override
    public String getName() {
        return combinerName;
    }

    @Override
    public String getPackage() {
        return combinerPackage;
    }

    @Override
    public String[] getModelNames() {
        if(nameList.size()!=0){
            return nameList.toArray(new String[nameList.size()]);
        }else{
            return null;
        }
    }

    @Override
    public boolean[] getModelPersists() {
        if(persistList.size()!=0){
            boolean[] booleans = new boolean[persistList.size()];
            int i = 0;
            for(Boolean bool : persistList){
                booleans[i] = bool;
                i++;
            }
            return booleans;
        }else{
            return null;
        }
    }

    @Override
    public void setName(String name) {
        this.combinerName = name;
    }

    @Override
    public void setPackage(String controllerPackage) {
        this.combinerPackage = controllerPackage;
    }

    @Override
    public void addModelNamePersist(String modelName, boolean isPersist) {
        nameList.add(modelName);
        persistList.add(isPersist);
    }
}
