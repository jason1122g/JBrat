package org.jbrat.models.abstracts;


public interface DataHandler<Type> {
    public void handle(Type dataNext,Type dataPrev);
}