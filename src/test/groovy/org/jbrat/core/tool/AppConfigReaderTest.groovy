package org.jbrat.core.tool

import org.jbrat.core.data.Layout
import spock.lang.Specification

class AppConfigReaderTest extends Specification {
    def "test configurator"(){
        given:
            def configurator  = new AppConfigReader()
            def resourceBase  = Layout.Builder.getResourceBase()
        when:
            def beanContainer = configurator.asBeanContainer()
        then:
            beanContainer.getLocale() == "zhTW"
            beanContainer.getLayout().getControllerLocation() == "app.controller.inner"
            beanContainer.getLayout().getModelLocation()      == "app.model.inner"
            beanContainer.getLayout().getViewLocation()       == "app.view.inner"
            beanContainer.getLayout().getHandlerLocation()    == "app.handler.inner"
            beanContainer.getLayout().getHelperLocation()     == "app.helper.inner"
            beanContainer.getLayout().getRoutesLocation()     == "$resourceBase/config/inner"
            beanContainer.getLayout().getLocalesLocation()    == "$resourceBase/config/locales/inner"
            beanContainer.getLayout().getLogLocation()        == "$resourceBase/log/inner"
    }

}
