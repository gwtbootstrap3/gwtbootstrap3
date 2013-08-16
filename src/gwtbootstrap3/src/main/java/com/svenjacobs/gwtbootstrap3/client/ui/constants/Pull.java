package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Sven Jacobs
 */
public enum Pull implements Style.HasCssName {
    LEFT(Styles.PULL_LEFT),
    RIGHT(Styles.PULL_RIGHT);

    private final String cssClass;

    private Pull(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static Pull fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, Pull.class, null);
    }
}
