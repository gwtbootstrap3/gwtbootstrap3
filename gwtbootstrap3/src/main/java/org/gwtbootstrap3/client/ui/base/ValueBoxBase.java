package org.gwtbootstrap3.client.ui.base;

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
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;
import org.gwtbootstrap3.client.ui.HasAutocomplete;
import org.gwtbootstrap3.client.ui.HasId;
import org.gwtbootstrap3.client.ui.HasPlaceholder;
import org.gwtbootstrap3.client.ui.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;

public class ValueBoxBase<T> extends com.google.gwt.user.client.ui.ValueBoxBase<T> implements HasId, HasResponsiveness,
        HasPlaceholder, HasAutocomplete {

    private final IdMixin<ValueBoxBase<T>> idMixin = new IdMixin<ValueBoxBase<T>>(this);

    /**
     * Creates a value box that wraps the given browser element handle. This is
     * only used by subclasses.
     *
     * @param elem the browser element to wrap
     */
    protected ValueBoxBase(final Element elem, final Renderer<T> renderer, final Parser<T> parser) {
        super(elem, renderer, parser);
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
    public void setId(final String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }

    @Override
    public void setVisibleOn(final String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(final String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }
}
