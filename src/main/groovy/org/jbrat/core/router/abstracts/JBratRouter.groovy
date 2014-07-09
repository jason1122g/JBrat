package org.jbrat.core.router.abstracts

import org.jbrat.core.ability.TransferAbility
import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException


abstract class JBratRouter extends TransferAbility implements Router{

    @Override
    def route(uri,otherBean=null){

        def targetController
        try{
            targetController = Class.forName((String) buildPath(uri) ).newInstance()
        }catch(Exception e){
            throw new RouteFailedException(e)
        }

        def bean = buildBean(otherBean)
        try{
            buildInstanceCall(targetController,bean)
        }catch(Exception e){
            throw new IncorrectFormatException(e)
        }

        if(getNextTarget() == null){
            return bean
        }else{
            return getNextTarget().route(uri,bean)
        }
    }

    protected abstract def    buildPath(uri);
    protected abstract def    buildBean(bean);
    protected abstract def    buildInstanceCall(instance,bean);
}
