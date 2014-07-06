package app.controller

import org.jbrat.controllers.JBratController
import org.jbrat.core.JBratRouterTest


class routeTestController extends JBratController{
    @Override
    void prepare(bean) {
        def var1 = bean.params?.var1
        def var2 = bean.params?.var2
        JBratRouterTest.map1["var1"] = var1
        JBratRouterTest.map1["var2"] = var2
    }
}
