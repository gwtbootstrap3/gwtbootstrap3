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

import org.gwtbootstrap3.client.ui.base.ValueBoxBase;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.text.client.IntegerParser;
import com.google.gwt.text.client.IntegerRenderer;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;

public class IntegerBox extends ValueBoxBase<Integer> {

    public IntegerBox() {
        this(IntegerRenderer.instance(), IntegerParser.instance());
    }

    public IntegerBox(Renderer<Integer> renderer, Parser<Integer> parser) {
        super(Document.get().createTextInputElement(), renderer, parser);
        addStyleName(Styles.FORM_CONTROL);
    }

}
