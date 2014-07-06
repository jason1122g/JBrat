package org.jbrat.core

import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Title
import tools.ClassChecker

@Title("Router will read routes.properties in /config to route File")
class JBratRouterTest extends Specification {

    static def map1  = [:]
    static def list1 = []

    @Shared def router =  JBratRouter.getInstance()

    def "route in common way (with same head)"(){
        when:
            router.route("routeTest")
        then:
            ClassChecker.classIsLoaded("app.controller.routeTestController")
            ClassChecker.classIsLoaded("app.view.routeTestView")
    }

    def "route to deep package level"(){
        when:
            router.route("other.deepLevel")
        then:
            ClassChecker.classIsLoaded("app.controller.other.routeTestController")
            ClassChecker.classIsLoaded("app.view.other.routeTestView")
    }

    def "route to controller with param which can be accessed by bean.params"(){
        given:
            def var1 = new Random().nextInt()
            def var2 = new Random().nextInt()
        when:
            router.route("routeTest? var1=$var1, var2=$var2")

        then: "routeTestController should get params and set them to map1"

            map1["var1"] == var1
            map1["var2"] == var2
    }

    def "route to class without implement of view or controller"(){
        when :
            router.route("incorrect")
        then:
            thrown(IncorrectFormatException)
    }

    def "route to wrong path"(){
        when:
            router.route("No Such Path")
        then:
            thrown(RouteFailedException)
    }

    def "route to view in correct init order"(){
        when:
            router.route("orderTest")

        then: "orderTestView should add elements to list1 by invoke order"

            list1 == ["enter","beforeRender","render","afterRender"];

        then: "after route to other path"

            router.route("routeTest")

        then: "exit() will be called"

            list1 == ["enter","beforeRender","render","afterRender","exit"];
    }

    def "route by custom route rule in /config/routes.properties"(){
        when:
            router.route("customRoute")

        then: "customRoute may lead to incorrectController"

            thrown(RouteFailedException)
    }

}
