package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Joshua Godi
 */
public enum Responsiveness implements Type, Style.HasCssName {
    DEFAULT(""),
    VISIBLE_PRINT("visible"),
    VISIBLE_XS("visible-xs"),
    VISIBLE_SM("visible-sm"),
    VISIBLE_MD("visible-md"),
    VISIBLE_LG("visible-lg"),
    HIDDEN_PRINT("hidden-print"),
    HIDDEN_XS("hidden-xs"),
    HIDDEN_SM("hidden-sm"),
    HIDDEN_MD("hidden-md"),
    HIDDEN_LG("hidden-lg");

    private final String cssClass;

    private Responsiveness(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static Responsiveness fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, Responsiveness.class, DEFAULT);
    }
}
