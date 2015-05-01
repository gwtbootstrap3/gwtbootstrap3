package org.gwtbootstrap3.client.ui.base;

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

import com.google.gwt.dom.client.Element;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.testing.PassthroughParser;
import com.google.gwt.text.shared.testing.PassthroughRenderer;

public class TextBoxBase extends ValueBoxBase<String> {

    protected TextBoxBase(final Element elem) {
        this(elem, PassthroughRenderer.instance(), PassthroughParser.instance());
    }

    protected TextBoxBase(final Element elem, Renderer<String> renderer, Parser<String> parser) {
        super(elem, renderer, parser);
    }

    @Override
    public String getValue() {
        final String raw = super.getValue();
        return raw == null ? "" : raw;
    }
    
}
