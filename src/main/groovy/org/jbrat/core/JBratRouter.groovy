package org.jbrat.core


class JBratRouter {
    private static JBratRouter router;
    private JBratRouter(){

    }
    static JBratRouter getInstance() {
        if(router == null){
            router = new JBratRouter();
        }
        return router;
    }

    void route(def path) {

    }
}
