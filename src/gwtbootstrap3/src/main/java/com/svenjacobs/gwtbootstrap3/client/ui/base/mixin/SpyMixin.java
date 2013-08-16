package com.svenjacobs.gwtbootstrap3.client.ui.base.mixin;

import com.google.gwt.user.client.ui.UIObject;
import com.svenjacobs.gwtbootstrap3.client.ui.HasSpy;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Attributes;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Spy;

/**
 * @author Sven Jacobs
 */
public class SpyMixin extends AbstractMixin implements HasSpy {

    public SpyMixin(final UIObject uiObject) {
        super(uiObject);
    }

    @Override
    public void setSpy(final Spy spy) {
        if (spy != null) {
            uiObject.getElement().setAttribute(Attributes.DATA_SPY, spy.getSpy());
        } else {
            uiObject.getElement().removeAttribute(Attributes.DATA_SPY);
        }
    }

    @Override
    public Spy getSpy() {
        final String spy = uiObject.getElement().getAttribute(Attributes.DATA_SPY);
        return spy != null ? Spy.valueOf(spy) : null;
    }
}
