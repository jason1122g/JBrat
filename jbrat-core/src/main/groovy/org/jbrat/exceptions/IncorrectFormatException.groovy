package org.jbrat.exceptions


class IncorrectFormatException extends JBratException{
    IncorrectFormatException(String msg){
        super(msg)
    }
    IncorrectFormatException(Exception e){
        super(e)
    }
}
