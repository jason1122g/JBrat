package org.jbrat.files.data;


import org.jbrat.files.data.abstracts.JCombinerAttribute;
import org.jbrat.files.data.abstracts.JViewAttribute;

public class ViewAttribute implements JViewAttribute {
    private String viewName;
    private String viewPackage;
    private JCombinerAttribute controllerAttribute;

    @Override
    public String getName() {
        return viewName;
    }

    @Override
    public String getPackage() {
        return viewPackage;
    }

    @Override
    public JCombinerAttribute getCombinerAttribute() {
        return controllerAttribute;
    }

    @Override
    public void setName(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void setPackage(String viewPackage) {
        this.viewPackage = viewPackage;
    }

    @Override
    public void setCombinerAttribute(JCombinerAttribute controllerAttribute) {
        this.controllerAttribute = controllerAttribute;
    }
}
