package org.jbrat.exceptions;

public class ViewNotLoadException extends ResourceNotFoundException {
    public ViewNotLoadException(String msg){
        super(msg);
    }
}
