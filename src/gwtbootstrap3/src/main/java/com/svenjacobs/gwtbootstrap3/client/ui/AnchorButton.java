package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.svenjacobs.gwtbootstrap3.client.ui.base.button.AbstractToggleButton;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ButtonType;

/**
 * Button based on {@code <a>} element.
 *
 * @author Sven Jacobs
 * @see Button
 * @see com.svenjacobs.gwtbootstrap3.client.ui.base.button.AbstractToggleButton
 */
public class AnchorButton extends AbstractToggleButton implements HasHref {

    public AnchorButton() {
        setHref("#");
    }

    public AnchorButton(final ButtonType type) {
        super(type);
        setHref("#");
    }

    @Override
    public void setHref(final String href) {
        AnchorElement.as(getElement()).setHref(href);
    }

    @Override
    public String getHref() {
        return AnchorElement.as(getElement()).getHref();
    }

    @Override
    protected Element createElement() {
        return DOM.createAnchor();
    }
}
