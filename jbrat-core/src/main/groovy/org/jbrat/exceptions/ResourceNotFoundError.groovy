package org.jbrat.exceptions

class ResourceNotFoundError extends JBratError{
    ResourceNotFoundError(String msg){
        super(msg)
    }

    ResourceNotFoundError(String msg, Throwable cause){
        super(msg,cause)
    }
}
