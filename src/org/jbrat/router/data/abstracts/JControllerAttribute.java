package org.jbrat.router.data.abstracts;

public interface JControllerAttribute {
    public String getControllerName();
    public String getControllerPackage();
    public JModelAttribute[] getModelAttributes();

    public void setControllerName(String name);
    public void setControllerPackage(String controllerPackage);
    public void setModelAttributes(JModelAttribute[] models);
}
