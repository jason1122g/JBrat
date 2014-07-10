package app.view

import org.jbrat.views.JBratView


class runTaskView extends JBratView{
    @Override
    void render(Object bean) {
        bean?.test?.call(bean)
        bean.className = this.getClass().getSimpleName()
    }
}
