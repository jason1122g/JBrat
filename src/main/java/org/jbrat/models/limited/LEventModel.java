package org.jbrat.models.limited;

import org.jbrat.models.abstracts.JLimitModel;

public interface LEventModel extends JLimitModel<Runnable> {
    public void trigger(String name);
}
