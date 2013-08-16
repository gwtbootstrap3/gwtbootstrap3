package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasEnabled;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;

/**
 * @author Sven Jacobs
 * @see Form
 */
public class FieldSet extends ComplexWidget implements HasEnabled {

    public FieldSet() {
        setElement(DOM.createFieldSet());
    }

    @Override
    public void setEnabled(final boolean enabled) {
        getElement().setPropertyBoolean("disabled", !enabled);
    }

    @Override
    public boolean isEnabled() {
        return !getElement().getPropertyBoolean("disabled");
    }
}
