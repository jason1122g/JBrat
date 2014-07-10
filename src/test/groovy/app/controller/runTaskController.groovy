package app.controller

import org.jbrat.controllers.JBratController


class runTaskController extends JBratController{
    @Override
    void prepare(bean) {
        bean?.test?.call(bean)
        bean.className = this.getClass().getSimpleName()
    }
}
