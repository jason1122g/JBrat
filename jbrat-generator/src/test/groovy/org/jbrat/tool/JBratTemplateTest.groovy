package org.jbrat.tool

import spock.lang.Specification

class JBratTemplateTest extends Specification {

    def "get a template after specify a type and inject the value"(){
        given:
            def template = new JBratTemplate(type).asStringTemplate()
        and:
            def targetText   = new File( getResourceURI(comparedFilePath) ).text
        when:
            template.setProperty("name"   ,"Hello")
            template.setProperty("package",".other")
        and:
            def sourceText = template.toString()
        then:
            sourceText == targetText

        where:
            type                     | comparedFilePath
            JBratTemplate.VIEW       | "/other/Hello_View.txt"
            JBratTemplate.CONTROLLER | "/other/Hello_Controller.txt"
            JBratTemplate.HELPER     | "/other/Hello_Helper.txt"
    }

    private URI getResourceURI(String path){
        return this.class.getResource(path).toURI()
    }
}
