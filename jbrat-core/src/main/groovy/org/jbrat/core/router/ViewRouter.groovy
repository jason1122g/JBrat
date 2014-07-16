package org.jbrat.core.router

import groovy.transform.CompileStatic
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.BeanFactory
import org.jbrat.core.data.abstracts.Bean
import org.jbrat.core.router.abstracts.ReflectRouterFilter
import org.jbrat.core.tool.Classer
import org.jbrat.views.View

@CompileStatic
class ViewRouter extends ReflectRouterFilter{

    private View lastView
    private Bean componentBean
    private BeanContainer beanContainer

    def ViewRouter(BeanContainer beanContainer){
        this.beanContainer = beanContainer
        this.componentBean = BeanFactory.createEmpty()
    }

    protected String buildPath(String uri){
        String target       = beanContainer.getLayout().getViewLocation()+ "." + uri + "View"
        String expectTarget = target + "_" + beanContainer.getLocale()
        if( Classer.classExists (expectTarget) ){
            target = expectTarget
        }
        return target
    }

    protected Bean buildBean(Bean bean){
        BeanContainer beanContainer = new BeanContainer(bean)
        beanContainer.setComponent(componentBean)
        return bean
    }

    protected void buildInstanceCall(Object instance, Bean bean){
        if( lastView != null ){
            lastView.exit()
        }

        View view = (View) instance
        view.enter()
        view.beforeRender()
        view.render( bean )
        view.afterRender()

        lastView = view
    }

}
