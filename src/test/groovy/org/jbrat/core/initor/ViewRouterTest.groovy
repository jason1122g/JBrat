package org.jbrat.core.initor

import org.jbrat.core.router.ViewRouter
import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException
import spock.lang.Shared
import spock.lang.Specification
import tools.ExpandableBean


class ViewRouterTest extends Specification {

    @Shared def configBean
    @Shared def viewInitor

    def setupSpec(){
        configBean = new ExpandableBean();
        configBean.layout = new ExpandableBean()
        configBean.layout.viewPosition = "app.view"
        configBean.locale = "enUS"
        viewInitor = new ViewRouter(configBean);
    }

    def "init a view with no locale name"(){
        given:
            def resultBean
        when:
            resultBean = viewInitor.route("other.runTask1View")
        then:
            resultBean.className == "runTask1View"

    }

    def "init a view correspond to current locale"(){
        given:
            def resultBean
        when:
            resultBean = viewInitor.route("other.runTask2View")
        then:
            resultBean.className == "runTask2View_enUS"
    }

    def "all initiated views have one singleton data container"(){
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
            viewInitor.route("other.runTask2View_enUS", hookMethod1)
            viewInitor.route("other.runTask2View_zhTW", hookMethod2)
        then:
            var1 == var2
    }

    def "init a view which is not exist will throw Exception"(){
        when:
            viewInitor.route("viewNotExist")
        then:
            thrown(RouteFailedException)
    }

    def "init a wrong implemented view will throw Exception"(){
        when:
            viewInitor.route("incorrectView")
        then:
            thrown(IncorrectFormatException)
    }
}
