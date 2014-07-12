package org.jbrat.controllers

import groovy.transform.CompileStatic
import org.jbrat.core.data.Bean

@CompileStatic
abstract class JBratController extends JBratControllerHelper implements Controller{

    @Override
    abstract void prepare(Bean bean);

}
