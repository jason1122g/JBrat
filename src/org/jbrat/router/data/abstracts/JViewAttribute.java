package org.jbrat.router.data.abstracts;


public interface JViewAttribute {
    public String getViewName();
    public String getViewPackage();
    public JControllerAttribute getControllerAttribute();

    public void setViewName(String viewName);
    public void setViewPackage(String viewPackage);
    public void setControllerAttribute(JControllerAttribute controllerAttribute);
}
