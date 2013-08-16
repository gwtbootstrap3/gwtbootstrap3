package com.svenjacobs.gwtbootstrap3.client.ui.base.mixin;

import com.google.gwt.user.client.ui.UIObject;

/**
 * @author Sven Jacobs
 */
abstract class AbstractMixin {

    UIObject uiObject;

    AbstractMixin(final UIObject uiObject) {
        this.uiObject = uiObject;
    }
}
