package org.jbrat.generator

import groovy.transform.CompileStatic

@CompileStatic
class StringTemplate {

    private String template
    private Map<String,String> words = [:]

    StringTemplate(String template){
        this.template = template
    }

    StringTemplate(File file){
        this.template = file.text
    }

    void setProperty(String key,String value){
        words[key] = value
    }

    String toString(){
        template.replaceAll(/\$\{(.+)}/) { String all, String key->
            words[key] == null ? "" : words[key]
        }
    }

}
