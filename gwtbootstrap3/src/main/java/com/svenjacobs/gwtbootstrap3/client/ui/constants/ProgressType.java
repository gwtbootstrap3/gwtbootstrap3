package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Joshua Godi
 */
public enum ProgressType implements Type, Style.HasCssName {
    DEFAULT(""),
    STRIPED("progress-striped");

    private final String cssClass;

    private ProgressType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static ProgressType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ProgressType.class, DEFAULT);
    }
}