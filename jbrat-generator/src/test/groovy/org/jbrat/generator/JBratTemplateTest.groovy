package org.jbrat.generator

import spock.lang.Shared
import spock.lang.Specification

class JBratTemplateTest extends Specification {

    @Shared def name   = "Hello"
    @Shared def pack   = ".other"
    @Shared def files  = ["/Hello_View.txt","/Hello_Controller.txt","/Hello_Helper.txt"]

    def "view template test"(){
        given:
            def template = new JBratTemplate(JBratTemplate.VIEW).asStringTemplate()
            def target = new File(getResourceURI(files[0])).text
        when:
            template.setProperty("name",name)
            template.setProperty("package",pack)
        and:
            def source = template.toString()
        then:
            source == target
    }

    def "controller template test"(){
        given:
            def template = new JBratTemplate(JBratTemplate.CONTROLLER).asStringTemplate()
            def target = new File(getResourceURI(files[1])).text
        when:
            template.setProperty("name",name)
            template.setProperty("package",pack)
        and:
            def source = template.toString()
        then:
            source == target
    }

    def "helper template test"(){
        given:
            def template = new JBratTemplate(JBratTemplate.HELPER).asStringTemplate()
            def target = new File(getResourceURI(files[2])).text
        when:
            template.setProperty("name",name)
            template.setProperty("package",pack)
        and:
            def source = template.toString()
        then:
            source == target
    }

    private URI getResourceURI(String path){
        return this.class.getResource(path).toURI()
    }
}
