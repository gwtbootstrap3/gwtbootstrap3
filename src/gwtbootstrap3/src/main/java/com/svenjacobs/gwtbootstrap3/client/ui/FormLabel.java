package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Attributes;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 */
public class FormLabel extends AbstractTextWidget {

    public FormLabel() {
        super(DOM.createLabel());
        setStyleName(Styles.CONTROL_LABEL);
    }

    public void setFor(final String f) {
        if (f != null) {
            getElement().setAttribute(Attributes.FOR, f);
        } else {
            getElement().removeAttribute(Attributes.FOR);
        }
    }
}
