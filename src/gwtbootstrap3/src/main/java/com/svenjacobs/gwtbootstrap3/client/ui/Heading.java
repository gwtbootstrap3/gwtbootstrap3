package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractTextWidget;

/**
 * @author Sven Jacobs
 */
public class Heading extends AbstractTextWidget {

    @UiConstructor
    public Heading(final int size) {
        super(DOM.createElement("h" + size));
        assert size > 0 && size < 7 : "Wrong heading size (must be between 1 and 6)";
    }
}
