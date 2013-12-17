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
import org.gwtbootstrap3.client.ui.base.helper.EnumHelper;

/**
 * @author Joshua Godi
 */
public enum Responsiveness implements Type, Style.HasCssName {
    DEFAULT(""),
    VISIBLE_PRINT("visible"),
    VISIBLE_XS("visible-xs"),
    VISIBLE_SM("visible-sm"),
    VISIBLE_MD("visible-md"),
    VISIBLE_LG("visible-lg"),
    HIDDEN_PRINT("hidden-print"),
    HIDDEN_XS("hidden-xs"),
    HIDDEN_SM("hidden-sm"),
    HIDDEN_MD("hidden-md"),
    HIDDEN_LG("hidden-lg");

    private final String cssClass;

    private Responsiveness(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static Responsiveness fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, Responsiveness.class, DEFAULT);
    }
}
