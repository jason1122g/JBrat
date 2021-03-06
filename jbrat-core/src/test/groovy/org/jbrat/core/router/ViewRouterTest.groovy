package org.jbrat.core.router

import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.BeanFactory
import org.jbrat.exceptions.IncorrectFormatError
import org.jbrat.exceptions.RouteFailedError
import spock.lang.Shared
import spock.lang.Specification

class ViewRouterTest extends Specification {

    @Shared def testBean = BeanFactory.createEmpty()
    @Shared ViewRouter viewRouter

    def setupSpec(){
        def bean = new BeanBuilder().build()
        def beanContainer = new BeanContainer(bean)
        viewRouter = new ViewRouter(beanContainer)
    }

    def "init a view with no locale name"(){
        given:
            def resultBean
        when:
            resultBean = viewRouter.route("other.runTask1")
        then:
            resultBean.className == "runTask1View"

    }

    def "init a view correspond to current locale"(){
        given:
            def resultBean
        when:
            resultBean = viewRouter.route("other.runTask2")
        then:
            resultBean.className == "runTask2View_enUS"
    }

    def "all initiated views have one singleton data container"(){
        given:
            def var1=1
            def var2=2
        when:
            testBean.test = { bean->
                bean.component.msg = var1
            }
            viewRouter.route("other.runTask1", testBean)
        and:
            testBean.test = { bean->
                var2 = bean.component.msg
            }
            viewRouter.route("other.runTask2", testBean)
        then:
            var1 == var2
    }

    def "init a view which is not exist will throw Exception"(){
        when:
            viewRouter.route("viewNotExist")
        then:
            thrown(RouteFailedError)
    }

    def "init a wrong implemented view will throw Exception"(){
        when:
            viewRouter.route("incorrect")
        then:
            thrown(IncorrectFormatError)
    }
}
