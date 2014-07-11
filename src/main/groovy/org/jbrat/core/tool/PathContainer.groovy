package org.jbrat.core.tool

import groovy.transform.CompileStatic
import org.jbrat.core.data.Bean
import org.jbrat.core.data.BeanFactory
import org.jbrat.exceptions.IncorrectFormatException

import java.util.regex.Matcher

@CompileStatic
class PathContainer {

    private String path
    private String uri
    private Bean params

    PathContainer(uri){
        this.uri = uri
        this.params = BeanFactory.createEmpty()
        process();
    }

    private void process(){

        Matcher uriMatcher = uri =~ /^([-. a-zA-Z0-9_]+)\??((\w+=\w+)(,\w+=\w+)*)?$/

        if(uriMatcher.matches()){
            path = uriMatcher.group(1)
            String args = uriMatcher.group(2)
            args?.split(",")?.each { String pair->
                String[] data = pair.split("=")
                params.setProperty(data[0],data[1])
            }
        }else{
            throw new IncorrectFormatException("parse error:"+uri)
        }

    }

    Bean getParams(){
        return params
    }

    String getPath(){
        return path
    }
}
