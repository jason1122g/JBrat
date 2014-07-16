package org.jbrat.core.router

import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.BeanFactory
import org.jbrat.exceptions.IncorrectFormatError
import org.jbrat.exceptions.RouteFailedError
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Title

@Title("target controller will invoke the method in bean.test")
class ControllerRouterTest extends Specification {

    @Shared ControllerRouter controllerRouter
    @Shared def testBean = BeanFactory.createEmpty()

    def setupSpec(){
        def bean = new BeanBuilder().build()
        def beanContainer = new BeanContainer(bean)
        controllerRouter  = new ControllerRouter(beanContainer);
    }

    def "init a controller"(){
        given:
            def resultBean
        when:
            resultBean = controllerRouter.route("other.runTask1")
        then:
            resultBean.className == "runTask1Controller"

    }

    def "arg2 of route will be the bean passed to router"(){
        given:
            def var = 0
        and:
            testBean.test = { bean->
                var = bean.test
            }
        when:
            controllerRouter.route("other.runTask1", testBean)
        then:
            var == testBean.test

    }

    def "init a controller with params"(){
        given:
            def var1 =""
            def var2 =""
        and:
            testBean.test = { bean->
                var1 = bean.param.var1
                var2 = bean.param.var2
            }
        when:
            controllerRouter.route("other.runTask1?var1=1,var2=2", testBean)
        then:
            var1 == "1"
            var2 == "2"

    }

    def "all initiated controllers have same ref of config"(){
        given:
            def list = []
        and:
            testBean.test = { bean->
                list << bean.config
            }
        when:
            controllerRouter.route("other.runTask1", testBean)
            controllerRouter.route("other.runTask2", testBean)
        then:
           list[0] == list[1]

    }

    def "all initiated controllers have one singleton data container"(){
        given:
            def var1 = 1
            def var2 = 2
        when:
            testBean.test = { bean->
                bean.component.msg = var1
            }
            controllerRouter.route("other.runTask1", testBean)
        and:
            testBean.test = { bean->
                var2 = bean.component.msg
            }
            controllerRouter.route("other.runTask2", testBean)
        then:
            var1 == var2
    }

    def "init a controller which is not exist will throw Exception"(){
        when:
            controllerRouter.route("controllerNotExist")
        then:
            thrown(RouteFailedError)
    }

    def "init a wrong implemented controller will throw Exception"(){
        when:
            controllerRouter.route("incorrect")
        then:
            thrown(IncorrectFormatError)
    }

}
