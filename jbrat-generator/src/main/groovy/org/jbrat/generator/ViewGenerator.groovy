package org.jbrat.generator

import org.jbrat.core.data.BeanContainer
import org.jbrat.generator.abstracts.BasicGenerator
import org.jbrat.tool.StringTemplate

class ViewGenerator extends BasicGenerator{

    private BeanContainer beanContainer

    ViewGenerator(BeanContainer beanContainer){
        this.beanContainer = beanContainer
    }

    @Override
    protected String getComponentPackage() {
        beanContainer.layout.viewLocation
    }

    @Override
    protected String getFileNameSuffix() {
        "View.groovy"
    }

    @Override
    protected StringTemplate getStringTemplate(String fileName) {
        new JBratTemplate(JBratTemplate.VIEW).asStringTemplate()
    }
}
