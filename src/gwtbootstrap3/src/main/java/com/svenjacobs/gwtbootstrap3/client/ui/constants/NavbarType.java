package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Sven Jacobs
 */
public enum NavbarType implements Type, Style.HasCssName {
    DEFAULT(null),
    FIXED_TOP("navbar-fixed-top"),
    FIXED_BOTTOM("navbar-fixed-bottom"),
    STATIC_TOP("navbar-static-top");

    private final String cssClass;

    private NavbarType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static NavbarType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, NavbarType.class, DEFAULT);
    }
}
