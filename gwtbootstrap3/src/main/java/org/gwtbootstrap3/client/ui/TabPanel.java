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

import org.gwtbootstrap3.client.ui.base.HasTabPosition;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.constants.TabPosition;
import org.gwtbootstrap3.client.ui.html.Div;

/**
 * Container widget for tabs
 * <p/>
 * <a href="http://getbootstrap.com/javascript/#tabs">Bootstrap Documentation</a>
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:TabPanel>
 *    <b:NavTabs/>
 *    <b:TabContent/>
 * </b:TabPanel>
 * }
 * </pre>
 *
 * @author Joshua Godi
 * @see org.gwtbootstrap3.client.ui.TabContent
 * @see org.gwtbootstrap3.client.ui.NavTabs
 */
public class TabPanel extends Div implements HasTabPosition {

    /**
     * Creates the widget with the default styles
     */
    public TabPanel() {
        setStyleName(Styles.TABBABLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTabPosition(final TabPosition tabPosition) {
        // When setting TabPosition that isn't TOP, make sure to inherit the
        // PositionedTabs module from Extra's in order to get the CSS injected!
        StyleHelper.addUniqueEnumStyleName(this, TabPosition.class, tabPosition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TabPosition getTabPosition() {
        return TabPosition.fromStyleName(getStyleName());
    }
}
