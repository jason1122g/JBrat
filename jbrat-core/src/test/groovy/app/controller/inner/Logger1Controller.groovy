package app.controller.inner

import app.controller.runTaskController
import org.jbrat.core.data.abstracts.Bean

class Logger1Controller extends runTaskController{
    @Override
    void prepare(Bean bean) {
        super.prepare(bean)
        bean.msg = "Logger1Controller"
    }
}
