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

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasText;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.Emphasis;

/**
 * @author Sven Jacobs
 */
public class Heading extends ComplexWidget implements HasEmphasis, HasText {
    private final Small subtext = new Small();
    private final Text text = new Text();
    private final Text spacer = new Text(" ");

    @UiConstructor
    public Heading(final int size) {
        setElement(DOM.createElement("h" + size));
        assert size > 0 && size < 7 : "Wrong heading size (must be between 1 and 6)";
        add(text);
        add(spacer);
        add(subtext);
    }

    public Heading(final int size, final String text) {
        this(size);
        setText(text);
    }

    public void setSubtext(final String subtext) {
        this.subtext.setText(subtext);
    }

    @Override
    public void setEmphasis(Emphasis emphasis) {
        StyleHelper.addUniqueEnumStyleName(this, Emphasis.class, emphasis);
    }

    @Override
    public Emphasis getEmphasis() {
        return Emphasis.fromStyleName(getStyleName());
    }

    @Override
    public String getText() {
        return text.getText();
    }

    @Override
    public void setText(String text) {
        this.text.setText(text);
    }
}
