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

import org.gwtbootstrap3.client.ui.base.HasActive;
import org.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Div;

/**
 * Container widget for the tab pane
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
 * @see org.gwtbootstrap3.client.ui.TabContent
 */
public class TabPane extends Div implements HasActive {
    private final ActiveMixin<TabPane> activeMixin = new ActiveMixin<TabPane>(this);

    /**
     * Creates the default widget with the default styles
     */
    public TabPane() {
        setStyleName(Styles.TAB_PANE);
    }

    /**
     * Sets whether or not to fade the tab pane in/out when clicked
     * Must set in="true" on the first tab if using fade!!
     *
     * @param fade true=fade content in/out, false=don't fade
     */
    public void setFade(final boolean fade) {
        if (fade) {
            addStyleName(Styles.FADE);
        } else {
            removeStyleName(Styles.FADE);
        }
    }

    /**
     * When using fade, but set the first tabpane with in="true" to work properly
     *
     * @param in whether or not the first tab pane will be faded properly
     */
    public void setIn(final boolean in) {
        if (in) {
            addStyleName(Styles.IN);
        } else {
            removeStyleName(Styles.IN);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setActive(final boolean active) {
        activeMixin.setActive(active);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }
}
