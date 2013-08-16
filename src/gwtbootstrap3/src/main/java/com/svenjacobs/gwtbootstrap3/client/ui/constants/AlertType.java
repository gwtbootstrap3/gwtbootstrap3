package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Sven Jacobs
 */
public enum AlertType implements Type, Style.HasCssName {
    DEFAULT(null),
    SUCCESS("alert-success"),
    INFO("alert-info"),
    DANGER("alert-danger");

    private final String cssClass;

    private AlertType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static AlertType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, AlertType.class, DEFAULT);
    }
}
