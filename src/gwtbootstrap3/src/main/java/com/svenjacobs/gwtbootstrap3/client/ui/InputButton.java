package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.svenjacobs.gwtbootstrap3.client.ui.base.button.AbstractToggleButton;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Attributes;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.TypeAttrType;

/**
 * Button based on {@code <input>} element.
 *
 * @author Sven Jacobs
 * @see Button
 * @see com.svenjacobs.gwtbootstrap3.client.ui.base.button.AbstractToggleButton
 */
public class InputButton extends AbstractToggleButton {

    public InputButton() {
        this(TypeAttrType.BUTTON);
    }

    public InputButton(final TypeAttrType type) {
        setTypeAttr(type);
    }

    @Override
    public void setText(final String text) {
        getElement().setAttribute(Attributes.VALUE, text);
    }

    @Override
    public String getText() {
        return getElement().getAttribute(Attributes.VALUE);
    }

    public void setTypeAttr(final TypeAttrType type) {
        getElement().setAttribute(Attributes.TYPE, type.getInputType());
    }

    @Override
    protected Element createElement() {
        return DOM.createElement("input");
    }
}
