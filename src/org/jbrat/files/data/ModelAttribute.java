package org.jbrat.files.data;


import org.jbrat.files.data.abstracts.JModelAttribute;

public class ModelAttribute implements JModelAttribute{
    private String modelName;
    private String modelPackage;
    private boolean needTrim;
    private boolean needDuplicate;

    @Override
    public String getName() {
        return modelName;
    }

    @Override
    public String getPackage() {
        return modelPackage;
    }

    @Override
    public boolean isTrimable() {
        return needTrim;
    }

    @Override
    public boolean isDuplicatable() {
        return needDuplicate;
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
    public void setTrimable(boolean needTrim) {
        this.needTrim = needTrim;
    }

    @Override
    public void setDuplicatable(boolean needDuplicate) {
        this.needDuplicate = needDuplicate;
    }
}
