package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class Description extends ComplexWidget implements HasResponsiveness {
    public Description() {
        setElement(DOM.createElement("dl"));
    }

    public void setHorizontal(boolean horizontal) {
        setStyleName(Styles.DL_HORIZONTAL, horizontal);
    }

    @Override
    public void add(Widget child) {
        if (!(child instanceof DescriptionComponent)) {
            throw new IllegalArgumentException("Description can only have children of type DescriptionData and DescriptionTitle");
        }
        super.add(child);
    }

    @Override
    public void setVisibleOn(String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }
}