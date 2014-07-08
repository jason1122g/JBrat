package org.jbrat.core.router

import org.jbrat.core.data.JBratBean
import org.jbrat.core.router.Router
import org.jbrat.exceptions.IncorrectFormatException
import org.jbrat.exceptions.RouteFailedException


class ViewRouter implements Router{

    private def configBean
    private def componentBean = new JBratBean()

    private def lastView
    private def targetView

    def ViewRouter(configBean){
        this.configBean = configBean
    }

    @Override
    def route(uri,test=null){

        try{
            targetView = Class.forName(buildPath(uri)).newInstance()
        }catch(ClassNotFoundException e){
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
        def path =  configBean.layout.viewPosition+"."+ uri
        if(isClassExist(path + "_" + configBean.locale)){
            path = path + "_" + configBean.locale
        }
        return path
    }

    private def isClassExist(String path){
        try{
            targetView = Class.forName(path,false,this.getClass().getClassLoader()).newInstance()
        }catch(ClassNotFoundException ignore){
            return false
        }
        return true
    }

    private def buildBean(){
        def bean = new JBratBean()
        bean.component = componentBean
        return bean
    }

    private def buildInstanceCall(bean){
        if(lastView!=null){
            lastView.exit()
        }

        targetView.enter()
        targetView.beforeRender()
        targetView.render( bean )
        targetView.afterRender()

        lastView = targetView
    }

    private static def clearBean(bean){
        bean.component = null
        bean.test = null
        return bean
    }
}
