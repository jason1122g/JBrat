package org.jbrat.core.data

import org.jbrat.exceptions.IncorrectFormatError
import spock.lang.Specification

class AddressTest extends Specification {

    def "parse without params"(){
        when:
            def address = new Address("helloworld")
        then:
            address.getPath()   == "helloworld"
    }

    def "parse format of path is [-. a-zA-Z0-9_]"(){
        when:
            def address = new Address("a.1_aA 3")
        then:
            address.getPath()   == "a.1_aA 3"
    }

    def "parse with 1 param"(){
        when:
            def address = new Address("test?a=1")
        then:
            address.getPath()     == "test"
            address.getParams().a == "1"
    }

    def "parse with 2 params"(){
        when:
            def address = new Address("test?var1=var1,var2=var2")
        then:
            address.getPath()     == "test"
            address.getParams().var1 == "var1"
            address.getParams().var2 == "var2"
    }

    def "parse format of param is  [a-zA-Z0-9_]"(){
        when:
            def address = new Address("test?aA0=123,_var=tt")
        then:
            address.getParams().aA0  == "123"
            address.getParams()._var == "tt"
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
