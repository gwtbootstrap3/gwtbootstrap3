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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * Simple text node.
 *
 * @author Sven Jacobs
 */
public class Text extends Widget implements HasText {

    private final com.google.gwt.dom.client.Text text;

    public Text() {
        this("");
    }

    public Text(final String txt) {
        text = Document.get().createTextNode(txt);
        setElement(text.<Element>cast());
    }

    @Override
    public void setText(final String txt) {
        text.setData(txt);
    }

    @Override
    public String getText() {
        return text.getData();
    }
}
