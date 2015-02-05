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

import org.gwtbootstrap3.client.ui.base.HasSize;
import org.gwtbootstrap3.client.ui.base.HasValidationState;
import org.gwtbootstrap3.client.ui.base.form.FormElementContainer;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.FormGroupSize;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.constants.ValidationState;

import com.google.gwt.dom.client.Document;

/**
 * @author Sven Jacobs
 */
public class FormGroup extends FormElementContainer implements HasSize<FormGroupSize>, HasValidationState {

    public FormGroup() {
        setElement(Document.get().createDivElement());
        setStyleName(Styles.FORM_GROUP);
    }

    @Override
    public void setSize(FormGroupSize size) {
        StyleHelper.addUniqueEnumStyleName(this, FormGroupSize.class, size);
    }

    @Override
    public FormGroupSize getSize() {
        return FormGroupSize.fromStyleName(getStyleName());
    }

    @Override
    public void setValidationState(final ValidationState state) {
        StyleHelper.addUniqueEnumStyleName(this, ValidationState.class, state);
    }

    @Override
    public ValidationState getValidationState() {
        return ValidationState.fromStyleName(getStyleName());
    }
}
