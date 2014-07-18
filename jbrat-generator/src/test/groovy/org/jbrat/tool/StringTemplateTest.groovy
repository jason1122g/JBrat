package org.jbrat.tool

import spock.lang.Specification

class StringTemplateTest extends Specification{

    def "basic template from string"(){
        given:
            def template = new StringTemplate("Hello\${word}")
        and:
            template.setProperty("word","World!")
        when:
            def result = template.toString()
        then:
            result == "HelloWorld!"
    }

    def "basic template from file"(){
        given:
            def file     = new File(this.class.getResource("/template1.txt").toURI())
            def template = new StringTemplate(file)
        and:
            template.setProperty("word","World!")
        when:
            def result = template.toString()
        then:
            result == "HelloWorld!"
    }

}
