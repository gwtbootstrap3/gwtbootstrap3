package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @see ListItem
 */
public class NavPills extends Nav implements HasStacked {

    public NavPills() {
        addStyleName(Styles.NAV_PILLS);
    }

    @Override
    public void setStacked(final boolean stacked) {
        if (stacked) {
            addStyleName(Styles.NAV_STACKED);
        } else {
            removeStyleName(Styles.NAV_STACKED);
        }
    }

    @Override
    public boolean isStacked() {
        return StyleHelper.containsStyle(getStyleName(), Styles.NAV_STACKED);
    }
}
