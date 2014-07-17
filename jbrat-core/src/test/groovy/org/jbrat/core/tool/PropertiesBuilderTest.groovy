package org.jbrat.core.tool

import org.jbrat.exceptions.ResourceNotFoundError
import spock.lang.Specification

class PropertiesBuilderTest extends Specification {
    def "read properties test"(){
        given:
            def property = new PropertiesBuilder().fromResource("/jbrat/config/routes.properties").build()
        expect:
            property."customRoute" == "incorrect"
    }

    def "read resource not exist will throw ResourceNotFoundError"(){
        when:
            new PropertiesBuilder().fromResource("/notExist/file.txt").build()
        then:
            thrown(ResourceNotFoundError)
    }
}
