package org.jbrat.core.tool

import org.jbrat.exceptions.ResourceNotFoundError
import spock.lang.Specification

class ResourcerTest extends Specification {
    def "get the exist resource uri"(){
        expect:
            Resourcer.getResourceURI("/jbrat") != null
    }

    def "throw error if get resource which is not exist"(){
        when:
            Resourcer.getResourceURI("/resourceNotExist")
        then:
            thrown(ResourceNotFoundError)
    }
}
