package org.jbrat.core.tool

import org.jbrat.core.data.BeanFactory
import org.jbrat.exceptions.IncorrectFormatException


class PathParser {

    private def path
    private def params
    private String uri

    PathParser(uri){
        this.uri = uri
        this.params = BeanFactory.createEmpty()
        process();
    }

    private void process(){

        def uriMatcher = uri =~ /^([-. a-zA-Z0-9_]+)\??((\w+=\w+)(,\w+=\w+)*)?$/

        if(uriMatcher.matches()){
            path = uriMatcher.group(1)
            def args = uriMatcher.group(2)
            args?.split(",")?.each { pair->
                def data = pair.split("=")
                params.setProperty(data[0],data[1])
            }
        }else{
            throw new IncorrectFormatException("parse error:"+uri)
        }

    }

    def getParams(){
        return params
    }

    def getPath(){
        return path
    }
}
