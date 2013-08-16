package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Sven Jacobs
 */
public enum ButtonType implements Type, Style.HasCssName {
    DEFAULT("btn-default"),
    PRIMARY("btn-primary"),
    SUCCESS("btn-success"),
    INFO("btn-info"),
    WARNING("btn-warning"),
    DANGER("btn-danger"),
    LINK("btn-link");

    private final String cssClass;

    private ButtonType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static ButtonType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ButtonType.class, DEFAULT);
    }
}
