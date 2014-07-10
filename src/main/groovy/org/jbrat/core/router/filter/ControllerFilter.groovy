package org.jbrat.core.router.filter

import org.jbrat.core.data.BeanContainer
import org.jbrat.core.router.abstracts.RouterFilter
import org.jbrat.core.router.data.RouteData

class ControllerFilter extends RouterFilter{
    @Override
    protected void filt(RouteData routeData) {
        def bean = routeData.getBean()
        BeanContainer container = new BeanContainer(bean)
        container.setConfig(null)
        container.setComponent(null)
        container.setParam(null)
    }
}
