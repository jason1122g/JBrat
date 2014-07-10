package org.jbrat.core.router.abstracts

import org.jbrat.core.ability.TransferAbility
import org.jbrat.core.router.data.RouteData


abstract class RouterFilter extends TransferAbility implements Router{
    @Override
    def route(path,bean=null) {

        def routeData  = new RouteData(path: path,bean: bean)

        this.filt(routeData)

        if(nextTarget == null){
            return routeData.getBean()
        }else{
            return nextTarget.route(routeData.getPath(),routeData.getBean())
        }

    }

    protected abstract void filt(RouteData routeData);

}
