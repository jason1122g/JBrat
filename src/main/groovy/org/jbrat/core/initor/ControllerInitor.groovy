package org.jbrat.core.initor


class ControllerInitor implements ComponentInitor{//http://groovy.codehaus.org/JN3535-Reflection
    private def configBean

    def ControllerInitor(configBean){
        this.configBean = configBean
    }

    @Override
    def init(name,test=null){

    }
}
