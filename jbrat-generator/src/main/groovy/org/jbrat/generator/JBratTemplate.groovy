package org.jbrat.generator

import groovy.transform.CompileStatic

@CompileStatic
class JBratTemplate {

    static final String CONTROLLER = "Controller"
    static final String HELPER     = "Helper"
    static final String VIEW       = "View"

    private String name
    private String type

    JBratTemplate(String name,String type){
        this.name = name
        this.type = type
    }

    String toString(){
        generateTemplate().toString()
    }

    private  StringTemplate generateTemplate(){
        StringTemplate template = getTemplate("templates/${type.toLowerCase()}.txt")
        template.setProperty( "name", name)
        return template
    }

    private static StringTemplate getTemplate(String path){
        new StringTemplate(new File(path))
    }

}
