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
import org.gwtbootstrap3.client.ui.base.mixin.HTMLMixin;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * @author Joshua Godi
 */
public class LinkedGroupItemText extends ComplexWidget implements HasWidgets, HasText {
    private final HTMLMixin<LinkedGroupItemText> htmlMixin = new HTMLMixin<LinkedGroupItemText>(this);

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
        return htmlMixin.getText();
    }

    public String getHTML() {
        return htmlMixin.getHTML();
    }

    public void setHTML(final String html) {
        htmlMixin.setHTML(html);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setText(final String text) {
        this.htmlMixin.setText(text);
    }


}
