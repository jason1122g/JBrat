package app.view.inner

import app.view.runTaskView
import org.apache.logging.log4j.LogManager
import org.jbrat.core.data.abstracts.Bindable

class Logger1View extends runTaskView{
    @Override
    void render(Bindable bean) {
        super.render(bean)
        LogManager.getLogger(this.class).debug(bean.msg + " -> Logger1View")
    }
}
