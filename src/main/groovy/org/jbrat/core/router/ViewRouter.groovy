package org.jbrat.core.router

import org.jbrat.core.data.BeanFactory
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.router.abstracts.JBratRouter

class ViewRouter extends JBratRouter{

    private def lastView
    private def componentBean
    private BeanContainer beanContainer

    def ViewRouter(beanContainer){
        this.beanContainer = beanContainer
        this.componentBean = BeanFactory.createEmpty()
    }

    protected def buildPath(uri){
        def path =  beanContainer.getLayout().getViewPosition()+"."+ uri + "View"
        def expectPath = path + "_" + beanContainer.getLocale()
        if( isClassExist (expectPath) ){
            path = expectPath
        }
        return path
    }

    private def isClassExist(String path){
        try{
            Class.forName(path,false,this.getClass().getClassLoader()).newInstance()
        }catch(ClassNotFoundException ignore){
            return false
        }
        return true
    }

    protected def buildBean(bean){
        if(bean==null){
            bean = BeanFactory.createEmpty()
        }
        BeanContainer beanContainer = new BeanContainer(bean)
        beanContainer.setComponent(componentBean)
        return bean
    }

    protected def buildInstanceCall(instance,bean){
        if(lastView!=null){
            lastView.exit()
        }

        instance.enter()
        instance.beforeRender()
        instance.render( bean )
        instance.afterRender()

        lastView = instance
    }
}
