package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Sven Jacobs
 */
public enum FormType implements Type, Style.HasCssName {
    DEFAULT(null),
    INLINE("form-inline"),
    HORIZONTAL("form-horizontal");

    private final String cssClass;

    private FormType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static FormType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, FormType.class, DEFAULT);
    }
}
