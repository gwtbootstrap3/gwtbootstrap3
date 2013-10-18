package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class Description extends ComplexWidget {
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
}