package org.jbrat.core.router

import groovy.transform.CompileStatic
import org.jbrat.controllers.Controller
import org.jbrat.core.data.Bean
import org.jbrat.core.data.BeanFactory
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.router.abstracts.ReflectRouterFilter
import org.jbrat.core.tool.PathContainer

@CompileStatic
class ControllerRouter extends ReflectRouterFilter{

    private Bean configBean
    private Bean paramsBean
    private Bean componentBean
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
        beanContainer.getLayout().getControllerPosition() + "." + path + "Controller"
    }

    @Override
    protected Bean buildBean(Bean bean){
        BeanContainer beanContainer = new BeanContainer(bean)
        beanContainer.setConfig(configBean)
        beanContainer.setComponent(componentBean)
        beanContainer.setParam(paramsBean)
        return bean
    }

    @Override
    protected void buildInstanceCall(Object instance, Bean bean){
        Controller controller = (Controller) instance
        controller.prepare( bean )
    }

}
