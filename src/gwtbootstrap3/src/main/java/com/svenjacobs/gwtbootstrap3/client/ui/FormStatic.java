package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 */
public class FormStatic extends AbstractTextWidget {

    public FormStatic() {
        super(DOM.createElement("p"));
        setStyleName(Styles.FORM_CONTROL_STATIC);
    }
}
