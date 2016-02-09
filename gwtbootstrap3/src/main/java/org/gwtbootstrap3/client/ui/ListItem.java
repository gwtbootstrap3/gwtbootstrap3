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

import org.gwtbootstrap3.client.ui.base.AbstractListItem;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Represents a list item with text contents
 *
 * @author Sven Jacobs
 * @see DropDownMenu
 * @see NavTabs
 * @see NavPills
 * @see Navbar
 */
public class ListItem extends AbstractListItem implements HasWidgets, HasText, HasClickHandlers {

    private Text text = null;

    /**
     * Creates a default list item element
     */
    public ListItem() {
    }

    /**
     * Creates a default list item element with the desired text
     *
     * @param text desired text for list item
     */
    public ListItem(final String text) {
        this();
        setText(text);
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public String getText() {
        return text.getText();
    }

    /** {@inheritDoc} */
    @Override
    protected void onAttach() {
        super.onAttach();
        // Adding styles to the list item depending on the parent
        if (getParent() != null) {
            if (getParent() instanceof MediaList) {
                addStyleName(Styles.MEDIA);
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setText(final String text) {
        if (this.text == null) {
            this.text = new Text(text);
            add(this.text);
        } else {
            this.text.setText(text);
        }
    }

}
