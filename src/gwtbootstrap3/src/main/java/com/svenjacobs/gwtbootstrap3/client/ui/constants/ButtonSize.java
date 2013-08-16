package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Sven Jacobs
 */
public enum ButtonSize implements Size, Style.HasCssName {
    LARGE("btn-lg"),
    DEFAULT(null),
    SMALL("btn-sm"),
    EXTRA_SMALL("btn-xs");

    private final String cssClass;

    private ButtonSize(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static ButtonSize fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ButtonSize.class, DEFAULT);
    }
}
