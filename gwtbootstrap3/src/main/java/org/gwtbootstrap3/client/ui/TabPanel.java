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

import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.constants.TabPosition;

import com.google.gwt.dom.client.StyleInjector;

/**
 * @author godi
 */
public class TabPanel extends Div implements HasTabPosition {

    static String CUSTOM_LEFT_RIGHT_BOTTOM_CSS = ".tabs-below>.nav-tabs,.tabs-left>.nav-tabs,.tabs-right>.nav-tabs{border-bottom:0}.pill-content>.pill-pane,.tab-content>.tab-pane{display:none}.pill-content>.active,.tab-content>.active{display:block}.tabs-below>.nav-tabs{border-top:1px solid #ddd}.tabs-below>.nav-tabs>li{margin-top:-1px;margin-bottom:0}.tabs-below>.nav-tabs>li>a{-webkit-border-radius:0 0 4px 4px;-moz-border-radius:0 0 4px 4px;border-radius:0 0 4px 4px}.tabs-below>.nav-tabs>li>a:focus,.tabs-below>.nav-tabs>li>a:hover{border-top-color:#ddd;border-bottom-color:transparent}.tabs-below>.nav-tabs>.active>a,.tabs-below>.nav-tabs>.active>a:focus,.tabs-below>.nav-tabs>.active>a:hover{border-color:transparent #ddd #ddd}.tabs-left>.nav-tabs>li,.tabs-right>.nav-tabs>li{float:none}.tabs-left>.nav-tabs>li>a,.tabs-right>.nav-tabs>li>a{min-width:74px;margin-right:0;margin-bottom:3px}.tabs-left>.nav-tabs{float:left;margin-right:19px;border-right:1px solid #ddd}.tabs-left>.nav-tabs>li>a{margin-right:-1px;-webkit-border-radius:4px 0 0 4px;-moz-border-radius:4px 0 0 4px;border-radius:4px 0 0 4px}.tabs-left>.nav-tabs>li>a:focus,.tabs-left>.nav-tabs>li>a:hover{border-color:#eee #ddd #eee #eee}.tabs-left>.nav-tabs .active>a,.tabs-left>.nav-tabs .active>a:focus,.tabs-left>.nav-tabs .active>a:hover{border-color:#ddd transparent #ddd #ddd;*border-right-color:#fff}.tabs-right>.nav-tabs{float:right;margin-left:19px;border-left:1px solid #ddd}.tabs-right>.nav-tabs>li>a{margin-left:-1px;-webkit-border-radius:0 4px 4px 0;-moz-border-radius:0 4px 4px 0;border-radius:0 4px 4px 0}.tabs-right>.nav-tabs>li>a:focus,.tabs-right>.nav-tabs>li>a:hover{border-color:#eee #eee #eee #ddd}.tabs-right>.nav-tabs .active>a,.tabs-right>.nav-tabs .active>a:focus,.tabs-right>.nav-tabs .active>a:hover{border-color:#ddd #ddd #ddd transparent;*border-left-color:#fff}.tabs-left>.tab-content,.tabs-right>.tab-content{float:left}";

    public TabPanel() {
        setStyleName(Styles.TABBABLE);
    }

    @Override
    public void setTabPosition(final TabPosition tabPosition) {
        if (tabPosition != TabPosition.TOP) {
            StyleInjector.inject(CUSTOM_LEFT_RIGHT_BOTTOM_CSS);
        }
        StyleHelper.addUniqueEnumStyleName(this, TabPosition.class, tabPosition);
    }

    @Override
    public TabPosition getTabPosition() {
        return TabPosition.fromStyleName(getStyleName());
    }

}
