import org.jbrat.managers.JBratManager;

public class Main {
    public static void main(String[] args){
        JBratManager mainManager = JBratManager.createInstance("main");
        mainManager.loadAttrModel   ("example.attrm");
        mainManager.loadAttrView    ("example.attrv");
        mainManager.loadAttrCombiner("example.attrc");

        mainManager.createViewResource("MainView");
    }
}
