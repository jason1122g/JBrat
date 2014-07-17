package org.jbrat.exceptions


class IncorrectFormatError extends JBratError{
    IncorrectFormatError(String msg){
        super(msg)
    }

    IncorrectFormatError(Exception e){
        super(e)
    }

    IncorrectFormatError(String msg, Throwable cause){
        super(msg,cause)
    }
}
