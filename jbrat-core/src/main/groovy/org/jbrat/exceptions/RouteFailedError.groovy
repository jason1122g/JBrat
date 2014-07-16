package org.jbrat.exceptions


class RouteFailedError extends JBratError{
    RouteFailedError(String msg){
        super(msg)
    }

    RouteFailedError(Exception e){
        super(e)
    }
}
