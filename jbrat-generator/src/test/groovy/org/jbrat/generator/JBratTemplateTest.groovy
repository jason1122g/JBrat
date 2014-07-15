package org.jbrat.generator

import spock.lang.Shared
import spock.lang.Specification

class JBratTemplateTest extends Specification {

    @Shared def name   = "Hello"
    @Shared def files  = ["/Hello_View.txt","/Hello_Controller.txt","/Hello_Helper.txt"]

    def "view template test"(){
        given:
            def source = new JBratTemplate(name,JBratTemplate.VIEW).toString()
            def target = new File(getResourceURI(files[0])).text
        expect:
            source == target
    }

    def "controller template test"(){
        given:
            def source = new JBratTemplate(name,JBratTemplate.CONTROLLER).toString()
            def target = new File(getResourceURI(files[1])).text
        expect:
            source == target
    }

    def "helper template test"(){
        given:
            def source = new JBratTemplate(name,JBratTemplate.HELPER).toString()
            def target = new File(getResourceURI(files[2])).text
        expect:
            source == target
    }

    private URI getResourceURI(String path){
        return this.class.getResource(path).toURI()
    }
}
