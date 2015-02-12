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

import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;

/**
 * Validation messages.
 * 
 * Message functions should be the key with "_" replacing any periods. This allows the
 * ValidationMessageResolver to find the message by key.
 * 
 * @author Steven Jardine
 */
@DefaultLocale("en")
public interface ValidationMessages extends ConstantsWithLookup {

    /**
     * Org_gwtbootstrap3_validation_ blank_message.
     *
     * @return the string
     */
    @Key("org.gwtbootstrap3.validation.Blank.message")
    @DefaultStringValue("Field cannot be blank")
    String org_gwtbootstrap3_validation_Blank_message();

}
