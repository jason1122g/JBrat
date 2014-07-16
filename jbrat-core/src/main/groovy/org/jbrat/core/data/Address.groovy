package org.jbrat.core.data

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bean
import org.jbrat.exceptions.IncorrectFormatError

import java.util.regex.Matcher

@CompileStatic
class Address {

    private String  address

    private String  path
    private Bean    params

    Address(String address){
        this.address = address
        this.params  = BeanFactory.createEmpty()
        processAddress();
    }

    private void processAddress(){

        Matcher uriMatcher = address =~ /^([-. a-zA-Z0-9_]+)\??((\w+=\w+)(,\w+=\w+)*)?$/

        if(uriMatcher.matches()){
            path        = uriMatcher.group(1)
            String args = uriMatcher.group(2)
            args?.split(",")?.each { String pair->
                String[] data = pair.split("=")
                params.setProperty(data[0],data[1])
            }
        }else{
            throw new IncorrectFormatError("parse error:"+address)
        }

    }

    Bean getParams(){
        return params
    }

    String getPath(){
        return path
    }
}
