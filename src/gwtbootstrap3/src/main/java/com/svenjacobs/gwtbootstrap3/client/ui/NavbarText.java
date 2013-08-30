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

import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.NavbarPull;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @see NavbarLink
 */
public class NavbarText extends HTMLPanel implements HasNavbarPull {

    public NavbarText() {
        super("p", "");
        setStyleName(Styles.NAVBAR_TEXT);
    }

    public NavbarText(final String html) {
        this();
        getElement().setInnerHTML(html);
    }

    @Override
    public void setPull(final NavbarPull pull) {
        StyleHelper.addUniqueEnumStyleName(this, NavbarPull.class, pull);
    }

    @Override
    public NavbarPull getPull() {
        return NavbarPull.fromStyleName(getStyleName());
    }

    @Override
    public void add(final Widget child) {
        add(child, getElement());
    }
}
