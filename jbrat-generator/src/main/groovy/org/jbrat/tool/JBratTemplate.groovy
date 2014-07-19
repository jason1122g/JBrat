package org.jbrat.tool

import groovy.transform.CompileStatic

@CompileStatic
class JBratTemplate {

    static final String CONTROLLER = "Controller"
    static final String HELPER     = "Helper"
    static final String VIEW       = "View"

    private String type

    JBratTemplate(String type){
        this.type = type
    }

    StringTemplate asStringTemplate(){
        return getTemplate("/templates/${type.toLowerCase()}.txt")
    }

    private static StringTemplate getTemplate(String path){
        new StringTemplate(new File(this.class.getResource(path).toURI()))
    }

}
