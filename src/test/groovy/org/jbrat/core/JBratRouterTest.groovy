package org.jbrat.core

import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException
import spock.lang.IgnoreRest
import spock.lang.Specification

class JBratRouterTest extends Specification {


    private static void route(path){
        JBrat.route(path)
    }

    @IgnoreRest //TODO FINISH THIS
    def "skip all"(){
        expect:
            true
    }

    def "route in common way with same head"(){

    }

    def "route to deep package level"(){

    }

    def "route by custom route rule"(){
        when:
            route("customRoute")

        then: "customRoute path will lead to incorrectController"

            thrown(RouteFailedException)
    }

    def "route to controller with param"(){

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

    }

    def "any routed controller has same reference of jbrat.config setting"(){

    }

    def "route to  view correspond to default locale setting"(){

    }

    def "route to view by changing locale dynamically"(){

    }

    def "bean in controller will be passed to view"(){

    }

    def "all routed controllers have a singleton data container"(){

    }

    def "all routed views have a singleton data container"(){

    }

}
