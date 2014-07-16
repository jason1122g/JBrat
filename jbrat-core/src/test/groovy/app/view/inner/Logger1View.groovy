package app.view.inner

import app.view.runTaskView
import org.apache.logging.log4j.LogManager
import org.jbrat.core.data.abstracts.Bean

class Logger1View extends runTaskView{
    @Override
    void render(Bean bean) {
        super.render(bean)
        LogManager.getLogger(this.class).debug(bean.msg + " -> Logger1View")
    }
}
