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
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;

public class ValueBoxBase<T> extends com.google.gwt.user.client.ui.ValueBoxBase<T> implements HasId, HasResponsiveness,
        HasPlaceholder, HasAutoComplete {
    private static final String MAX_LENGTH = "maxlength";

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

    public void setMaxLength(final int maxLength) {
        getElement().setAttribute(MAX_LENGTH, Integer.toString(maxLength));
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
    public void setAutoComplete(final boolean autoComplete) {
        getElement().setAttribute(AUTO_COMPLETE, autoComplete ? ON : OFF);
    }

    @Override
    public String getAutoComplete() {
        return getElement().getAttribute(AUTO_COMPLETE);
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
    public void setVisibleOn(DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }
}
