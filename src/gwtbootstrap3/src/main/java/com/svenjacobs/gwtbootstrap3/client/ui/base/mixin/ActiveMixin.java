package com.svenjacobs.gwtbootstrap3.client.ui.base.mixin;

import com.google.gwt.user.client.ui.UIObject;
import com.svenjacobs.gwtbootstrap3.client.ui.HasActive;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 */
public class ActiveMixin extends AbstractMixin implements HasActive {

    public ActiveMixin(final UIObject uiObject) {
        super(uiObject);
    }

    @Override
    public void setActive(final boolean active) {
        if (active) {
            uiObject.addStyleName(Styles.ACTIVE);
        } else {
            uiObject.removeStyleName(Styles.ACTIVE);
        }
    }

    @Override
    public boolean isActive() {
        return StyleHelper.containsStyle(uiObject.getStyleName(), Styles.ACTIVE);
    }
}
