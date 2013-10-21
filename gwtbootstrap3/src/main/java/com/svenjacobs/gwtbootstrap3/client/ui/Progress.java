package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ProgressType;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class Progress extends Div implements HasType<ProgressType> {

    public Progress() {
        setStyleName(Styles.PROGRESS);
    }

    public void setActive(boolean active) {
        if (active) {
            addStyleName(Styles.ACTIVE);
        }
    }

    @Override
    public void setType(ProgressType type) {
        StyleHelper.addEnumStyleName(this, type);
    }

    @Override
    public ProgressType getType() {
        return ProgressType.fromStyleName(getStyleName());
    }
}
