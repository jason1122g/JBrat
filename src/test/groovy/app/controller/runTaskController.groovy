package app.controller

import org.jbrat.controllers.Controller


class runTaskController implements Controller{
    @Override
    void prepare(bean) {
        bean?.test?.call(bean)
        bean.className = this.getClass().getSimpleName()
    }
}
