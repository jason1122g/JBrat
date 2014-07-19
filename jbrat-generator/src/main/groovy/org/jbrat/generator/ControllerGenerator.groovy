package org.jbrat.generator

import groovy.transform.CompileStatic
import org.jbrat.core.data.BeanContainer
import org.jbrat.generator.abstracts.BasicGenerator
import org.jbrat.tool.JBratTemplate
import org.jbrat.tool.StringTemplate


@CompileStatic
class ControllerGenerator extends BasicGenerator{

    private BeanContainer beanContainer

    ControllerGenerator(BeanContainer beanContainer){
        this.beanContainer = beanContainer
    }

    @Override
    protected String getComponentPackage() {
        beanContainer.layout.controllerLocation
    }

    @Override
    protected String getFileNameSuffix() {
        "Controller.groovy"
    }

    @Override
    protected StringTemplate getStringTemplate(String fileName) {
        new JBratTemplate(JBratTemplate.CONTROLLER).asStringTemplate()
    }

}
