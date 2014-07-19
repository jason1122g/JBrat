package org.jbrat.generator

import groovy.transform.CompileStatic
import org.jbrat.core.data.BeanContainer
import org.jbrat.generator.abstracts.BasicGenerator
import org.jbrat.tool.JBratTemplate
import org.jbrat.tool.StringTemplate


@CompileStatic
class HelperGenerator extends BasicGenerator{

    private BeanContainer beanContainer

    HelperGenerator(BeanContainer beanContainer){
        this.beanContainer = beanContainer
    }

    @Override
    protected String getComponentPackage() {
        beanContainer.layout.helperLocation
    }

    @Override
    protected String getFileNameSuffix() {
        "Helper.groovy"
    }

    @Override
    protected StringTemplate getStringTemplate(String fileName) {
        new JBratTemplate(JBratTemplate.HELPER).asStringTemplate()
    }
}
