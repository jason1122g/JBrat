package org.jbrat.core.router.filter

import groovy.transform.CompileStatic
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.router.abstracts.RouterFilter
import org.jbrat.core.router.data.RouteData
import org.jbrat.core.tool.PropertiesBuilder

@CompileStatic
class RedirectFilter extends RouterFilter{

    private BeanContainer beanContainer
    private Map routeTable = [:]
    private String routeFileName = "routes.properties"

    RedirectFilter(BeanContainer beanContainer){
        this.beanContainer = beanContainer
        this.readRouteFile()
    }

    private void readRouteFile(){
        String path = beanContainer.getLayout().getRoutesPosition()+"/$routeFileName"
        Properties properties = new PropertiesBuilder().fromFile(path).build()
        properties.each { String key, String value->
            routeTable[key] = value
        }
    }

    @Override
    protected void filt(RouteData routeData) {
        String path = routeData.getPath()
        if(routeTable.containsKey(path)){
            routeData.setPath( (String) routeTable[path] )
        }
    }

}
