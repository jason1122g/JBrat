package app.view.other

import org.jbrat.views.JBratView


class runTask2View_zhTW extends JBratView{
    @Override
    void render(bean) {
        bean?.test?.call(bean)
        bean.className = this.getClass().getSimpleName()
    }
}
