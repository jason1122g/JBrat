package org.jbrat.core.router

import groovy.transform.CompileStatic
import org.jbrat.controllers.Controller
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.BeanFactory
import org.jbrat.core.data.abstracts.Bindable
import org.jbrat.core.router.abstracts.ReflectRouterFilter
import org.jbrat.core.tool.PathContainer

@CompileStatic
class ControllerRouter extends ReflectRouterFilter{

    private Bindable configBean
    private Bindable paramsBean
    private Bindable componentBean
    private BeanContainer beanContainer

    def ControllerRouter(BeanContainer beanContainer){
        this.beanContainer = beanContainer
        this.componentBean = BeanFactory.createEmpty()
    }

    @Override
    protected String buildPath(String uri){
        PathContainer parser = new PathContainer(uri)
        String     path   = parser.getPath()
        paramsBean        = parser.getParams()
        beanContainer.getLayout().getControllerLocation() + "." + path + "Controller"
    }

    @Override
    protected Bindable buildBean(Bindable bean){
        BeanContainer beanContainer = new BeanContainer(bean)
        beanContainer.setConfig(configBean)
        beanContainer.setComponent(componentBean)
        beanContainer.setParam(paramsBean)
        return bean
    }

    @Override
    protected void buildInstanceCall(Object instance, Bindable bean){
        Controller controller = (Controller) instance
        controller.prepare( bean )
    }

}
