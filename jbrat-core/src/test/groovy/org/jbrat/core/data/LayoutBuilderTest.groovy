package org.jbrat.core.data

import spock.lang.Specification

class LayoutBuilderTest extends Specification {

    def "default build"(){
        given:
            def layout = new Layout.Builder().build()
        and:
            def base = Layout.getResourceBase()
        expect:
            layout.getControllerLocation() == "app.controller"
            layout.getModelLocation()      == "app.model"
            layout.getViewLocation()       == "app.view"
            layout.getHandlerLocation()    == "app.handler"
            layout.getHelperLocation()     == "app.helper"
            layout.getRoutesLocation()     == "${base}/config"
            layout.getLocalesLocation()    == "${base}/config/locales"
            layout.getLibLocation()        == "${base}/lib"
            layout.getVenderLocation()     == "${base}/vender"
            layout.getLogLocation()        == "logs"
    }

    def "some values are static"(){
        expect:
            Layout.getResourceBase()   == "/jbrat"
            Layout.getSourceLocation() == "src/main/groovy"
            Layout.getConfigLocation() == "${Layout.resourceBase}/config"
    }

    def "build with full layout"(){
        given:
            def base = Layout.getResourceBase()
        and:
            def controller = "controller"
            def model      = "model"
            def view       = "hello.view"
            def handler    = "custom.handler"
            def helper     = "apps.helper"
            def routes     = "${base}/routes"
            def locales    = "${base}/locales"
            def lib        = "${base}/lib"
            def vender     = "${base}/lib"
            def log        = "logss"
        when:
            def layout = new Layout.Builder()
                    .setControllerLocation(controller)
                    .setModelLocation(model)
                    .setViewLocation(view)
                    .setHandlerLocation(handler)
                    .setHelperLocation(helper)
                    .setRoutesLocation(routes)
                    .setLocalesLocation(locales)
                    .setLibLocation(lib)
                    .setVenderLocation(vender)
                    .setLogLocation(log)
                    .build()
        then:
            layout.getControllerLocation() == controller
            layout.getModelLocation()      == model
            layout.getViewLocation()       == view
            layout.getHandlerLocation()    == handler
            layout.getHelperLocation()     == helper
            layout.getRoutesLocation()     == routes
            layout.getLocalesLocation()    == locales
            layout.getLibLocation()        == lib
            layout.getVenderLocation()     == vender
            layout.getLogLocation()        == log
    }

}
