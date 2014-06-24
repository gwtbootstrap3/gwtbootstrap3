package org.gwtbootstrap3.client.ui.html;

import com.google.gwt.dom.client.SpanElement;

import org.gwtbootstrap3.client.ui.base.HasContextualBackground;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.HTMLMixin;
import org.gwtbootstrap3.client.ui.constants.ContextualBackground;
import org.gwtbootstrap3.client.ui.gwt.HTMLPanel;

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

/**
 * @author Sven Jacobs
 * @author Grant Slender
 * @author David Buhler
 */
public class Span extends HTMLPanel implements HasContextualBackground {

    private final HTMLMixin<Span> textMixin = new HTMLMixin<Span>(this);

    public Span() {
        super(SpanElement.TAG, "");
    }

    public Span(final String html) {
        this();
        setHTML(html);
    }

    public void setText(final String text) {
        textMixin.setText(text);
    }

    public String getText() {
        return textMixin.getText();
    }

    public String getHTML() {
        return textMixin.getHTML();
    }

    public void setHTML(final String html) {
        textMixin.setHTML(html);
    }
    
    @Override
    public void setContextualBackground(final ContextualBackground contextualBackground) {
    	StyleHelper.addUniqueEnumStyleName(this, ContextualBackground.class, contextualBackground);
    }
    
    @Override
    public ContextualBackground getContextualBackground() {
    	return ContextualBackground.fromStyleName(getStyleName());
    }
}
