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

import org.gwtbootstrap3.client.ui.Radio;
import org.gwtbootstrap3.client.ui.base.RadioGroupBase;

/**
 * Radio group blank validator.
 *
 * @param <T> the generic type
 * 
 * @author Steven Jardine
 */
public class RadioGroupBlankValidator<T> extends BlankValidator<T> {

    private RadioGroupBase<T> inputWidget = null;

    /**
     * Constructor.
     *
     * @param inputWidget the input widget
     */
    public RadioGroupBlankValidator(final RadioGroupBase<T> inputWidget) {
        super();
        this.inputWidget = inputWidget;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isValid(final T value) {
        boolean valid = false;
        for (Radio child : inputWidget.getRadioChildren()) {
            valid |= child.getValue();
        }
        return valid;
    }

}
