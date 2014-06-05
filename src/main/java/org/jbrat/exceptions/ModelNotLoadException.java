package org.jbrat.exceptions;

public class ModelNotLoadException extends ResourceNotFoundException {
    public ModelNotLoadException(String msg){
        super(msg);
    }
}
