package org.jbrat.core.router.filter

import groovy.transform.CompileStatic
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.router.abstracts.RouterFilter
import org.jbrat.core.router.data.RouteData
import org.jbrat.core.tool.PropertiesBuilder

@CompileStatic
class RedirectFilter extends RouterFilter{

    private BeanContainer      beanContainer
    private Map<String,String> routeTable    = [:]
    private String             routeFileName = "/routes.properties"

    RedirectFilter(BeanContainer beanContainer){
        this.beanContainer = beanContainer
        this.readRouteFile()
    }

    private void readRouteFile(){
        def path = beanContainer.getLayout().getRoutesLocation() + routeFileName
        Properties properties = new PropertiesBuilder().fromResource(path).build()
        properties.each { String from, String to->
            routeTable[from] = to
        }
    }

    @Override
    protected void filt(RouteData routeData) {
        def path = routeData.getPath()
        if(routeTable.containsKey(path)){
            routeData.setPath( routeTable[path] )
        }
    }

}
