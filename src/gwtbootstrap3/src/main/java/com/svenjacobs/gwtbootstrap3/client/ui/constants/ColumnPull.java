package com.svenjacobs.gwtbootstrap3.client.ui.constants;

import com.google.gwt.dom.client.Style;

/**
 * @author Sven Jacobs
 */
public enum ColumnPull implements Size, Style.HasCssName {
    // Small devices (>768px)
    SM_1("col-sm-pull-1"),
    SM_2("col-sm-pull-2"),
    SM_3("col-sm-pull-3"),
    SM_4("col-sm-pull-4"),
    SM_5("col-sm-pull-5"),
    SM_6("col-sm-pull-6"),
    SM_7("col-sm-pull-7"),
    SM_8("col-sm-pull-8"),
    SM_9("col-sm-pull-9"),
    SM_10("col-sm-pull-10"),
    SM_11("col-sm-pull-11"),

    // Medium (>992px) to large devices (>1200px)
    LG_1("col-lg-pull-1"),
    LG_2("col-lg-pull-2"),
    LG_3("col-lg-pull-3"),
    LG_4("col-lg-pull-4"),
    LG_5("col-lg-pull-5"),
    LG_6("col-lg-pull-6"),
    LG_7("col-lg-pull-7"),
    LG_8("col-lg-pull-8"),
    LG_9("col-lg-pull-9"),
    LG_10("col-lg-pull-10"),
    LG_11("col-lg-pull-11");

    private final String cssClass;

    private ColumnPull(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
