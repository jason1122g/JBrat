package org.jbrat.files.data;

import org.jbrat.files.data.abstracts.JCombinerAttribute;
import org.jbrat.files.data.abstracts.JModelAttribute;
import org.jbrat.files.data.abstracts.JSettingAttribute;
import org.jbrat.files.data.abstracts.JViewAttribute;

public final class SettingAttribute implements JSettingAttribute{
    private String version = "";
    private JViewAttribute[]     viewAttributes;
    private JCombinerAttribute[] combinerAttributes;
    private JModelAttribute[]    modelAttributes;
    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public JViewAttribute[] getViewAttributes() {
        return viewAttributes;
    }

    @Override
    public JCombinerAttribute[] getCombinerAttributes() {
        return combinerAttributes;
    }

    @Override
    public JModelAttribute[] getModelAttributes() {
        return modelAttributes;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public void setViewAttributes(JViewAttribute[] viewAttributes) {
        this.viewAttributes = viewAttributes;
    }

    @Override
    public void setCombinerAttributes(JCombinerAttribute[] combinerAttributes) {
        this.combinerAttributes = combinerAttributes;
    }

    @Override
    public void setModelAttributes(JModelAttribute[] modelAttributes) {
        this.modelAttributes = modelAttributes;
    }
}
