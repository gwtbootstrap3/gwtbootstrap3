package com.svenjacobs.gwtbootstrap3.client.ui.base.mixin;

import com.google.gwt.user.client.ui.UIObject;
import com.svenjacobs.gwtbootstrap3.client.ui.HasToggle;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Attributes;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Toggle;

/**
 * @author Sven Jacobs
 */
public class ToggleMixin extends AbstractMixin implements HasToggle {

    public ToggleMixin(final UIObject uiObject) {
        super(uiObject);
    }

    @Override
    public void setToggle(final Toggle toggle) {
        if (toggle != null) {
            uiObject.getElement().setAttribute(Attributes.DATA_TOGGLE, toggle.getToggle());
        } else {
            uiObject.getElement().removeAttribute(Attributes.DATA_TOGGLE);
        }
    }

    @Override
    public Toggle getToggle() {
        final String toggle = uiObject.getElement().getAttribute(Attributes.DATA_TOGGLE);
        return toggle != null ? Toggle.valueOf(toggle) : null;
    }
}
