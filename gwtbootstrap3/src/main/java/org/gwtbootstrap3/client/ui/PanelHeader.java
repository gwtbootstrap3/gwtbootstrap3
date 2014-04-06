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

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.base.mixin.TextMixin;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class PanelHeader extends Div implements HasId, HasWidgets, HasText {
    private final TextMixin<PanelHeader> textMixin = new TextMixin<PanelHeader>(this);

    public PanelHeader() {
        setStyleName(Styles.PANEL_HEADING);
    }

    @Override
    public void add(final Widget child) {
        if ((child instanceof Heading) || (child instanceof HeadingPanel)) {
            child.setStyleName(Styles.PANEL_TITLE);
        }

        // If we are adding a child, then we don't need the inner text of the
        // div
        setText("");

        super.add(child);
    }

    @Override
    public String getText() {
        return textMixin.getText();
    }

    @Override
    public void setText(final String text) {
        // Only want text to be available if the widget count is 0!
        // This is a safety net for if people use setText and add a Heading!
        if (getWidgetCount() == 0) {
            textMixin.setText(text);
        }
    }
}
