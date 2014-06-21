package org.gwtbootstrap3.client.ui;

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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.NavbarPull;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see NavbarLink
 */
public class NavbarText extends ComplexWidget implements HasResponsiveness {

    public NavbarText() {
        setElement(Document.get().createPElement());
        setStyleName(Styles.NAVBAR_TEXT);
    }

    @Override
    public void setPull(final Pull pull) {
        NavbarPull navbarPull = NavbarPull.NONE;

        if (pull == Pull.LEFT) {
            navbarPull = NavbarPull.LEFT;
        } else {
            navbarPull = NavbarPull.RIGHT;
        }

        StyleHelper.addUniqueEnumStyleName(this, NavbarPull.class, navbarPull);
    }

    @Override
    public Pull getPull() {
        NavbarPull navbarPull = NavbarPull.fromStyleName(getStyleName());

        if (navbarPull == NavbarPull.NONE) {
            return Pull.NONE;
        }

        return navbarPull == NavbarPull.RIGHT ? Pull.RIGHT : Pull.LEFT;
    }

    @Override
    public void add(final Widget child) {
        add(child, (Element) getElement());
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }
}
