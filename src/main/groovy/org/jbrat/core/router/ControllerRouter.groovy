package org.jbrat.core.router

import org.jbrat.core.data.JBratBean
import org.jbrat.core.tool.routePathParser
import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException


class ControllerRouter implements Router{

    private def configBean
    private def paramsBean
    private def componentBean = new JBratBean()

    private def targetController

    def ControllerRouter(configBean){
        this.configBean = configBean
    }

    @Override
    def route(uri,test=null){

        try{
            targetController = Class.forName( buildPath(uri) ).newInstance()
        }catch(Exception e){
            throw new RouteFailedException(e)
        }

        def bean = buildBean()
        bean.test = test
        try{
            buildInstanceCall(bean)
        }catch(Exception e){
            throw new IncorrectFormatException(e)
        }

        return clearBean(bean)
    }

    private def buildPath(uri){
        def parser = new routePathParser(uri)
        def path   = parser.getPath()
        paramsBean = parser.getParams()
        configBean.layout.controllerPosition + "." + path
    }

    private def buildBean(){
        def bean = new JBratBean()
        bean.config = configBean
        bean.component = componentBean
        bean.params = paramsBean
        return bean
    }

    private def buildInstanceCall(bean){
        targetController.prepare( bean )
    }

    private static def clearBean(bean){
        bean.config = null
        bean.component = null
        bean.params = null
        bean.test = null
        return bean
    }

}
