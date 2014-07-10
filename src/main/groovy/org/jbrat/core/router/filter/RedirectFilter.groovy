package org.jbrat.core.router.filter

import org.jbrat.core.data.BeanContainer
import org.jbrat.core.router.abstracts.RouterFilter
import org.jbrat.core.router.data.RouteData
import org.jbrat.core.tool.PropertiesBuilder


class RedirectFilter extends RouterFilter{

    private BeanContainer beanContainer
    private routeTable = [:]
    private String routeFileName = "routes.properties"

    RedirectFilter(beanContainer){
        this.beanContainer = beanContainer
        this.readRouteFile()
    }

    private void readRouteFile(){
        def path = beanContainer.getLayout().getRoutesPosition()+"/$routeFileName"
        Properties properties = new PropertiesBuilder().fromFile(path).build()
        properties.each { key,value->
            routeTable[key] = value
        }
    }

    @Override
    protected void filt(RouteData routeData) {
        def path = routeData.getPath()
        if(routeTable.containsKey(path)){
            routeData.setPath(routeTable[path])
        }
    }

}
