package org.gwtbootstrap3.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2015 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.gwtbootstrap3.client.ui.Radio;
import org.gwtbootstrap3.client.ui.base.mixin.BlankValidatorMixin;
import org.gwtbootstrap3.client.ui.base.mixin.ErrorHandlerMixin;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandlerType;
import org.gwtbootstrap3.client.ui.form.error.HasErrorHandler;
import org.gwtbootstrap3.client.ui.form.validator.HasBlankValidator;
import org.gwtbootstrap3.client.ui.form.validator.HasValidators;
import org.gwtbootstrap3.client.ui.form.validator.RadioGroupBlankValidatorMixin;
import org.gwtbootstrap3.client.ui.form.validator.ValidationChangedEvent.ValidationChangedHandler;
import org.gwtbootstrap3.client.ui.form.validator.Validator;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;

import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * Contains a group of radio input elements.
 *
 * @param <T> the return value type of the radio group.
 * @author Steven Jardine
 */
public class RadioGroupBase<T> extends FlowPanel implements HasName, HasValue<T>, LeafValueEditor<T>,
        HasEditorErrors<T>, HasErrorHandler, HasValidators<T>, HasBlankValidator<T> {

    private final ErrorHandlerMixin<T> errorHandlerMixin = new ErrorHandlerMixin<T>(this);

    private String name = null;

    private final Parser<T> parser;

    private final BlankValidatorMixin<RadioGroupBase<T>, T> validatorMixin = new RadioGroupBlankValidatorMixin<RadioGroupBase<T>, T>(
            this, errorHandlerMixin.getErrorHandler());

    private final Map<Radio, HandlerRegistration> valueChangedRegistrations = new HashMap<Radio, HandlerRegistration>();

    /**
     * Constructor.
     *
     * @param name the name
     * @param parser the parser
     */
    public RadioGroupBase(final String name, final Parser<T> parser) {
        super();
        this.name = name;
        this.parser = parser;
    }

    /** {@inheritDoc} */
    @Override
    public void add(final Widget w) {
        super.add(w);
        updateChildren();
    }

    @Override
    public HandlerRegistration addValidationChangedHandler(final ValidationChangedHandler handler) {
        return validatorMixin.addValidationChangedHandler(handler);
    }

    @Override
    public void addValidator(final Validator<T> validator) {
        validatorMixin.addValidator(validator);
    }

    /** {@inheritDoc} */
    @Override
    public com.google.gwt.event.shared.HandlerRegistration addValueChangeHandler(final ValueChangeHandler<T> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public void clear() {
        super.clear();
        updateChildren();
    }

    @Override
    public boolean getAllowBlank() {
        return validatorMixin.getAllowBlank();
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandler getErrorHandler() {
        return errorHandlerMixin.getErrorHandler();
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandlerType getErrorHandlerType() {
        return errorHandlerMixin.getErrorHandlerType();
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return the radio children
     */
    public Set<Radio> getRadioChildren() {
        return getRadioChildren(this, null);
    }

    /**
     * Gets the radio children.
     *
     * @param widget the widget
     * @param c the current children
     * @return the radio children
     */
    protected Set<Radio> getRadioChildren(final Widget widget, final Set<Radio> c) {
        Set<Radio> children = c;
        if (children == null) {
            children = new HashSet<Radio>();
        }
        if (widget instanceof Radio) {
            children.add((Radio) widget);
        } else if (widget instanceof HasOneWidget) {
            children = getRadioChildren(((HasOneWidget) widget).getWidget(), children);
        } else if (widget instanceof HasWidgets) {
            for (Widget w : (HasWidgets) widget) {
                if (w instanceof Radio) {
                    children.add((Radio) w);
                } else {
                    children = getRadioChildren(w, children);
                }
            }
        }
        return children;
    }

    /** {@inheritDoc} */
    @Override
    public boolean getValidateOnBlur() {
        return validatorMixin.getValidateOnBlur();
    }

    /** {@inheritDoc} */
    @Override
    public T getValue() {
        for (Radio child : getRadioChildren()) {
            if (child.getValue()) {
                try {
                    return parser.parse(child.getFormValue());
                } catch (ParseException e) {
                }
            }
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public void insert(final IsWidget w, final int beforeIndex) {
        super.insert(w, beforeIndex);
        updateChildren();
    }

    /** {@inheritDoc} */
    @Override
    public void insert(final Widget w, final int beforeIndex) {
        super.insert(w, beforeIndex);
        updateChildren();
    }

    /** {@inheritDoc} */
    @Override
    public boolean removeValidator(final Validator<T> validator) {
        return validatorMixin.removeValidator(validator);
    }

    /** {@inheritDoc} */
    @Override
    public void reset() {
        setValue(null);
        validatorMixin.reset();
    }

    /** {@inheritDoc} */
    @Override
    public void setAllowBlank(final boolean allowBlank) {
        validatorMixin.setAllowBlank(allowBlank);
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandler(final ErrorHandler handler) {
        errorHandlerMixin.setErrorHandler(handler);
        validatorMixin.setErrorHandler(handler);
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandlerType(final ErrorHandlerType type) {
        errorHandlerMixin.setErrorHandlerType(type);
    }

    /** {@inheritDoc} */
    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public void setValidateOnBlur(final boolean validateOnBlur) {
        validatorMixin.setValidateOnBlur(validateOnBlur);
    }

    @Override
    public void setValidators(final Validator<T>... validators) {
        validatorMixin.setValidators(validators);
    }

    /** {@inheritDoc} */
    @Override
    public void setValue(final T value) {
        setValue(value, false);
    }

    /** {@inheritDoc} */
    @Override
    public void setValue(final T value, final boolean fireEvents) {
        for (Radio child : getRadioChildren()) {
            try {
                if (value != null && value.equals(parser.parse(child.getFormValue()))) {
                    child.setValue(true, fireEvents);
                }
            } catch (ParseException e) {
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void showErrors(final List<EditorError> errors) {
        errorHandlerMixin.showErrors(errors);
    }

    private ValueChangeHandler<Boolean> changeHandler = new ValueChangeHandler<Boolean>() {
        @Override
        public void onValueChange(ValueChangeEvent<Boolean> event) {
            ValueChangeEvent.fire(RadioGroupBase.this, getValue());
        }
    };

    /**
     * Update the radio children names.
     */
    protected void updateChildren() {
        for (Radio child : getRadioChildren()) {
            HandlerRegistration reg = valueChangedRegistrations.get(child);
            if (reg == null) {
                valueChangedRegistrations.put(child, child.addValueChangeHandler(changeHandler));
            }
            child.setName(name);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean validate() {
        return validatorMixin.validate();
    }

    /** {@inheritDoc} */
    @Override
    public boolean validate(final boolean show) {
        return validatorMixin.validate(show);
    }

    /** {@inheritDoc} */
    @Override
    public boolean remove(Widget w) {
        return super.remove(w);
    }

}
