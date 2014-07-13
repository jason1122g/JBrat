package org.jbrat.core.router.abstracts

import groovy.transform.CompileStatic
import org.jbrat.core.data.BeanFactory
import org.jbrat.core.data.abstracts.Bindable
import org.jbrat.core.router.data.RouteData
import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException

@CompileStatic
abstract class ReflectRouterFilter extends RouterFilter{

    @Override
    protected void filt(RouteData routeData) {
        def targetController
        try{
            targetController = Class.forName( buildPath(routeData.getPath()) ).newInstance()
        }catch(Exception e){
            throw new RouteFailedException(e)
        }

        Bindable bean = routeData.getBean()
        if(bean == null){
            bean = BeanFactory.createEmpty()
        }

        Bindable resultBean = buildBean(bean)
        try{
            buildInstanceCall(targetController,resultBean)
        }catch(Exception e){
            throw new IncorrectFormatException(e)
        }

        routeData.setBean(resultBean)
    }

    protected abstract String   buildPath(String uri);
    protected abstract Bindable buildBean(Bindable bean);
    protected abstract void     buildInstanceCall(Object instance, Bindable bean);
}
