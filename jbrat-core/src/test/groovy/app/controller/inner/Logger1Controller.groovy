package app.controller.inner

import app.controller.runTaskController
import org.jbrat.core.data.abstracts.Bindable

class Logger1Controller extends runTaskController{
    @Override
    void prepare(Bindable bean) {
        super.prepare(bean)
        bean.msg = "Logger1Controller"
    }
}
