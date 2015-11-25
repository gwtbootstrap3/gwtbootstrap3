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

import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;
import org.gwtbootstrap3.client.ui.form.validator.BlankValidator;
import org.gwtbootstrap3.client.ui.form.validator.Validator;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

/**
 * Mixin that provides the allowBlank functionality for input fields.
 *
 * @param <W> the generic type
 * @param <V> the value type
 * 
 * @author Steven Jardine
 */
public class BlankValidatorMixin<W extends Widget & HasValue<V> & Editor<V>, V> extends DefaultValidatorMixin<W, V> {

    private boolean allowBlank = true;

    private BlankValidator<V> blankValidator;

    /**
     * Constructor.
     *
     * @param inputWidget the input widget
     * @param errorHandler the error handler
     */
    public BlankValidatorMixin(W inputWidget, ErrorHandler errorHandler) {
        super(inputWidget, errorHandler);
    }

    /** {@inheritDoc} */
    @Override
    public void addValidator(Validator<V> validator) {
        if (validator instanceof BlankValidator) {
            allowBlank = false;
        }
        super.addValidator(validator);
    }

    /**
     * Hook for custom blank validators.
     *
     * @return the blank validator
     */
    protected BlankValidator<V> createBlankValidator() {
        return new BlankValidator<V>();
    }

    /**
     * @return the allow blank
     */
    public boolean getAllowBlank() {
        return allowBlank;
    }

    /**
     * @param allowBlank the new allow blank
     */
    public void setAllowBlank(boolean allowBlank) {
        if (blankValidator == null) {
            blankValidator = createBlankValidator();
        }
        this.allowBlank = allowBlank;
        if (!allowBlank) {
            addValidator(blankValidator);
        } else {
            removeValidator(blankValidator);
        }
    }

}
