package app.controller.other

import org.jbrat.controllers.JBratController


class runTask1Controller extends JBratController{
    @Override
    void prepare(Object bean) {
        bean?.test?.call(bean)
    }
}
