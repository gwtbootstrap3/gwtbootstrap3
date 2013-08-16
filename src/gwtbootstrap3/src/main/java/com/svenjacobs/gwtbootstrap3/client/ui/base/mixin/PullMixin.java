package com.svenjacobs.gwtbootstrap3.client.ui.base.mixin;

import com.google.gwt.user.client.ui.UIObject;
import com.svenjacobs.gwtbootstrap3.client.ui.HasPull;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Pull;

/**
 * @author Sven Jacobs
 */
public class PullMixin extends AbstractMixin implements HasPull {

    public PullMixin(final UIObject uiObject) {
        super(uiObject);
    }

    @Override
    public void setPull(final Pull pull) {
        StyleHelper.addUniqueEnumStyleName(uiObject, Pull.class, pull);
    }

    @Override
    public Pull getPull() {
        return Pull.fromStyleName(uiObject.getStyleName());
    }
}
