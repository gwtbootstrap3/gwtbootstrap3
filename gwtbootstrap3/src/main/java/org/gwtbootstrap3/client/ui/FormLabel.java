package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
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
import org.gwtbootstrap3.client.ui.constants.Attributes;
import org.gwtbootstrap3.client.ui.constants.ElementTags;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.DomEvent;

/**
 * @author Sven Jacobs
 * @author Steven Jardine
 */
public class FormLabel extends AbstractTextWidget {

    private Element iconElement = null;

    private boolean showRequiredIndicator = false;

    /**
     * Constructor.
     */
    public FormLabel() {
        super(Document.get().createLabelElement());
        setStyleName(Styles.CONTROL_LABEL);
        addHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                if (iconElement != null) {
                    iconElement.removeFromParent();
                }
                String html = getHTML();
                if (showRequiredIndicator && html != null && !"".equals(html)) {
                    iconElement = createIconElement();
                    getElement().appendChild(iconElement);
                }
            }
        }, ChangeEvent.getType());
    }

    /**
     * @return a new icon element. We only create this when {@link #iconElement} is null or the
     *         {@link #showRequiredIndicator} has changed.
     */
    protected Element createIconElement() {
        Element e = Document.get().createElement(ElementTags.I);
        e.addClassName(Styles.FONT_AWESOME_BASE);
        e.addClassName(IconType.STAR.getCssName());
        Style s = e.getStyle();
        s.setFontSize(6, Unit.PX);
        s.setPaddingLeft(2, Unit.PX);
        s.setPaddingRight(5, Unit.PX);
        s.setColor("#b94a48");
        Element sup = Document.get().createElement("sup");
        sup.appendChild(e);
        return sup;
    }

    /**
     * @return does this label show required?
     */
    public boolean getShowRequiredIndicator() {
        return showRequiredIndicator;
    }

    public void setFor(final String f) {
        if (f != null) {
            getElement().setAttribute(Attributes.FOR, f);
        } else {
            getElement().removeAttribute(Attributes.FOR);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setHTML(final String html) {
        super.setHTML(html);
        DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
    }

    /**
     * @param should this label show as required?
     */
    public void setShowRequiredIndicator(boolean required) {
        this.showRequiredIndicator = required;
        DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
    }

    /** {@inheritDoc} */
    @Override
    public void setText(String text) {
        super.setText(text);
        DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
    }

}
