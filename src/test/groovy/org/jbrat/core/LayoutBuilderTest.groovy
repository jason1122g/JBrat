package org.jbrat.core

import org.jbrat.core.data.Layout
import spock.lang.Specification

class LayoutBuilderTest extends Specification {

    def "build with full layout"(){
        given:
            def base = Layout.Builder.getResourceBase()
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
            def log        = "${base}/log"
        when:
            def layout = new Layout.Builder()
                    .setControllerPosition(controller)
                    .setModelPosition(model)
                    .setViewPosition(view)
                    .setHandlerPosition(handler)
                    .setHelperPosition(helper)
                    .setRoutesPosition(routes)
                    .setLocalesPosition(locales)
                    .setLibPosition(lib)
                    .setVenderPosition(vender)
                    .setLogPosition(log)
                    .build()
        then:
            layout.getControllerPosition() == controller
            layout.getModelPosition()      == model
            layout.getViewPosition()       == view
            layout.getHandlerPosition()    == handler
            layout.getHelperPosition()     == helper
            layout.getRoutesPosition()     == routes
            layout.getLocalesPosition()    == locales
            layout.getLibPosition()        == lib
            layout.getVenderPosition()     == vender
            layout.getLogPosition()        == log
    }


    def "build with default layout"(){
        given:
            def layout = new Layout.Builder().build()
        and:
            def base = Layout.Builder.getResourceBase()
        expect:
            layout.getControllerPosition() == "app.controller"
            layout.getModelPosition()      == "app.model"
            layout.getViewPosition()       == "app.view"
            layout.getHandlerPosition()    == "app.handler"
            layout.getHelperPosition()     == "app.helper"
            layout.getRoutesPosition()     == "${base}/config"
            layout.getLocalesPosition()    == "${base}/config/locales"
            layout.getLibPosition()        == "${base}/lib"
            layout.getVenderPosition()     == "${base}/vender"
            layout.getLogPosition()        == "${base}/log"
    }

    def "application.properties position cannot be changed"(){
        given:
            def layout = new Layout.Builder().build()
        and:
            def base = Layout.Builder.getResourceBase()
        expect:
            layout.getApplicationSettingPosition() == "${base}/config"
    }
}
