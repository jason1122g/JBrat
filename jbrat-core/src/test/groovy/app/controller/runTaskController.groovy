package app.controller

import org.jbrat.controllers.Controller
import org.jbrat.core.data.abstracts.Bindable


class runTaskController implements Controller{
    @Override
    void prepare(Bindable bean) {
        bean?.test?.call(bean)
        bean.className = this.getClass().getSimpleName()
    }
}
