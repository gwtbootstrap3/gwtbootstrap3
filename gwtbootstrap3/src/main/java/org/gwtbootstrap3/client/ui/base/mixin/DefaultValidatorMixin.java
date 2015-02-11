package org.gwtbootstrap3.client.ui.base.mixin;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;
import org.gwtbootstrap3.client.ui.form.validator.HasValidators;
import org.gwtbootstrap3.client.ui.form.validator.Validator;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasValue;

/**
 * Abstract validator mixin. Contains all of the validation logic.
 *
 * @param <W> the generic type
 * @param <V> the value type
 */
public class DefaultValidatorMixin<W extends FocusWidget & HasValue<V> & Editor<V>, V> implements HasValidators<V> {

    private HandlerRegistration blurHandler;

    protected ErrorHandler errorHandler = null;

    private W inputWidget;

    private boolean validateOnBlur = false;

    protected List<Validator<V>> validators = new ArrayList<Validator<V>>();

    private boolean valid;

    /**
     * Instantiates a new abstract validator mixin.
     *
     * @param inputWidget the input widget
     * @param errorHandler the error handler
     */
    public DefaultValidatorMixin(W inputWidget, ErrorHandler errorHandler) {
        super();
        this.inputWidget = inputWidget;
        this.errorHandler = errorHandler;
    }

    /** {@inheritDoc} */
    @Override
    public void addValidator(Validator<V> validator) {
        addValidator(validator, false);
    }

    /** {@inheritDoc} */
    @Override
    public void addValidator(Validator<V> validator, boolean addToFront) {
        validators.remove(validator);
        if (addToFront) {
            validators.add(0, validator);
        } else {
            validators.add(validator);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean getValidateOnBlur() {
        return validateOnBlur;
    }

    /**
     * Sets the error handler.
     *
     * @param errorHandler the new error handler
     */
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    /** {@inheritDoc} */
    @Override
    public void setValidateOnBlur(boolean vob) {
        validateOnBlur = vob;
        if (validateOnBlur && inputWidget instanceof FocusWidget) {
            blurHandler = inputWidget.addBlurHandler(new BlurHandler() {
                @Override
                public void onBlur(BlurEvent event) {
                    validate();
                }
            });
        } else if (blurHandler != null) {
            blurHandler.removeHandler();
            blurHandler = null;
        }
        if (!valid) {
            validate();
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setValidators(Validator<V>... newValidators) {
        validators.clear();
        validators.addAll(Arrays.asList(newValidators));
    }

    /** {@inheritDoc} */
    @Override
    public boolean validate() {
        return validate(true);
    }

    /** {@inheritDoc} */
    @Override
    public boolean validate(boolean show) {
        List<EditorError> errors = new ArrayList<EditorError>();
        for (Validator<V> validator : validators) {
            List<EditorError> result = validator.validate(inputWidget, inputWidget.getValue());
            if (result != null && !result.isEmpty()) {
                errors.addAll(validator.validate(inputWidget, inputWidget.getValue()));
            }
        }
        valid = true;
        if (errors.size() > 0) {
            valid = false;
            if (errorHandler != null) {
                errorHandler.showErrors(errors);
            }
        } else if (errorHandler != null) {
            errorHandler.clearErrors();
        }
        return valid;
    }

    /** {@inheritDoc} */
    @Override
    public void reset() {
        if (errorHandler != null) {
            errorHandler.clearErrors();
        }
    }

}
