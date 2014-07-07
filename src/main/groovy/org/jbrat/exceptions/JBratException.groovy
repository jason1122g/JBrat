package org.jbrat.exceptions


class JBratException extends RuntimeException{
    JBratException(){

    }
    JBratException(String msg){
        super(msg)
    }
}
