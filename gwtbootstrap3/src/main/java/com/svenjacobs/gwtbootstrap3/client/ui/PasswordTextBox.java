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

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Pontus Enmark
 */
public class PasswordTextBox extends com.google.gwt.user.client.ui.PasswordTextBox implements HasId, HasResponsiveness,
        HasAutocomplete, HasPlaceholder {

    private final IdMixin<PasswordTextBox> idMixin = new IdMixin<PasswordTextBox>(this);

    public PasswordTextBox() {
        this(DOM.createInputPassword());
    }

    public PasswordTextBox(final Element element) {
        super(element);
        setStyleName(Styles.FORM_CONTROL);
    }

    @Override
    public void setPlaceholder(final String placeHolder) {
        getElement().setAttribute(PLACEHOLDER, placeHolder != null ? placeHolder : "");
    }

    @Override
    public String getPlaceholder() {
        return getElement().getAttribute(PLACEHOLDER);
    }

    @Override
    public void setAutocomplete(final boolean autoComplete) {
        getElement().setAttribute(AUTOCOMPLETE, autoComplete ? ON : OFF);
    }

    @Override
    public String getAutocomplete() {
        return getElement().getAttribute(AUTOCOMPLETE);
    }

    @Override
    public void setVisibleOn(String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }

    @Override
    public void setId(String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }
}
