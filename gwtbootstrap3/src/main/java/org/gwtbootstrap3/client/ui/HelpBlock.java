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
 * http://www.apache.org/licenses/LICENSE-2.0
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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.DomEvent;

/**
 * Help block. Call {@link #setError(String)} to set ther error state of this
 * {@link HelpBlock}.
 * 
 * @author Joshua Godi
 * @author Steven Jardine
 */
public class HelpBlock extends AbstractTextWidget {

    private boolean error = false;

    private Element iconElement = null;

    private IconType iconType = null;

    /**
     * Constructor.
     */
    public HelpBlock() {
        super(Document.get().createSpanElement());
        setStyleName(Styles.HELP_BLOCK);
        addHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                if (iconElement != null) {
                    iconElement.removeFromParent();
                }
                if (error && iconType != null) {
                    iconElement = createIconElement();
                    getElement().insertFirst(iconElement);
                }
            }
        }, ChangeEvent.getType());
    }

    /**
     * Clear the error state of this help block.
     */
    public void clearError() {
        error = false;
        setText("");
    }

    /**
     * @return a new icon element. We only create this when {@link #iconElement}
     *         is null or the {@link #iconType} has changed.
     */
    protected Element createIconElement() {
        Element e = Document.get().createElement(ElementTags.I);
        e.addClassName(Styles.FONT_AWESOME_BASE);
        e.addClassName(iconType.getCssName());
        e.getStyle().setPaddingRight(5, Unit.PX);
        return e;
    }

    /**
     * @return the icon type
     */
    public IconType getIconType() {
        return iconType;
    }

    /**
     * Checks if this block is in the error state.
     *
     * @return true, if is error
     */
    public boolean isError() {
        return error;
    }

    /**
     * Set this {@link HelpBlock}'s error state.
     * 
     * @param message
     *            the error message.
     */
    public void setError(String message) {
        error = true;
        setText(message);
    }

    /** {@inheritDoc} */
    @Override
    public void setHTML(String value) {
        String oldValue = getHTML();
        if (!oldValue.equals(value)) {
            super.setHTML(value);
            DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
        }
    }

    /**
     * Sets the icon type. If the icon type changes programatically then the
     * icon is removed from the dom and recreated.
     *
     * @param type
     *            the new icon type
     */
    public void setIconType(IconType type) {
        IconType prevType = iconType;
        iconType = type;
        if (iconType != prevType && iconElement != null) {
            iconElement.removeFromParent();
            iconElement = null;
            DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setText(String value) {
        String oldValue = getText();
        if (!oldValue.equals(value)) {
            super.setText(value);
            DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
        }
    }

}
