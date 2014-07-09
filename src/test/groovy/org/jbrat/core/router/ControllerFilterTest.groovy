package org.jbrat.core.router

import org.jbrat.core.router.filter.ControllerFilter
import spock.lang.Shared
import spock.lang.Specification
import tools.ExpandableBean


class ControllerFilterTest extends Specification {

    @Shared def controllerFilter
    @Shared def bean

    def setupSpec(){
        bean  = new ExpandableBean()
        controllerFilter = new ControllerFilter()
    }

    def "clear config,component,params in the bean"(){
        given:
            bean.config    = 1
            bean.component = 2
            bean.param     = 3
            bean.other     = 4
        when:
            controllerFilter.route("any thing else",bean)
        then:
            bean.config    == null
            bean.component == null
            bean.param     == null
            bean.other     == 4
    }
}
