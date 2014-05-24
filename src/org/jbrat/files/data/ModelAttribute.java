package org.jbrat.files.data;


import org.jbrat.files.data.abstracts.JModelAttribute;

public class ModelAttribute implements JModelAttribute{
    private String modelName;
    private String modelPackage;
    private boolean isPersistant;

    @Override
    public String getName() {
        return modelName;
    }

    @Override
    public String getPackage() {
        return modelPackage;
    }

    @Override
    public boolean isPersistant() {
        return isPersistant;
    }

    @Override
    public void setName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public void setPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }


    @Override
    public void setPersistant(boolean needDuplicate) {
        this.isPersistant = needDuplicate;
    }
}
