package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Sven Jacobs
 */
public enum LabelType implements Type, Style.HasCssName {
    DEFAULT("label-default"),
    SUCCESS("label-success"),
    INFO("label-info"),
    WARNING("label-warning"),
    DANGER("label-danger");

    private final String cssClass;

    private LabelType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static LabelType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, LabelType.class, DEFAULT);
    }
}
