package org.jbrat.core.tool

import org.jbrat.core.data.Layout
import spock.lang.Specification

class AppConfigReaderTest extends Specification {

    def "test configurator"(){
        given:
            def configLocation= Layout.getConfigLocation() + "/application.properties"
            def prop          = new PropertiesBuilder().fromFilePath(configLocation).build()
            def configurator  = new AppConfigReader()

        when:
            def beanContainer = configurator.asBeanContainer()
        then:
            beanContainer.getLocale() == prop."locale"
            beanContainer.getLayout().getControllerLocation() == convert(prop."layout.controllerLocation")
            beanContainer.getLayout().getModelLocation()      == convert(prop."layout.modelLocation")
            beanContainer.getLayout().getViewLocation()       == convert(prop."layout.viewLocation")
            beanContainer.getLayout().getHandlerLocation()    == convert(prop."layout.handlerLocation")
            beanContainer.getLayout().getHelperLocation()     == convert(prop."layout.helperLocation")
            beanContainer.getLayout().getRoutesLocation()     == convert(prop."layout.routesLocation")
            beanContainer.getLayout().getLocalesLocation()    == convert(prop."layout.localesLocation")
            beanContainer.getLayout().getLogLocation()        == convert(prop."layout.logLocation")
    }

    private static def convert(path){
        def resourceBase  = Layout.getResourceBase()
        if(path.contains("\${resource}")){
            path = resourceBase + path.replace("\${resource}","")
        }
        return path
    }

}
