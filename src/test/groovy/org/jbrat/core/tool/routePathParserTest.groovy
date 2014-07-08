package org.jbrat.core.tool

import org.jbrat.exceptions.IncorrectFormatException
import spock.lang.Specification


class routePathParserTest extends Specification {

    def "parse without params"(){
        when:
            def parser = new routePathParser("helloworld")
        then:
            parser.getPath()   == "helloworld"
    }

    def "parse with 1 param"(){
        when:
            def parser = new routePathParser("test?a=1")
        then:
            parser.getPath()     == "test"
            parser.getParams().a == "1"
    }

    def "parse with 2 params"(){
        when:
            def parser = new routePathParser("test?var1=1,var2=2")
        then:
            parser.getPath()     == "test"
            parser.getParams().var1 == "1"
            parser.getParams().var2 == "2"
    }

    def "parse with unexpected param format"(){
        when:
            def parser = new routePathParser("test? a = 1")
        then:
            parser.getPath()         == "test"
            parser.getParams().a     != "1"
            parser.getParams()." a " == " 1"
    }

    def "parse with unused comma"(){
        when:
            def parser = new routePathParser("test?a=1,")
        then:
            parser.getPath()      == "test"
            parser.getParams().a  == "1"
    }

    def "parse with too many ?"(){
        when:
            new routePathParser("test?a=1?")
        then:
            thrown(IncorrectFormatException)
    }
}
