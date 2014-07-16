package org.jbrat.core.data.abstracts


public interface Bean {
    def  getProperty(String name)
    void setProperty(String name, value)

    void bind   (String name,Closure closure)
    void unbind (String name,Closure closure)
}