package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * A lightweight, flexible component to showcase key content.
 *
 * @author Sven Jacobs
 */
public class Jumbotron extends ComplexWidget {

    public Jumbotron() {
        setElement(DOM.createDiv());
        setStyleName(Styles.JUMBOTRON);
    }
}
