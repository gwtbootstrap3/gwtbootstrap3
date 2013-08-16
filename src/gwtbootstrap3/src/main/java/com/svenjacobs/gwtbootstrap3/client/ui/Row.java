package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * A row of Bootstrap's fluid grid system.
 *
 * @author Sven Jacobs
 * @see Column
 */
public class Row extends ComplexWidget {

    public Row() {
        setElement(DOM.createDiv());
        setStyleName(Styles.ROW);
    }
}
