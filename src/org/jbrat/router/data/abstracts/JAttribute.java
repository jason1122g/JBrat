package org.jbrat.router.data.abstracts;


public interface JAttribute {
    public void setViewAttribute(String name,JViewAttribute viewAttribute);
    public JViewAttribute getViewAttribute(String name);
}
