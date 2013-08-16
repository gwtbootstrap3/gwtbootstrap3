package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Sven Jacobs
 */
public enum WellSize implements Size, Style.HasCssName {
    LARGE("well-lg"),
    DEFAULT(null),
    SMALL("well-sm");

    private final String cssClass;

    private WellSize(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static WellSize fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, WellSize.class, DEFAULT);
    }
}
