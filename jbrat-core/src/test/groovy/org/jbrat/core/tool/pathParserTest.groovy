package org.jbrat.core.tool

import org.jbrat.core.data.Address
import org.jbrat.exceptions.IncorrectFormatError
import spock.lang.Specification


class pathParserTest extends Specification {

    def "parse without params"(){
        when:
            def parser = new Address("helloworld")
        then:
            parser.getPath()   == "helloworld"
    }

    def "parse format of path is [-. a-zA-Z0-9_]"(){
        when:
            def parser = new Address("a.1_aA 3")
        then:
            parser.getPath()   == "a.1_aA 3"
    }

    def "parse with 1 param"(){
        when:
            def parser = new Address("test?a=1")
        then:
            parser.getPath()     == "test"
            parser.getParams().a == "1"
    }

    def "parse with 2 params"(){
        when:
            def parser = new Address("test?var1=var1,var2=var2")
        then:
            parser.getPath()     == "test"
            parser.getParams().var1 == "var1"
            parser.getParams().var2 == "var2"
    }

    def "parse format of param is  [a-zA-Z0-9_]"(){
        when:
            def parser = new Address("test?aA0=123,_var=tt")
        then:
            parser.getParams().aA0  == "123"
            parser.getParams()._var == "tt"
    }

    def "parse with spaces in param"(){
        when:
            new Address("test? a = 1")
        then:
            thrown(IncorrectFormatError)
    }

    def "parse with unused comma"(){
        when:
            new Address("test?a=1,")
        then:
            thrown(IncorrectFormatError)
    }

    def "parse with too many ?"(){
        when:
            new Address("test?a=1?")
        then:
            thrown(IncorrectFormatError)
    }
}
