package org.jbrat.controllers

import groovy.transform.CompileStatic

@CompileStatic
abstract class JBratController extends JBratControllerHelper implements Controller{

    @Override
    abstract void prepare(bean);

}
