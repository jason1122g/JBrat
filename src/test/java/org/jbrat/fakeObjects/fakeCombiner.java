package org.jbrat.fakeObjects;

import org.jbrat.combiners.JCombiner;
import org.jbrat.exceptions.JBratException;
import org.jbrat.models.abstracts.JBundle;

public class fakeCombiner implements JCombiner{
    @Override
    public void onPreparing(JBundle bundle) {
        throw new JBratException();
    }
}
