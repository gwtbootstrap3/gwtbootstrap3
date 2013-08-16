package com.svenjacobs.gwtbootstrap3.client.ui.base;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;

/**
 * Base class for {@link com.svenjacobs.gwtbootstrap3.client.ui.InputGroupAddon} and
 * {@link com.svenjacobs.gwtbootstrap3.client.ui.InputGroupButton}
 *
 * @author Sven Jacobs
 * @see com.svenjacobs.gwtbootstrap3.client.ui.InputGroupAddon
 * @see com.svenjacobs.gwtbootstrap3.client.ui.InputGroupButton
 */
public abstract class AbstractInputGroupAddon extends ComplexPanel {

    protected AbstractInputGroupAddon(final String styleName) {
        setElement(DOM.createSpan());
        setStyleName(styleName);
    }
}
