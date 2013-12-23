package org.gwtbootstrap3.client.ui.constants;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.dom.client.Style;

/**
 * @author Sven Jacobs
 */
public enum ColumnPull implements Size, Style.HasCssName {
    // Extra small devices (<768px)
    XS_0("col-xs-pull-0"),
    XS_1("col-xs-pull-1"),
    XS_2("col-xs-pull-2"),
    XS_3("col-xs-pull-3"),
    XS_4("col-xs-pull-4"),
    XS_5("col-xs-pull-5"),
    XS_6("col-xs-pull-6"),
    XS_7("col-xs-pull-7"),
    XS_8("col-xs-pull-8"),
    XS_9("col-xs-pull-9"),
    XS_10("col-xs-pull-10"),
    XS_11("col-xs-pull-11"),
    XS_12("col-xs-pull-12"),

    // Small devices (>=768px)
    SM_0("col-sm-pull-0"),
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

    // Medium devices (>=992px)
    MD_0("col-md-pull-0"),
    MD_1("col-md-pull-1"),
    MD_2("col-md-pull-2"),
    MD_3("col-md-pull-3"),
    MD_4("col-md-pull-4"),
    MD_5("col-md-pull-5"),
    MD_6("col-md-pull-6"),
    MD_7("col-md-pull-7"),
    MD_8("col-md-pull-8"),
    MD_9("col-md-pull-9"),
    MD_10("col-md-pull-10"),
    MD_11("col-md-pull-11"),

    // Large devices (>=1200px)
    LG_0("col-lg-pull-0"),
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
