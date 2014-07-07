package org.jbrat.core.initor

import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException
import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Title

@Title("target controller will invoke the method in bean.test")
class ControllerInitorTest extends Specification {

    @Shared def configBean = [layout:[controllerPosition:"app.controller"]]
    @Shared def controllerInitor = new ControllerInitor(configBean);

    @IgnoreRest //TODO FINISH THIS
    def "skip all"(){
        expect:
            true
    }

    def "init a controller"(){
        given:
            def var1=1,var2=2
        and:
            def testMethod = {
                var1 = var2
            }
        when:
            controllerInitor.init("runTask1", testMethod)
        then:
            var1 == var2

    }

    def "all initiated controllers have same ref of config"(){
        given:
            def var1=1,var2=2
        and:
            def testMethod1 = { bean->
                var1 = bean.config
            }
            def testMethod2 = { bean->
                var2 = bean.config
            }
        when:
            controllerInitor.init("runTask1", testMethod1)
            controllerInitor.init("runTask2", testMethod2)
        then:
            var1 == var2

    }

    def "all initiated controllers have one singleton data container"(){
        given:
            def var1=1,var2=2
        and:
            def testMethod1 = { bean->
                bean.component.msg = var1
            }
            def testMethod2 = { bean->
                var2 = bean.component.msg
            }
        when:
            controllerInitor.init("runTask1", testMethod1)
            controllerInitor.init("runTask2", testMethod2)
        then:
            var1 == var2
    }

    def "init a controller which is not exist will throw Exception"(){
        when:
            controllerInitor.init("controllerNotExist")
        then:
            thrown(RouteFailedException)
    }

    def "init a wrong implemented controller will throw Exception"(){
        when:
            controllerInitor.init("incorrect")
        then:
            thrown(IncorrectFormatException)
    }
}
