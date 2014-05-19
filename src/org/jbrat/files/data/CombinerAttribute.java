package org.jbrat.files.data;


import org.jbrat.files.data.abstracts.JControllerAttribute;
import org.jbrat.files.data.abstracts.JModelAttribute;

public class CombinerAttribute implements JControllerAttribute {

    private String controllerName;
    private String controllerPackage;
    private JModelAttribute[] models;

    @Override
    public String getControllerName() {
        return controllerName;
    }

    @Override
    public String getControllerPackage() {
        return controllerPackage;
    }

    @Override
    public JModelAttribute[] getModelAttributes() {
        return models;
    }

    @Override
    public void setControllerName(String name) {
        this.controllerName = name;
    }

    @Override
    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    @Override
    public void setModelAttributes(JModelAttribute[] models) {
        this.models = models;
    }
}
