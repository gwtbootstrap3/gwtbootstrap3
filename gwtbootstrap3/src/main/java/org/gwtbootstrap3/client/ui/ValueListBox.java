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
import org.gwtbootstrap3.client.ui.base.HasPlaceholder;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.HasSize;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.BlankValidatorMixin;
import org.gwtbootstrap3.client.ui.base.mixin.ErrorHandlerMixin;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.InputSize;
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
        HasResponsiveness, HasPlaceholder, HasSize<InputSize>, HasEditorErrors<T>, HasErrorHandler, HasValidators<T>,
        HasBlankValidator<T> {

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

    /** {@inheritDoc} */
    @Override
    protected void initWidget(final Widget widget) {
        super.initWidget(new ListBox());
    }

    /** {@inheritDoc} */
    @Override
    public void setName(String name) {
        ((ListBox) getWidget()).setName(name);
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return ((ListBox) getWidget()).getName();
    }

    /** {@inheritDoc} */
    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    /** {@inheritDoc} */
    @Override
    public String getId() {
        return idMixin.getId();
    }

    /** {@inheritDoc} */
    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    /** {@inheritDoc} */
    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    /** {@inheritDoc} */
    @Override
    public void setSize(InputSize size) {
        StyleHelper.addUniqueEnumStyleName(this, InputSize.class, size);
    }

    /** {@inheritDoc} */
    @Override
    public InputSize getSize() {
        return InputSize.fromStyleName(getStyleName());
    }

    /** {@inheritDoc} */
    @Override
    public void setPlaceholder(final String placeHolder) {
        getElement().setAttribute(PLACEHOLDER, placeHolder != null ? placeHolder : "");
    }

    /** {@inheritDoc} */
    @Override
    public String getPlaceholder() {
        return getElement().getAttribute(PLACEHOLDER);
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addValidationChangedHandler(ValidationChangedHandler handler) {
        return validatorMixin.addValidationChangedHandler(handler);
    }

    /** {@inheritDoc} */
    @Override
    public boolean getAllowBlank() {
        return validatorMixin.getAllowBlank();
    }

    /** {@inheritDoc} */
    @Override
    public void setAllowBlank(boolean allowBlank) {
        validatorMixin.setAllowBlank(allowBlank);
    }

    /** {@inheritDoc} */
    @Override
    public void addValidator(Validator<T> validator) {
        validatorMixin.addValidator(validator);
    }

    /** {@inheritDoc} */
    @Override
    public boolean removeValidator(Validator<T> validator) {
        return validatorMixin.removeValidator(validator);
    }

    /** {@inheritDoc} */
    @Override
    public boolean getValidateOnBlur() {
        return validatorMixin.getValidateOnBlur();
    }

    /** {@inheritDoc} */
    @Override
    public void reset() {
        setValue(null);
        validatorMixin.reset();
    }

    /** {@inheritDoc} */
    @Override
    public void setValidateOnBlur(boolean validateOnBlur) {
        validatorMixin.setValidateOnBlur(validateOnBlur);
    }

    /** {@inheritDoc} */
    @Override
    public void setValidators(Validator<T>... validators) {
        validatorMixin.setValidators(validators);
    }

    /** {@inheritDoc} */
    @Override
    public boolean validate() {
        return validatorMixin.validate();
    }

    /** {@inheritDoc} */
    @Override
    public boolean validate(boolean show) {
        return validatorMixin.validate(show);
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

    /** {@inheritDoc} */
    @Override
    public void showErrors(List<EditorError> errors) {
        errorHandlerMixin.showErrors(errors);
    }

}
