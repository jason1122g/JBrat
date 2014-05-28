package org.jbrat.files.data;


import org.jbrat.files.data.abstracts.JCombinerAttribute;

public final class CombinerAttribute implements JCombinerAttribute {

    private String combinerName;
    private String combinerPackage;
    private String[] modelNames;

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
        return modelNames;
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
    public void setModelNames(String[] modelNames) {
        this.modelNames = modelNames;
    }
}
