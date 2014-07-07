package org.jbrat.controllers

abstract class JBratController extends JBratControllerHelper implements Controller{

    @Override
    abstract void prepare(bean);

}
