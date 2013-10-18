package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractTextWidget;

/**
 * @author Joshua Godi
 */
public class DescriptionTitle extends AbstractTextWidget implements DescriptionComponent {
    public DescriptionTitle() {
        super(DOM.createElement("dt"));
    }
}