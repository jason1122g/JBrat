package org.jbrat.files.data;


import org.jbrat.files.data.abstracts.JCombinerAttribute;
import org.jbrat.files.data.abstracts.JModelAttribute;

public class CombinerAttribute implements JCombinerAttribute {

    private String controllerName;
    private String controllerPackage;
    private JModelAttribute[] models;

    @Override
    public String getName() {
        return controllerName;
    }

    @Override
    public String getPackage() {
        return controllerPackage;
    }

    @Override
    public JModelAttribute[] getModelAttributes() {
        return models;
    }

    @Override
    public void setName(String name) {
        this.controllerName = name;
    }

    @Override
    public void setPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    @Override
    public void setModelAttributes(JModelAttribute[] models) {
        this.models = models;
    }
}
