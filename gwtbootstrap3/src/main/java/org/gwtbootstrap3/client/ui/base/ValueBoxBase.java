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

import java.util.List;

import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.ErrorHandlerMixin;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.InputSize;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandlerType;
import org.gwtbootstrap3.client.ui.form.error.HasErrorHandler;

import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;

public class ValueBoxBase<T> extends com.google.gwt.user.client.ui.ValueBoxBase<T> implements HasId, HasResponsiveness,
        HasPlaceholder, HasAutoComplete, HasSize<InputSize>, HasEditorErrors<T>, HasErrorHandler {

    private static final String MAX_LENGTH = "maxlength";

    private final IdMixin<ValueBoxBase<T>> idMixin = new IdMixin<ValueBoxBase<T>>(this);

    private final ErrorHandlerMixin<ValueBoxBase<T>, T> errorHandlerMixin = new ErrorHandlerMixin<ValueBoxBase<T>, T>(this);

    /**
     * Creates a value box that wraps the given browser element handle. This is only used by subclasses.
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
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    @Override
    public void setSize(InputSize size) {
        StyleHelper.addUniqueEnumStyleName(this, InputSize.class, size);
    }

    @Override
    public InputSize getSize() {
        return InputSize.fromStyleName(getStyleName());
    }

    /** {@inheritDoc} */
    @Override
    public void setValue(T value, boolean fireEvents) {
        showErrors(null);
        super.setValue(value, fireEvents);
    }

    /** {@inheritDoc} */
    @Override
    public void showErrors(List<EditorError> errors) {
        errorHandlerMixin.showErrors(errors);
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandler getErrorHandler() {
        return errorHandlerMixin.getErrorHandler();
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandler(ErrorHandler handler) {
        errorHandlerMixin.setErrorHandler(handler);
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandlerType getErrorHandlerType() {
        return errorHandlerMixin.getErrorHandlerType();
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandlerType(ErrorHandlerType type) {
        errorHandlerMixin.setErrorHandlerType(type);
    }

}
