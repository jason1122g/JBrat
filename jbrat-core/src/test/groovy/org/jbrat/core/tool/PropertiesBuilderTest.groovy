package org.jbrat.core.tool

import spock.lang.Specification

class PropertiesBuilderTest extends Specification {
    def "read properties test"(){
        given:
            def property = new PropertiesBuilder().fromResource("/jbrat/config/routes.properties").build()
        expect:
            property."customRoute" == "incorrect"
    }
}
