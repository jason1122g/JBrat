package org.jbrat.exceptions


class JBratError extends Error{
    JBratError(){

    }

    JBratError(String msg){
        super(msg)
    }

    JBratError(Throwable cause){
        super(cause)
    }

    JBratError(String msg,Throwable cause){
        super(msg,cause)
    }
}
