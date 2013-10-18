package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractTextWidget;

/**
 * @author Joshua Godi
 */
public class DescriptionData extends AbstractTextWidget implements DescriptionComponent {
    public DescriptionData() {
        super(DOM.createElement("dd"));
    }
}
