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

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import org.gwtbootstrap3.client.ui.base.button.AbstractToggleButton;
import org.gwtbootstrap3.client.ui.constants.ButtonType;

/**
 * Button based on {@code <a>} element.
 *
 * @author Sven Jacobs
 * @see Button
 * @see org.gwtbootstrap3.client.ui.base.button.AbstractToggleButton
 */
public class AnchorButton extends AbstractToggleButton implements HasHref {

    public AnchorButton(final ButtonType type) {
        super(type);
        setHref(EMPTY_HREF);
    }

    public AnchorButton() {
        this(ButtonType.DEFAULT);
    }

    @Override
    public void setHref(final String href) {
        getAnchorElement().setHref(href);
    }

    @Override
    public String getHref() {
        return getAnchorElement().getHref();
    }

    @Override
    protected Element createElement() {
        return DOM.createAnchor();
    }

    private AnchorElement getAnchorElement() {
        return AnchorElement.as(getElement());
    }
}
