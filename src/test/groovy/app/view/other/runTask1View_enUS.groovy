package app.view.other

import org.jbrat.views.JBratView


class runTask1View_enUS extends JBratView{
    @Override
    void render(bean) {
        bean?.test?.call(bean)
    }
}
