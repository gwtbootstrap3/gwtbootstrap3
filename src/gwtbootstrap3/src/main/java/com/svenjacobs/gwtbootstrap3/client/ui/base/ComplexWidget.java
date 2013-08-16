package com.svenjacobs.gwtbootstrap3.client.ui.base;

import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base class for widgets that contain further widgets.
 *
 * @author Sven Jacobs
 */
public class ComplexWidget extends ComplexPanel {

    @Override
    public void add(final Widget child) {
        add(child, getElement());
    }
}
