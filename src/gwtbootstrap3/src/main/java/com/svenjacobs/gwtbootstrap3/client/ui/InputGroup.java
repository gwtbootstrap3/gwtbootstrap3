package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.ui.FlowPanel;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Input group parent element of {@link InputGroupAddon}.
 *
 * @author Sven Jacobs
 * @see InputGroupAddon
 */
public class InputGroup extends FlowPanel {

    public InputGroup() {
        setStyleName(Styles.INPUT_GROUP);
    }
}
