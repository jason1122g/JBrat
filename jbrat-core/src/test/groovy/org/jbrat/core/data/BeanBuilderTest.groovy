package org.jbrat.core.data

import spock.lang.Specification


class BeanBuilderTest extends Specification {

    def "default build"(){
        given:
            def bean = new BeanBuilder().build()
            def container = new BeanContainer(bean)
        and:
            def layout = container.getLayout()
            def defaultLayout = new Layout.Builder().build()
        expect:
            container.getConfig() != null
            container.getLocale() == "enUS"
        and:
            layout.getControllerLocation() == defaultLayout.getControllerLocation()
            layout.getModelLocation()      == defaultLayout.getModelLocation()
            layout.getViewLocation()       == defaultLayout.getViewLocation()
            layout.getHandlerLocation()    == defaultLayout.getHandlerLocation()
            layout.getHelperLocation()     == defaultLayout.getHelperLocation()
            layout.getRoutesLocation()     == defaultLayout.getRoutesLocation()
            layout.getLocalesLocation()    == defaultLayout.getLocalesLocation()
            layout.getLibLocation()        == defaultLayout.getLibLocation()
            layout.getVenderLocation()     == defaultLayout.getVenderLocation()
            layout.getLogLocation()        == defaultLayout.getLogLocation()

    }

    def "set some properties"(){
        given:
            def layout = new Layout.Builder().setLibLocation("libbb").build()
            def bean   = new BeanBuilder()
                      .setLocale("zhTW")
                      .setLayout(layout)
                      .build()
            def container = new BeanContainer(bean)
        expect:
            container.getLocale() == "zhTW"
            container.getLayout().getLibLocation() == "libbb"

    }
}
