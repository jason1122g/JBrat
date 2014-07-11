package org.jbrat.core

import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.router.filter.ControllerFilter
import org.jbrat.core.router.ControllerRouter
import org.jbrat.core.router.ViewRouter
import org.jbrat.core.localer.BasicLocaler
import org.jbrat.core.router.filter.RedirectFilter


class JBrat { //TODO TEST AND FINISH THIS

    private static def JBrat self

    private def localer
    private def viewRouter
    private def router

    private JBrat(){

        //read application.properties and set to bean
        //then init all components
        def beanContainer = new BeanContainer(new BeanBuilder().build())
        def redirector    = new RedirectFilter  (beanContainer)
        def controlRouter = new ControllerRouter(beanContainer)
        localer           = new BasicLocaler    (beanContainer)
        viewRouter        = new ViewRouter      (beanContainer)

        router = redirector >> controlRouter >> new ControllerFilter() >> viewRouter

    }

    void route(path){
        router.route(path)
    }

    void start(){
        route("root")
    }

    void render(name,bean){
        viewRouter.route(name,bean)
    }

    def localeText(name){
        return localer.localeText(name)
    }

    static JBrat getInstance(){
        if(self == null){
            self = new JBrat()
        }
        return self
    }

}
