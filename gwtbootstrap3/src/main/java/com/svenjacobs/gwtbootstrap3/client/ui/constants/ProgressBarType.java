package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Joshua Godi
 */
public enum ProgressBarType implements Type, Style.HasCssName {
    DEFAULT(""),
    SUCCESS("progress-bar-success"),
    INFO("progress-bar-info"),
    WARNING("progress-bar-warning"),
    DANGER("progress-bar-danger");

    private final String cssClass;

    private ProgressBarType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static ProgressBarType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ProgressBarType.class, DEFAULT);
    }
}