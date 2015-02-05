package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.base.ComplexWidget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasEnabled;

/**
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see Form
 */
public class FieldSet extends ComplexWidget implements HasEnabled {
    private static final String DISABLED = "disabled";

    public FieldSet() {
        setElement(Document.get().createFieldSetElement());
    }

    @Override
    public void setEnabled(final boolean enabled) {
        getElement().setPropertyBoolean(DISABLED, !enabled);
    }

    @Override
    public boolean isEnabled() {
        return !getElement().getPropertyBoolean(DISABLED);
    }
}
