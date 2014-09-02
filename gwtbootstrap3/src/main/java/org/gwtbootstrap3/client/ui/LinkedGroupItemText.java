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
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.mixin.HTMLMixin;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class LinkedGroupItemText extends ComplexWidget implements HasWidgets, HasText {
    private final HTMLMixin<LinkedGroupItemText> textMixin = new HTMLMixin<LinkedGroupItemText>(this);

    public LinkedGroupItemText() {
        setElement(Document.get().createPElement());
        setStyleName(Styles.LIST_GROUP_ITEM_TEXT);
    }

    public LinkedGroupItemText(final String html) {
        this();
        setHTML(html);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getText() {
        return textMixin.getText();
    }

    public String getHTML() {
        return textMixin.getHTML();
    }

    public void setHTML(final String html) {
        textMixin.setHTML(html);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setText(final String text) {
        this.textMixin.setText(text);
    }


}
