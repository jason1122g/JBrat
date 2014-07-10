package org.jbrat.core.router.abstracts

import org.jbrat.core.data.BeanFactory
import org.jbrat.core.router.data.RouteData
import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException

abstract class ReflectRouterFilter extends RouterFilter{

    @Override
    protected void filt(RouteData routeData) {
        def targetController
        try{
            targetController = Class.forName((String) buildPath(routeData.getPath()) ).newInstance()
        }catch(Exception e){
            throw new RouteFailedException(e)
        }

        def bean = routeData.getBean()
        if(bean == null){
            bean = BeanFactory.createEmpty()
        }

        def resultBean = buildBean(bean)
        try{
            buildInstanceCall(targetController,resultBean)
        }catch(Exception e){
            throw new IncorrectFormatException(e)
        }

        routeData.setBean(resultBean)
    }

    protected abstract def    buildPath(uri);
    protected abstract def    buildBean(bean);
    protected abstract def    buildInstanceCall(instance,bean);
}
