package org.jbrat.core.router

import org.jbrat.core.data.BeanFactory
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.router.abstracts.JBratRouter
import org.jbrat.core.tool.routePathParser


class ControllerRouter extends JBratRouter{

    private def configBean
    private def paramsBean
    private def componentBean
    private BeanContainer beanContainer

    def ControllerRouter(beanContainer){
        this.beanContainer = beanContainer
        this.componentBean = BeanFactory.createEmpty()
    }

    @Override
    protected def buildPath(uri){
        def parser = new routePathParser(uri)
        def path   = parser.getPath()
        paramsBean = parser.getParams()
        beanContainer.getLayout().controllerPosition + "." + path + "Controller"
    }

    @Override
    protected def buildBean(bean){
        if(bean == null){
            bean = BeanFactory.createEmpty()
        }

        BeanContainer beanContainer = new BeanContainer(bean)
        beanContainer.setConfig(configBean)
        beanContainer.setComponent(componentBean)
        beanContainer.setParam(paramsBean)

        return bean
    }

    @Override
    protected def buildInstanceCall(instance,bean){
        instance.prepare( bean )
    }

}
