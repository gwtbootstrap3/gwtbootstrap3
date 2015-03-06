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

import org.gwtbootstrap3.client.ui.form.validator.ValidationMessages.Keys;

import com.google.gwt.regexp.shared.RegExp;

/**
 * Validator for checking value matches a regular expression.
 *
 * @param <T> the generic type
 * @author Steven Jardine
 */
public class RegExValidator extends AbstractValidator<String> {

    private RegExp regex;

    public RegExValidator(String pattern) {
        super(Keys.REGEX, new Object[0]);
        regex = RegExp.compile(pattern);
    }

    public RegExValidator(String pattern, String invalidMessageOverride) {
        super(invalidMessageOverride);
        regex = RegExp.compile(pattern);
    }

    /** {@inheritDoc} */
    @Override
    public int getPriority() {
        return Priority.MEDIUM;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isValid(String value) {
        return value == null || regex.test(value);
    }

}
