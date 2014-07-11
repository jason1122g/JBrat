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
            beanContainer.getLayout().getControllerPosition() == "app.controller.inner"
            beanContainer.getLayout().getModelPosition()      == "app.model.inner"
            beanContainer.getLayout().getViewPosition()       == "app.view.inner"
            beanContainer.getLayout().getHandlerPosition()    == "app.handler.inner"
            beanContainer.getLayout().getHelperPosition()     == "app.helper.inner"
            beanContainer.getLayout().getRoutesPosition()     == "$resourceBase/config/inner"
            beanContainer.getLayout().getLocalesPosition()    == "$resourceBase/config/locales/inner"
            beanContainer.getLayout().getLogPosition()        == "$resourceBase/log/inner"
    }

}
