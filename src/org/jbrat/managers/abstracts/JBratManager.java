package org.jbrat.managers.abstracts;


public interface JBratManager<Type> {

    public void loadAttribute(String fileName);

    public void createViewResource(Type element);

    public void deleteViewResource(Type element);

}
