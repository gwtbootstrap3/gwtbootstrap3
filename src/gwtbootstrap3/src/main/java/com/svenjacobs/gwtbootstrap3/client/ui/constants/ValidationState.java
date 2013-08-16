package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Sven Jacobs
 */
public enum ValidationState implements Style.HasCssName {
    WARNING("has-warning"),
    ERROR("has-error"),
    SUCCESS("has-success");

    private final String cssClass;

    private ValidationState(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static ValidationState fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ValidationState.class, null);
    }
}
