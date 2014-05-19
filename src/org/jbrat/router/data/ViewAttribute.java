package org.jbrat.router.data;


import org.jbrat.router.data.abstracts.JControllerAttribute;
import org.jbrat.router.data.abstracts.JViewAttribute;

public class ViewAttribute implements JViewAttribute {
    private String viewName;
    private String viewPackage;
    private JControllerAttribute controllerAttribute;

    @Override
    public String getViewName() {
        return viewName;
    }

    @Override
    public String getViewPackage() {
        return viewPackage;
    }

    @Override
    public JControllerAttribute getControllerAttribute() {
        return controllerAttribute;
    }

    @Override
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void setViewPackage(String viewPackage) {
        this.viewPackage = viewPackage;
    }

    @Override
    public void setControllerAttribute(JControllerAttribute controllerAttribute) {
        this.controllerAttribute = controllerAttribute;
    }
}
