package org.jbrat.core.router.abstracts

import groovy.transform.CompileStatic
import org.jbrat.core.data.BeanFactory
import org.jbrat.core.data.abstracts.Bean
import org.jbrat.core.router.data.RouteData
import org.jbrat.exceptions.IncorrectFormatError
import org.jbrat.exceptions.RouteFailedError

@CompileStatic
abstract class ReflectRouterFilter extends RouterFilter{

    @Override
    protected void filt(RouteData routeData) {

        def targetController
        def targetClassName = buildPath(routeData.getPath())
        try{
            targetController = Class.forName( targetClassName ).newInstance()
        }catch(Exception e){
            throw new RouteFailedError(targetClassName,e)
        }

        Bean bean = routeData.getBean()
        if(bean == null){
            bean = BeanFactory.createEmpty()
        }

        Bean resultBean = buildBean(bean)
        try{
            buildInstanceCall(targetController,resultBean)
        }catch(Exception e){
                throw new IncorrectFormatError("Not implemented by JBrat Component",e)
        }

        routeData.setBean(resultBean)
    }

    protected abstract String buildPath(String uri);
    protected abstract Bean   buildBean(Bean bean);
    protected abstract void   buildInstanceCall(Object instance, Bean bean);
}
