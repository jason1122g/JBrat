package org.jbrat.core

import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.router.filter.ControllerFilter
import org.jbrat.core.router.ControllerRouter
import org.jbrat.core.router.ViewRouter
import org.jbrat.core.localer.BasicLocaler


class JBrat {

    private static def bean = new BeanBuilder().build() //need to read application.properties
    private static def beanContainer = new BeanContainer(bean)

    private static def localer       = new BasicLocaler    (beanContainer)
    private static def viewRouter    = new ViewRouter      (beanContainer)
    private static def controlRouter = new ControllerRouter(beanContainer)

    private static def router = controlRouter >> new ControllerFilter() >> viewRouter

    static{
        //read application.properties to set all config ready
        //use default layout for the position which is not setted
    }

    static void route(path){
        router.route(path)
    }

    static void start(){
        route("root")
    }

    static void render(name,bean){
        viewRouter.route(name,bean)
    }

    static def localeText(name){
        return localer.localeText(name)
    }
}
