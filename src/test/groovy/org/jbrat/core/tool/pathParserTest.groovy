package org.jbrat.core.tool

import org.jbrat.exceptions.IncorrectFormatException
import spock.lang.Specification


class pathParserTest extends Specification {

    def "parse without params"(){
        when:
            def parser = new PathParser("helloworld")
        then:
            parser.getPath()   == "helloworld"
    }

    def "parse format of path is [-. a-zA-Z0-9_]"(){
        when:
            def parser = new PathParser("a.1_aA 3")
        then:
            parser.getPath()   == "a.1_aA 3"
    }

    def "parse with 1 param"(){
        when:
            def parser = new PathParser("test?a=1")
        then:
            parser.getPath()     == "test"
            parser.getParams().a == "1"
    }

    def "parse with 2 params"(){
        when:
            def parser = new PathParser("test?var1=var1,var2=var2")
        then:
            parser.getPath()     == "test"
            parser.getParams().var1 == "var1"
            parser.getParams().var2 == "var2"
    }

    def "parse format of param is  [a-zA-Z0-9_]"(){
        when:
            def parser = new PathParser("test?aA0=123,_var=tt")
        then:
            parser.getParams().aA0  == "123"
            parser.getParams()._var == "tt"
    }

    def "parse with spaces in param"(){
        when:
            new PathParser("test? a = 1")
        then:
            thrown(IncorrectFormatException)
    }

    def "parse with unused comma"(){
        when:
            new PathParser("test?a=1,")
        then:
            thrown(IncorrectFormatException)
    }

    def "parse with too many ?"(){
        when:
            new PathParser("test?a=1?")
        then:
            thrown(IncorrectFormatException)
    }
}
