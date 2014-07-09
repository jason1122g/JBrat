package org.jbrat.core.tool

import org.jbrat.core.data.BeanFactory
import org.jbrat.exceptions.IncorrectFormatException


class routePathParser {

    private def path
    private def params
    private String uri

    routePathParser(uri){
        this.uri = uri
        this.params = BeanFactory.create()
        process();
    }

    private void process(){
        if(uri.contains('?')){

            if(uri.count('?') > 1){
                throw new IncorrectFormatException("symbol '?' more than one")
            }

            def uriParts = uri.split("\\?")
            path = uriParts[0]

            if(uriParts[1].contains(',')){
                uriParts[1].split(",").each {string->
                    def data = string.split("=")
                    params.setProperty(data[0],data[1])
                }
            }else{
                def data = uriParts[1].split("=")
                params.setProperty(data[0],data[1])
            }
        }else{
            path = uri
        }
    }

    def getParams(){
        return params
    }

    def getPath(){
        return path
    }
}
