package org.jbrat.exceptions;

public class JBratException extends RuntimeException {
    public JBratException(){
        super();
    }
    public JBratException(String msg){
        super(msg);
    }
}
