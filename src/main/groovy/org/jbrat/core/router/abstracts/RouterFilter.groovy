package org.jbrat.core.router.abstracts

import groovy.transform.CompileStatic
import org.jbrat.core.ability.TransferAbility
import org.jbrat.core.data.Bean
import org.jbrat.core.router.data.RouteData

@CompileStatic
abstract class RouterFilter extends TransferAbility implements Router{
    @Override
    Bean route(String path, Bean bean=null) {

        RouteData routeData  = new RouteData(path: path,bean: bean)

        this.filt(routeData)

        if(nextTarget == null){
            return routeData.getBean()
        }else{
            return ((Router) nextTarget).route(routeData.getPath(),routeData.getBean())
        }

    }

    protected abstract void filt(RouteData routeData);

}
