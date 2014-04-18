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

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.base.mixin.HTMLMixin;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class PanelHeader extends HTMLPanel implements HasHTML {
    private final HTMLMixin<PanelHeader> textMixin = new HTMLMixin<PanelHeader>(this);

    public PanelHeader() {
        super(DivElement.TAG, "");
        setStyleName(Styles.PANEL_HEADING);
    }

    public PanelHeader(final String html) {
        this();
        setHTML(html);
    }

    @Override
    public void addAndReplaceElement(final IsWidget widget, final Element toReplace) {
        if ((widget instanceof Heading) || (widget instanceof HeadingPanel)) {
            widget.asWidget().setStyleName(Styles.PANEL_TITLE);
        }

        super.addAndReplaceElement(widget, toReplace);
    }

    @Override
    @Deprecated
    public void addAndReplaceElement(final Widget widget, final com.google.gwt.user.client.Element toReplace) {
        if ((widget instanceof Heading) || (widget instanceof HeadingPanel)) {
            widget.setStyleName(Styles.PANEL_TITLE);
        }
        super.addAndReplaceElement(widget, toReplace);
    }

    @Override
    public void setText(final String text) {
        textMixin.setText(text);
    }

    @Override
    public String getText() {
        return textMixin.getText();
    }

    @Override
    public String getHTML() {
        return textMixin.getHTML();
    }

    @Override
    public void setHTML(final String html) {
        textMixin.setHTML(html);
    }
}
