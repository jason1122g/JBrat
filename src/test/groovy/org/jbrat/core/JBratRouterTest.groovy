package org.jbrat.core

import app.controller.routeTestController
import app.controller.routeTest2Controller
import app.view.routeTest2View
import app.view.routeTestView
import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException
import spock.lang.IgnoreRest
import spock.lang.Specification
import tools.ClassChecker

class JBratRouterTest extends Specification {

    def controller  = GroovyMock(routeTestController)
    def controller2 = GroovyMock(routeTest2Controller)
    def view        = GroovyMock(routeTestView)
    def view2       = GroovyMock(routeTest2View)//need global true

    private static void route(path){
        JBrat.route(path)
    }

    @IgnoreRest
    def "skip all"(){
        expect:
            true
    }

    def "route in common way with same head"(){
        when:
            route("routeTest")
        then:
            1 * controller.prepare(_)
        then:
            1 * view.render(_)
    }

    def "route to deep package level"(){
        when:
            route("other.deepLevel")
        then:
            ClassChecker.classIsLoaded("app.controller.other.deepLevelController")
            ClassChecker.classIsLoaded("app.view.other.deepLevelView")
    }

    def "route by custom route rule"(){
        when:
            route("customRoute")

        then: "customRoute path will lead to incorrectController"

            thrown(RouteFailedException)
    }

    def "route to controller with param"(){
        given:
            def var1 = new Random().nextInt()
            def var2 = new Random().nextInt()
            def varA = 0, varB = 0
        and:
            controller.prepare(_) >> { bean ->
                varA = bean.params.var1
                varB = bean.params.var2
            }
        when:
            route("routeTest? var1=$var1, var2=$var2")
        then:
            varA == var1
            varB == var2
    }

    def "route to class without implement of view or controller"(){
        when :
            route("incorrect")
        then:
            thrown(IncorrectFormatException)
    }

    def "route to wrong path"(){
        when:
            route("No Such Path")
        then:
            thrown(RouteFailedException)
    }

    def "route to view in correct init order"(){
        given:
            def list = []
        and:
            view.enter()        >> { list << "enter" }
            view.beforeRender() >> { list << "beforeRender" }
            view.render(_)      >> { list << "render" }
            view.afterRender()  >> { list << "afterRender" }
            view.exit()         >> { list << "exit" }
        when:
            route("routeTest")
        then:
            list == ["enter","beforeRender","render","afterRender"];
        when:
            route("other.deepLevel")
        then:
            list == ["enter","beforeRender","render","afterRender","exit"];
    }

    def "any routed controller has same reference of jbrat.config setting"(){
        given:
            def config1 = 1, config2 = 2
        and:
            controller2.prepare(_) >> { bean->
                config2 = bean.config
            }
        and:
            controller.prepare(_) >> { bean->
                config1 = bean.config
            }
        when:
            route("routeTest")
            route("routeTest2")
        then:
            config1 == config2
    }

    def "route to  view correspond to default locale setting"(){
        when:
            route("localeTest")
        then:
            ClassChecker.classIsLoaded("app.view.localeTestView_enUS")
    }

    def "route to view by changing locale dynamically"(){
        given:
            controller.prepare(_) >> { bean->
                bean.config.locale = "zh-TW"
            }
        when:
            route("localeTest")
        then:
            ClassChecker.classIsLoaded("app.view.localeTestView_zhTW")
    }

    def "bean in controller will be passed to view"(){
        given:
            def var1 = new Random().nextInt(), var2 = 0
        and:
            controller.prepare(_) >> { bean->
                bean.msg = var1
            }
        and:
            view.render(_) >> { bean->
                var2 = bean.msg
            }
        when:
            route("routeTest")
        then:
            var1 == var2
    }

    def "all routed controllers have a singleton data container"(){
        given:
            def var1 = new Random().nextInt(), var2 = 0
        and:
            controller.prepare(_) >> { bean->
                bean.component.msg = var1
            }
        and:
            controller2.prepare(_) >> { bean->
                var2 = bean.component.msg
            }
        when:
            route("routeTest")
            route("routeTest2")
        then:
            var1 == var2
    }

    def "all routed views have a singleton data container"(){
        given:
            def var1 = new Random().nextInt(), var2 = 0
        and:
            view.render(_) >> { bean->
                bean.component.msg = var1
            }
        and:
            view2.render(_) >> { bean->
                var2 = bean.component.msg
            }
        when:
            route("routeTest")
            route("routeTest2")
        then:
            var1 == var2
    }

}
