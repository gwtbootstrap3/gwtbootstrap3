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

import org.gwtbootstrap3.client.ui.base.HasPull;
import org.gwtbootstrap3.client.ui.base.form.AbstractForm;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.NavbarPull;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @see Navbar
 */
public class NavbarForm extends AbstractForm implements HasPull {

    public NavbarForm() {
        setStyleName(Styles.NAVBAR_FORM);
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
}
