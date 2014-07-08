package org.jbrat.exceptions


class RouteFailedException extends JBratException{
    RouteFailedException(String msg){
        super(msg)
    }
    RouteFailedException(Exception e){
        super(e)
    }
}
