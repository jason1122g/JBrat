package org.jbrat.core.router.filter

import groovy.transform.CompileStatic
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.abstracts.Bindable
import org.jbrat.core.router.abstracts.RouterFilter
import org.jbrat.core.router.data.RouteData

@CompileStatic
class ControllerFilter extends RouterFilter{
    @Override
    protected void filt(RouteData routeData) {
        Bindable bean = routeData.getBean()
        if(bean != null){
            BeanContainer container = new BeanContainer(bean)
            container.setConfig(null)
            container.setComponent(null)
            container.setParam(null)
        }
    }
}
