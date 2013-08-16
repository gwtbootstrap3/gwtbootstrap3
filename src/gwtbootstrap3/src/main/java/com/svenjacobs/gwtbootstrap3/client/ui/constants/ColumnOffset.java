package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;

/**
 * @author Sven Jacobs
 */
public enum ColumnOffset implements Size, Style.HasCssName {
    // Small devices (>768px)
    SM_1("col-sm-offset-1"),
    SM_2("col-sm-offset-2"),
    SM_3("col-sm-offset-3"),
    SM_4("col-sm-offset-4"),
    SM_5("col-sm-offset-5"),
    SM_6("col-sm-offset-6"),
    SM_7("col-sm-offset-7"),
    SM_8("col-sm-offset-8"),
    SM_9("col-sm-offset-9"),
    SM_10("col-sm-offset-10"),
    SM_11("col-sm-offset-11"),

    // Medium (>992px) to large devices (>1200px)
    LG_1("col-lg-offset-1"),
    LG_2("col-lg-offset-2"),
    LG_3("col-lg-offset-3"),
    LG_4("col-lg-offset-4"),
    LG_5("col-lg-offset-5"),
    LG_6("col-lg-offset-6"),
    LG_7("col-lg-offset-7"),
    LG_8("col-lg-offset-8"),
    LG_9("col-lg-offset-9"),
    LG_10("col-lg-offset-10"),
    LG_11("col-lg-offset-11");

    private final String cssClass;

    private ColumnOffset(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
