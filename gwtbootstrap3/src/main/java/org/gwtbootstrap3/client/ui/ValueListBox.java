package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.mixin.BlankValidatorMixin;
import org.gwtbootstrap3.client.ui.base.mixin.ErrorHandlerMixin;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandlerType;
import org.gwtbootstrap3.client.ui.form.error.HasErrorHandler;
import org.gwtbootstrap3.client.ui.form.validator.HasBlankValidator;
import org.gwtbootstrap3.client.ui.form.validator.HasValidators;
import org.gwtbootstrap3.client.ui.form.validator.ValidationChangedEvent.ValidationChangedHandler;
import org.gwtbootstrap3.client.ui.form.validator.Validator;

import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.HasConstrainedValue;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SimpleKeyProvider;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * Implementation of {@link HasConstrainedValue} based on a
 * {@link com.google.gwt.dom.client.SelectElement}.
 * <p/>
 * A {@link Renderer Renderer<T>} is used to get user-presentable strings to
 * display in the select element.
 *
 * @param <T>
 *            the value type
 */
public class ValueListBox<T> extends com.google.gwt.user.client.ui.ValueListBox<T> implements HasName, HasId,
        HasEditorErrors<T>, HasErrorHandler, HasValidators<T>, HasBlankValidator<T> {

    private final IdMixin<ValueListBox<T>> idMixin = new IdMixin<ValueListBox<T>>(this);

    private final ErrorHandlerMixin<T> errorHandlerMixin = new ErrorHandlerMixin<T>(this);

    private final BlankValidatorMixin<ValueListBox<T>, T> validatorMixin = new BlankValidatorMixin<ValueListBox<T>, T>(
            this, errorHandlerMixin.getErrorHandler());

    public ValueListBox(final Renderer<T> renderer) {
        this(renderer, new SimpleKeyProvider<T>());
    }

    public ValueListBox(final Renderer<T> renderer, final ProvidesKey<T> keyProvider) {
        super(renderer, keyProvider);
    }

    @Override
    protected void initWidget(final Widget widget) {
        super.initWidget(new ListBox());
    }

    @Override
    public void setName(String name) {
        ((ListBox) getWidget()).setName(name);
    }

    @Override
    public String getName() {
        return ((ListBox) getWidget()).getName();
    }

    @Override
    public HandlerRegistration addValidationChangedHandler(ValidationChangedHandler handler) {
        return validatorMixin.addValidationChangedHandler(handler);
    }

    @Override
    public boolean getAllowBlank() {
        return validatorMixin.getAllowBlank();
    }

    @Override
    public void setAllowBlank(boolean allowBlank) {
        validatorMixin.setAllowBlank(allowBlank);
    }

    @Override
    public void addValidator(Validator<T> validator) {
        validatorMixin.addValidator(validator);
    }

    @Override
    public boolean getValidateOnBlur() {
        return validatorMixin.getValidateOnBlur();
    }

    @Override
    public void reset() {
        setValue(null);
        validatorMixin.reset();
    }

    @Override
    public void setValidateOnBlur(boolean validateOnBlur) {
        validatorMixin.setValidateOnBlur(validateOnBlur);
    }

    @Override
    public void setValidators(Validator<T>... validators) {
        validatorMixin.setValidators(validators);
    }

    @Override
    public boolean validate() {
        return validatorMixin.validate();
    }

    @Override
    public boolean validate(boolean show) {
        return validatorMixin.validate(show);
    }

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

    @Override
    public void showErrors(List<EditorError> errors) {
        errorHandlerMixin.showErrors(errors);
    }

    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }
}
