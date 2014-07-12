package app.view.inner

import org.jbrat.core.data.Bean
import org.jbrat.views.JBratView

class System1View extends JBratView{
    @Override
    void render(Bean bean) {
        if(bean.className == null){
            bean.className = this.getClass().getSimpleName()
        }else{
            bean.className += this.getClass().getSimpleName()
        }
    }
}
