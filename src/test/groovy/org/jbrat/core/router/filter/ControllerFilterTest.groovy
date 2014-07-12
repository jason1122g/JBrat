package org.jbrat.core.router.filter

import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.abstracts.Bindable
import spock.lang.Shared
import spock.lang.Specification

class ControllerFilterTest extends Specification {

    @Shared ControllerFilter controllerFilter
    @Shared Bindable bean

    def setupSpec(){
        bean  = new BeanBuilder().build()
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
