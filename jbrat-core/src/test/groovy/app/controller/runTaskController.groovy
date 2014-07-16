package app.controller

import org.jbrat.controllers.Controller
import org.jbrat.core.data.abstracts.Bean


class runTaskController implements Controller{
    @Override
    void prepare(Bean bean) {
        bean?.test?.call(bean)
        bean.className = this.getClass().getSimpleName()
    }
}
