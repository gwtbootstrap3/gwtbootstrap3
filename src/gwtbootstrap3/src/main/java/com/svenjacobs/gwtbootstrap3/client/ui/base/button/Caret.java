package com.svenjacobs.gwtbootstrap3.client.ui.base.button;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 */
class Caret extends Widget {
    Caret() {
        setElement(DOM.createSpan());
        setStyleName(Styles.CARET);
    }
}
