package org.jbrat.managers;


final class ModelAttribute implements JModelAttribute{
    private String modelName = "";
    private String modelPackage = "";
    private boolean isPersistant = false;

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
    public void setPersistant(boolean isPersistant) {
        this.isPersistant = isPersistant;
    }
}
