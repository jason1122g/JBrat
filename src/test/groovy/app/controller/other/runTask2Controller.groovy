package app.controller.other

import org.jbrat.controllers.JBratController


class runTask2Controller extends JBratController{
    @Override
    void prepare(Object bean) {
        bean?.test?.call(bean)
    }
}
