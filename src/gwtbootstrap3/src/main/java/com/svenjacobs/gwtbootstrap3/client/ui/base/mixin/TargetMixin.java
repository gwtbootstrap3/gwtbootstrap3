package com.svenjacobs.gwtbootstrap3.client.ui.base.mixin;

import com.google.gwt.user.client.ui.UIObject;
import com.svenjacobs.gwtbootstrap3.client.ui.HasTarget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Attributes;

/**
 * @author Sven Jacobs
 */
public class TargetMixin extends AbstractMixin implements HasTarget {

    public TargetMixin(final UIObject uiObject) {
        super(uiObject);
    }

    @Override
    public void setTarget(final String target) {
        if (target != null) {
            uiObject.getElement().setAttribute(Attributes.DATA_TARGET, target);
        } else {
            uiObject.getElement().removeAttribute(Attributes.DATA_TARGET);
        }
    }

    @Override
    public String getTarget() {
        return uiObject.getElement().getAttribute(Attributes.DATA_TARGET);
    }
}
