package org.jbrat.core.router

import org.jbrat.core.data.Layout
import org.jbrat.core.data.container.BeanContainer
import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException
import spock.lang.Shared
import spock.lang.Specification
import tools.ExpandableBean


class ViewRouterTest extends Specification {

    @Shared def testBean = new ExpandableBean()
    @Shared def viewRouter

    def setupSpec(){
        def configBean = new ExpandableBean();
        configBean.layout = new  Layout.Builder().setViewPosition("app.view").build()
        configBean.locale = "enUS"

        def bean = new ExpandableBean()
        bean.config = configBean
        viewRouter = new ViewRouter(new BeanContainer(bean));
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
            thrown(RouteFailedException)
    }

    def "init a wrong implemented view will throw Exception"(){
        when:
            viewRouter.route("incorrect")
        then:
            thrown(IncorrectFormatException)
    }
}
