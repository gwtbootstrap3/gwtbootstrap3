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
public enum ColumnSize implements Size, Style.HasCssName {
    // Extra small devices (<768px)
    XS_1("col-xs-1"),
    XS_2("col-xs-2"),
    XS_3("col-xs-3"),
    XS_4("col-xs-4"),
    XS_5("col-xs-5"),
    XS_6("col-xs-6"),
    XS_7("col-xs-7"),
    XS_8("col-xs-8"),
    XS_9("col-xs-9"),
    XS_10("col-xs-10"),
    XS_11("col-xs-11"),
    XS_12("col-xs-12"),

    // Small devices (>=768px)
    SM_1("col-sm-1"),
    SM_2("col-sm-2"),
    SM_3("col-sm-3"),
    SM_4("col-sm-4"),
    SM_5("col-sm-5"),
    SM_6("col-sm-6"),
    SM_7("col-sm-7"),
    SM_8("col-sm-8"),
    SM_9("col-sm-9"),
    SM_10("col-sm-10"),
    SM_11("col-sm-11"),
    SM_12("col-sm-12"),

    // Medium devices (>=992px)
    MD_1("col-md-1"),
    MD_2("col-md-2"),
    MD_3("col-md-3"),
    MD_4("col-md-4"),
    MD_5("col-md-5"),
    MD_6("col-md-6"),
    MD_7("col-md-7"),
    MD_8("col-md-8"),
    MD_9("col-md-9"),
    MD_10("col-md-10"),
    MD_11("col-md-11"),
    MD_12("col-md-12"),

    // Large devices (>=1200px)
    LG_1("col-lg-1"),
    LG_2("col-lg-2"),
    LG_3("col-lg-3"),
    LG_4("col-lg-4"),
    LG_5("col-lg-5"),
    LG_6("col-lg-6"),
    LG_7("col-lg-7"),
    LG_8("col-lg-8"),
    LG_9("col-lg-9"),
    LG_10("col-lg-10"),
    LG_11("col-lg-11"),
    LG_12("col-lg-12");

    private final String cssClass;

    private ColumnSize(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
