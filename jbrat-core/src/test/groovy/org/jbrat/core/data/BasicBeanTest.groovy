package org.jbrat.core.data

import spock.lang.Specification

class BasicBeanTest extends Specification {

    def "bind test"(){
        given:
            def bean = new BasicBean()
            def var1 = 0
        when:
            bean.bind "test", { value->
                var1 = value
            }
        and:
            bean.test = 1
        then:
            var1 == 1
    }

    def "unbind test"(){
        given:
            def bean = new BasicBean()
        when:
            bean.unbind("test",null)
        then:
            notThrown(Exception)
    }

    def "bind/unbind test1"(){
        given:
            def bean = new BasicBean()
            def var1 = 0
            def event = { value->
                var1 = value
            }
        when:
            bean.bind("test", event)
        and:
            bean.unbind("test",event)
        and:
            bean.test = 1
        then:
            var1 == 0
    }

    def "bind/unbind test2"(){
        given:
            def bean = new BasicBean()
            def var1 = 0
            def event = { value->
                var1 = value
            }
        when:
            bean.bind("test", event)
        and:
            bean.unbind("test",event)
        and:
            bean.bind("test", event)
        and:
            bean.test = 1
        then:
            var1 == 1
    }

}
