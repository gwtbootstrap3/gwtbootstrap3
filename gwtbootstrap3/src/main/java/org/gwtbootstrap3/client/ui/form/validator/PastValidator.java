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
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.Date;

import org.gwtbootstrap3.client.ui.form.validator.ValidationMessages.Keys;

/**
 * Validator for checking if a date is in the past.
 *
 * @param <T> the generic type
 * @author Steven Jardine
 */
public class PastValidator extends AbstractValidator<Date> {

    public PastValidator() {
        super(Keys.PAST, new Object[0]);
    }

    public PastValidator(String invalidMessageOverride) {
        super(invalidMessageOverride);
    }

    /** {@inheritDoc} */
    @Override
    public int getPriority() {
        return Priority.MEDIUM;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isValid(Date value) {
        if (value != null) { return value.before(new Date()); }
        return true;
    }

}
