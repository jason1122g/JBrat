package org.jbrat.exceptions


class JBratError extends Error{
    JBratError(){

    }

    JBratError(String msg){
        super(msg)
    }

    JBratError(Exception e){
        super(e)
    }
}
