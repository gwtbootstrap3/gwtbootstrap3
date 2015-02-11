package org.gwtbootstrap3.client.ui.form.validator;

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
import java.util.List;

import org.gwtbootstrap3.client.ui.form.error.BasicEditorError;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorError;

/**
 * Validator for blank field validation.
 *
 * @param <T> the generic type
 */
public class BlankValidator<T> implements Validator<T> {

    /** {@inheritDoc} */
    @Override
    public List<EditorError> validate(Editor<T> editor, T value) {
        List<EditorError> result = new ArrayList<EditorError>();
        if (value == null || "".equals(value)) {
            result.add(new BasicEditorError(editor, value, ValidationMessages.INSTANCE
                .org_gwtbootstrap3_validation_Blank_message()));
        }
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public int getPriority() {
        return Priority.HIGHEST;
    }

}
