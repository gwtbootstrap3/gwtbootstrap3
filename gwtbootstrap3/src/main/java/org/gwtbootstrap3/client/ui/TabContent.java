package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Div;

import com.google.gwt.user.client.ui.Widget;

/**
 * Container widget for the tab content
 * <p/>
 * <a href="http://getbootstrap.com/javascript/#tabs">Bootstrap Documentation</a>
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:TabContent>
 *    <b:TabPane/>
 *    <b:TabPane/>
 * </b:TabContent>
 * }
 * </pre>
 *
 * @author Joshua Godi
 * @see org.gwtbootstrap3.client.ui.TabPane
 */
public class TabContent extends Div {

    /**
     * Creates the default widget with the default styles
     */
    public TabContent() {
        setStyleName(Styles.TAB_CONTENT);
    }

    /**
     * We override the add to make sure only children of type TabPane can be added!
     *
     * @param child widget to be added
     * @see org.gwtbootstrap3.client.ui.TabPane
     */
    @Override
    public void add(final Widget child) {
        if (!(child instanceof TabPane)) {
            throw new IllegalArgumentException("TabContent must have children of type TabPane.");
        }
        super.add(child);
    }
}
