package app.controller.other

import org.jbrat.controllers.JBratController


class runTask2Controller extends JBratController{
    @Override
    void prepare(bean) {
        bean?.test?.call(bean)
        bean.className = this.getClass().getSimpleName()
    }
}