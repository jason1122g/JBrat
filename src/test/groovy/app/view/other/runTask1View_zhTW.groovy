package app.view.other

import org.jbrat.views.JBratView


class runTask1View_zhTW extends JBratView{
    @Override
    void render(bean) {
        bean?.test?.call(bean)
    }
}
