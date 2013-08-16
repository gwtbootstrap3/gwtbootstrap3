package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractTextWidget;

/**
 * Legend to be used within {@link Form}
 *
 * @author Sven Jacobs
 * @see Form
 */
public class Legend extends AbstractTextWidget {

    public Legend() {
        super(DOM.createLegend());
    }
}
