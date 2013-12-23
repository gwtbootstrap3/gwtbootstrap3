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
public enum ColumnPush implements Size, Style.HasCssName {
    // Extra small devices (<768px)
    XS_0("col-xs-push-0"),
    XS_1("col-xs-push-1"),
    XS_2("col-xs-push-2"),
    XS_3("col-xs-push-3"),
    XS_4("col-xs-push-4"),
    XS_5("col-xs-push-5"),
    XS_6("col-xs-push-6"),
    XS_7("col-xs-push-7"),
    XS_8("col-xs-push-8"),
    XS_9("col-xs-push-9"),
    XS_10("col-xs-push-10"),
    XS_11("col-xs-push-11"),
    XS_12("col-xs-push-12"),

    // Small devices (>=768px)
    SM_0("col-sm-push-0"),
    SM_1("col-sm-push-1"),
    SM_2("col-sm-push-2"),
    SM_3("col-sm-push-3"),
    SM_4("col-sm-push-4"),
    SM_5("col-sm-push-5"),
    SM_6("col-sm-push-6"),
    SM_7("col-sm-push-7"),
    SM_8("col-sm-push-8"),
    SM_9("col-sm-push-9"),
    SM_10("col-sm-push-10"),
    SM_11("col-sm-push-11"),

    // Medium devices (>=992px)
    MD_0("col-md-push-0"),
    MD_1("col-md-push-1"),
    MD_2("col-md-push-2"),
    MD_3("col-md-push-3"),
    MD_4("col-md-push-4"),
    MD_5("col-md-push-5"),
    MD_6("col-md-push-6"),
    MD_7("col-md-push-7"),
    MD_8("col-md-push-8"),
    MD_9("col-md-push-9"),
    MD_10("col-md-push-10"),
    MD_11("col-md-push-11"),

    // Large devices (>=1200px)
    LG_0("col-lg-push-0"),
    LG_1("col-lg-push-1"),
    LG_2("col-lg-push-2"),
    LG_3("col-lg-push-3"),
    LG_4("col-lg-push-4"),
    LG_5("col-lg-push-5"),
    LG_6("col-lg-push-6"),
    LG_7("col-lg-push-7"),
    LG_8("col-lg-push-8"),
    LG_9("col-lg-push-9"),
    LG_10("col-lg-push-10"),
    LG_11("col-lg-push-11");

    private final String cssClass;

    private ColumnPush(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
