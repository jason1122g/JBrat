
import org.jbrat.managers.DefaultManager;
import org.jbrat.managers.abstracts.JBratManager;

public class Main {
    public static void main(String[] args){
        JBratManager<String> jBratManager = new DefaultManager<String>(); //will init main view by default
        jBratManager.loadAttribute("Views.txt");
        jBratManager.createViewResource("Views.MainView");
    }
}
