package org.jbrat.core.tool

import spock.lang.Specification

class ClasserTest extends Specification {

    def "return true if the class exist"(){
        expect:
            Classer.classExists("java.lang.Object")
    }

    def "return false if the class not exist"(){
        expect:
            !Classer.classExists("hahav.dd.Osd")
    }

}
