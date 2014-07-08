package org.jbrat.core.initor

import org.jbrat.core.router.ControllerRouter
import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Title
import tools.ExpandableBean

@Title("target controller will invoke the method in bean.test")
class ControllerRouterTest extends Specification {

    @Shared def configBean
    @Shared def controllerInitor

    def setupSpec(){
        configBean = new ExpandableBean();
        configBean.layout = new ExpandableBean()
        configBean.layout.controllerPosition = "app.controller"
        controllerInitor = new ControllerRouter(configBean);
    }

    def "init a controller"(){
        given:
            def resultBean
        when:
            resultBean = controllerInitor.route("other.runTask1Controller")
        then:
            resultBean.className == "runTask1Controller"

    }

    def "arg2 of direct will be in bean.test"(){
        given:
            def var = 0
        and:
            def hookMethod = { bean->
                var = bean.test
            }
        when:
            controllerInitor.route("other.runTask1Controller", hookMethod)
        then:
            var == hookMethod

    }

    def "init a controller with params"(){
        given:
            def var1 =""
            def var2 =""
        and:
            def hookMethod = { bean->
                var1 = bean.params.var1
                var2 = bean.params.var2
            }
        when:
            controllerInitor.route("other.runTask1Controller?var1=1,var2=2", hookMethod)
        then:
            var1 == "1"
            var2 == "2"

    }

    def "all initiated controllers have same ref of config"(){
        given:
            def var1=1
            def var2=2
        and:
            def hookMethod1 = { bean->
                var1 = bean.config
            }
            def hookMethod2 = { bean->
                var2 = bean.config
            }
        when:
            controllerInitor.route("other.runTask1Controller", hookMethod1)
            controllerInitor.route("other.runTask2Controller", hookMethod2)
        then:
            var1 == var2

    }

    def "all initiated controllers have one singleton data container"(){
        given:
            def var1=1
            def var2=2
        and:
            def hookMethod1 = { bean->
                bean.component.msg = var1
            }
            def hookMethod2 = { bean->
                var2 = bean.component.msg
            }
        when:
            controllerInitor.route("other.runTask1Controller", hookMethod1)
            controllerInitor.route("other.runTask2Controller", hookMethod2)
        then:
            var1 == var2
    }

    def "init a controller which is not exist will throw Exception"(){
        when:
            controllerInitor.route("controllerNotExist")
        then:
            thrown(RouteFailedException)
    }

    def "init a wrong implemented controller will throw Exception"(){
        when:
            controllerInitor.route("incorrectController")
        then:
            thrown(IncorrectFormatException)
    }
}
