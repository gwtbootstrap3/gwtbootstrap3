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

import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Toggle;

/**
 * Special button to toggle collapsible area of {@link Navbar}.
 * 
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see NavbarCollapse
 */
public class NavbarCollapseButton extends Composite implements HasTarget, HasResponsiveness {

    private final Button button;

    public NavbarCollapseButton() {
        button = new Button();
        button.setStyleName(Styles.NAVBAR_TOGGLE);
        button.setToggle(Toggle.COLLAPSE);

        button.add(newBarIcon());
        button.add(newBarIcon());
        button.add(newBarIcon());

        initWidget(button);
    }

    @Override
    public void setTarget(final String target) {
        button.setTarget(target);
    }

    @Override
    public String getTarget() {
        return button.getTarget();
    }

    @Override
    public void setVisibleOn(String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }

    private Span newBarIcon() {
        final Span span = new Span();
        span.setStyleName(Styles.ICON_BAR);
        return span;
    }
}
