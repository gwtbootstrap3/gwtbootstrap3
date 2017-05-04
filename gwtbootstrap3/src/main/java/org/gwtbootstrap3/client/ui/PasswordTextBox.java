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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import org.gwtbootstrap3.client.ui.base.TextBoxBase;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Pontus Enmark
 * @author Paweł Jan Czochański
 */
public class PasswordTextBox extends TextBoxBase {

    public PasswordTextBox() {
        this(Document.get().createPasswordInputElement());
    }

    public PasswordTextBox(final Element element) {
        super(element);
        setStyleName(Styles.FORM_CONTROL);
    }

    public void clear() {
        super.setValue(null);
    }
}
