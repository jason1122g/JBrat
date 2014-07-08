package app.view.other

import org.jbrat.views.JBratView


class runTask2View_enUS extends JBratView{
    @Override
    void render(bean) {
        bean?.test?.call(bean)
        bean.className = this.getClass().getSimpleName()
    }
}
