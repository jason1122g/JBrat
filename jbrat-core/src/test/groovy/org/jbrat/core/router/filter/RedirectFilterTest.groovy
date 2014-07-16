package org.jbrat.core.router.filter

import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.abstracts.Bean
import org.jbrat.core.router.abstracts.RouterFilter
import org.jbrat.core.router.data.RouteData
import spock.lang.Shared
import spock.lang.Specification


class RedirectFilterTest extends Specification {

    private class testFilter extends RouterFilter{
        @Override
        protected void filt(RouteData routeData) {
            Bean bean =  new BeanBuilder().setLocale(routeData.getPath()).build()
            routeData.setBean(bean)
        }
    }

    @Shared RedirectFilter redirectRouter

    def setupSpec(){
        def bean = new BeanBuilder().build()
        def beanContainer = new BeanContainer(bean)
        redirectRouter    = new RedirectFilter(beanContainer);
        redirectRouter >> new testFilter()
    }

    def "route based on routes.properties"(){
        when:
            def result = redirectRouter.route("customRoute")
        then:
            result.config.locale == "incorrect"
    }


}
