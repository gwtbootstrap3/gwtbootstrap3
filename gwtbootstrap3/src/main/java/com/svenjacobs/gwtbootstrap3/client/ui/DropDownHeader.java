package com.svenjacobs.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 Sven Jacobs
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

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Header element within {@link DropDownMenu}
 * <p/>
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:DropDownMenu>
 *         <b:DropDownHeader>Header 1</b:DropDownHeader>
 *         <b:ListItem>Action 1</b:ListItem>
 *         <b:ListItem>Action 2</b:ListItem>
 *         <b:DropDownHeader>Header 2</b:DropDownHeader>
 *         <b:ListItem>Action 3</b:ListItem>
 *         <b:ListItem>Action 4</b:ListItem>
 *     </b:DropDownMenu>
 * }</pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 */
public class DropDownHeader extends Widget implements HasText, HasResponsiveness {

    public DropDownHeader() {
        setElement(DOM.createElement("li"));
        setStyleName(Styles.DROPDOWN_HEADER);
    }

    @Override
    public void setText(final String text) {
        getElement().setInnerText(text);
    }

    @Override
    public String getText() {
        return getElement().getInnerText();
    }

    @Override
    public void setVisibleOn(String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }
}
