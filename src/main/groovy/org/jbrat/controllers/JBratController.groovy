package org.jbrat.controllers

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bindable

@CompileStatic
abstract class JBratController extends JBratControllerHelper implements Controller{

    @Override
    abstract void prepare(Bindable bean);

}
