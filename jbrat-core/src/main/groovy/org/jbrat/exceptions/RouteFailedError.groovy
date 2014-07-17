package org.jbrat.exceptions


class RouteFailedError extends JBratError{
    RouteFailedError(String msg){
        super(msg)
    }

    RouteFailedError(Throwable cause){
        super(cause)
    }

    RouteFailedError(String msg, Throwable cause){
        super(msg,cause)
    }
}
