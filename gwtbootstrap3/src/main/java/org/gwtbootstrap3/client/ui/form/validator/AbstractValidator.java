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

import java.util.MissingResourceException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.UserValidationMessagesResolver;

/**
 * Contains code to lookup the validation message.
 *
 * @param <T> the generic type
 * @author Steven Jardine
 */
public abstract class AbstractValidator<T> implements Validator<T> {

    private UserValidationMessagesResolver messageResolver = GWT.create(UserValidationMessagesResolver.class);

    private ValidationMessages messages = GWT.create(ValidationMessages.class);

    /**
     * Lookup a message first using the messageResolver, then as a fallback the defined messages.
     *
     * @param key the key
     * @return the message.
     */
    protected String lookupMessage(String key) {
        String value = messageResolver.get(key);
        if (value == null) {
            try {
                // Replace "." with "_" in the key.
                value = key == null ? null : messages.getString(key.replace(".", "_"));
            } catch (MissingResourceException e) {
            }
        }
        return value;
    }

}
