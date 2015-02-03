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

import org.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap3.client.ui.constants.ElementTags;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;

/**
 * @author Joshua Godi
 * @author Steven Jardine
 */
public class HelpBlock extends AbstractTextWidget {

    private IconType iconType = null;

    public HelpBlock() {
        super(Document.get().createSpanElement());
        setStyleName(Styles.HELP_BLOCK);
    }

    /**
     * Sets the icon type.
     *
     * @param type the new icon type
     */
    public void setIconType(IconType type) {
        iconType = type;
    }

    /**
     * Gets the icon type.
     *
     * @return the icon type
     */
    public IconType getIconType() {
        return iconType;
    }

    /** {@inheritDoc} */
    @Override
    public void setText(String text) {
        super.setText(text);
        if (iconType != null && text != null && !text.equals("")) {
            Element e = Document.get().createElement(ElementTags.I);
            e.addClassName(Styles.FONT_AWESOME_BASE);
            e.addClassName(iconType.getCssName());
            e.getStyle().setPaddingRight(5, Unit.PX);
            getElement().insertFirst(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public String getText() {
        return super.getText();
    }

}
