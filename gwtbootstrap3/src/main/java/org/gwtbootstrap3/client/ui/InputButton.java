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

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasName;
import org.gwtbootstrap3.client.ui.base.button.AbstractToggleButton;
import org.gwtbootstrap3.client.ui.constants.Attributes;
import org.gwtbootstrap3.client.ui.constants.ElementTags;
import org.gwtbootstrap3.client.ui.constants.TypeAttrType;

/**
 * Button based on {@code <input>} element.
 *
 * @author Sven Jacobs
 * @see Button
 * @see org.gwtbootstrap3.client.ui.base.button.AbstractToggleButton
 */
public class InputButton extends AbstractToggleButton implements HasName, HasFormValue {

    public InputButton() {
        this(TypeAttrType.BUTTON);
    }

    public InputButton(final TypeAttrType type) {
        setTypeAttr(type);
    }

    @Override
    public void setText(final String text) {
        getElement().setAttribute(Attributes.VALUE, text);
    }

    @Override
    public String getText() {
        return getElement().getAttribute(Attributes.VALUE);
    }

    public void setTypeAttr(final TypeAttrType type) {
        getElement().setAttribute(Attributes.TYPE, type.getInputType());
    }

    @Override
    public void setName(final String name) {
        InputElement.as(getElement()).setName(name);
    }

    @Override
    public String getName() {
        return InputElement.as(getElement()).getName();
    }

    @Override
    public String getFormValue() {
        return InputElement.as(getElement()).getValue();
    }

    @Override
    public void setFormValue(final String value) {
        InputElement.as(getElement()).setValue(value);
    }

    @Override
    protected Element createElement() {
        return DOM.createElement(ElementTags.INPUT);
    }
}
