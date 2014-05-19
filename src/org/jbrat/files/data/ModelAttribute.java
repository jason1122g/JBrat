package org.jbrat.files.data;


import org.jbrat.files.data.abstracts.JModelAttribute;

public class ModelAttribute implements JModelAttribute{
    private String modelName;
    private String modelPackage;
    private boolean needTrim;
    private boolean needDuplicate;

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public String getModelPackage() {
        return modelPackage;
    }

    @Override
    public boolean needTrim() {
        return needTrim;
    }

    @Override
    public boolean needDuplicate() {
        return needDuplicate;
    }

    @Override
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    @Override
    public void setTrim(boolean needTrim) {
        this.needTrim = needTrim;
    }

    @Override
    public void setDuplicate(boolean needDuplicate) {
        this.needDuplicate = needDuplicate;
    }
}
