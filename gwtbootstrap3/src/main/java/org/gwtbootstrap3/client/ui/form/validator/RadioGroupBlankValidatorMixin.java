package org.gwtbootstrap3.client.ui.form.validator;

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

import org.gwtbootstrap3.client.ui.base.RadioGroupBase;
import org.gwtbootstrap3.client.ui.base.mixin.BlankValidatorMixin;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;

/**
 * Blank validator mixin for a radio group.
 *
 * @param <W> the widget type
 * @param <V> the value type
 * 
 * @author Steven Jardine
 */
public class RadioGroupBlankValidatorMixin<W extends RadioGroupBase<V>, V> extends BlankValidatorMixin<W, V> {

    /**
     * Constructor.
     *
     * @param inputWidget the input widget
     * @param errorHandler the error handler
     */
    public RadioGroupBlankValidatorMixin(final W inputWidget, final ErrorHandler errorHandler) {
        super(inputWidget, errorHandler);
    }

    /** {@inheritDoc} */
    @Override
    protected BlankValidator<V> createBlankValidator() {
        return new RadioGroupBlankValidator<V>(getInputWidget());
    }

}
