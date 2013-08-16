package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractTextWidget;

/**
 * Simple {@code <code>} block for inline code emphasis.
 *
 * @author Sven Jacobs
 * @see Pre
 */
public class Code extends AbstractTextWidget {

    public Code() {
        super(DOM.createElement("code"));
    }
}
