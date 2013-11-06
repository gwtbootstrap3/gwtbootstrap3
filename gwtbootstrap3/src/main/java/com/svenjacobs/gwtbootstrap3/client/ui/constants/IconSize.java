package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Joshua Godi
 */
public enum IconSize implements Style.HasCssName {
    NONE(""),
    LARGE("fa-lg"),
    TIMES2("fa-2x"),
    TIMES3("fa-3x"),
    TIMES4("fa-4x"),
    TIMES5("fa-5x");

    private final String cssClass;

    private IconSize(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static IconSize fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, IconSize.class, NONE);
    }
}