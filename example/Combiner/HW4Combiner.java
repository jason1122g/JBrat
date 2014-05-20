package Combiner;

import org.jbrat.combiners.JCombiner;
import org.jbrat.models.abstracts.DataHandler;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JModel;

public class HW4Combiner implements JCombiner {
    @Override
    public void onPreparing(JBundle bundle) {
        final JModel<String> ajaxModel   = bundle.getStringModel("ajax");
        final JModel<String> textModel   = bundle.getStringModel("text");
        final JModel<Integer> eventModel = bundle.getModel("event", Integer.class);

        eventModel.bind("ok", new DataHandler<Integer>() {
            @Override
            public void handle(Integer data) {
                String type = textModel.get("type");
                String name = textModel.get("name");
                String result = String.format("Type:%s->Name:%s", type, name);

                textModel.set("result", result);
                ajaxModel.set("result", result);
                System.out.println(data);
            }
        });
    }
}
