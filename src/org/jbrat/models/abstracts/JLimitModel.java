package org.jbrat.models.abstracts;

public interface JLimitModel<Type> {
    public Type get(String name);
    public void bind  (String name, DataHandler<Type> handler);
    public void unbind(String name, DataHandler<Type> handler);
}
