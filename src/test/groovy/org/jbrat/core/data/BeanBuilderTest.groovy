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
            layout.getControllerPosition() == defaultLayout.getControllerPosition()
            layout.getModelPosition()      == defaultLayout.getModelPosition()
            layout.getViewPosition()       == defaultLayout.getViewPosition()
            layout.getHandlerPosition()    == defaultLayout.getHandlerPosition()
            layout.getHelperPosition()     == defaultLayout.getHelperPosition()
            layout.getRoutesPosition()     == defaultLayout.getRoutesPosition()
            layout.getLocalesPosition()    == defaultLayout.getLocalesPosition()
            layout.getLibPosition()        == defaultLayout.getLibPosition()
            layout.getVenderPosition()     == defaultLayout.getVenderPosition()
            layout.getLogPosition()        == defaultLayout.getLogPosition()

    }

    def "set some properties"(){
        given:
            def layout = new Layout.Builder().setLibPosition("libbb").build()
            def bean   = new BeanBuilder()
                      .setLocale("zhTW")
                      .setLayout(layout)
                      .build()
            def container = new BeanContainer(bean)
        expect:
            container.getLocale() == "zhTW"
            container.getLayout().getLibPosition() == "libbb"

    }
}
