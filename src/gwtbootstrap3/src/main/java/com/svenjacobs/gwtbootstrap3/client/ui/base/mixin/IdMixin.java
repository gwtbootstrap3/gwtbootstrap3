package com.svenjacobs.gwtbootstrap3.client.ui.base.mixin;

import com.google.gwt.user.client.ui.UIObject;
import com.svenjacobs.gwtbootstrap3.client.ui.HasId;

/**
 * @author Sven Jacobs
 */
public class IdMixin extends AbstractMixin implements HasId {

    public IdMixin(final UIObject uiObject) {
        super(uiObject);
    }

    @Override
    public void setId(final String id) {
        uiObject.getElement().setId(id);
    }

    @Override
    public String getId() {
        return uiObject.getElement().getId();
    }
}
