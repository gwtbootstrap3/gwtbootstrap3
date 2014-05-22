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

import com.google.gwt.dom.client.Element;
import org.gwtbootstrap3.client.ui.base.AbstractListItem;
import org.gwtbootstrap3.client.ui.html.Text;

/**
 * Represents a list item with text contents which is used in multiple widgets.
 * <h3>Widgets using ListItem</h3>
 * <ul>
 * <li>{@link DropDownMenu}</li>
 * <li>{@link NavTabs}</li>
 * <li>{@link NavPills}</li>
 * <li>{@link Navbar}</li>
 * </ul>
 *
 * @author Sven Jacobs
 * @see DropDownMenu
 * @see NavTabs
 * @see NavPills
 * @see Navbar
 */
public class ListItem extends AbstractListItem {
    private Text text;

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

    /**
     * Set the text for the list item
     *
     * @param text String text
     */
    public void setText(final String text) {
        this.text = new Text(text);
        add(this.text, (Element) getElement());
    }

    /**
     * Get the text of the list item
     *
     * @return text of the list item
     */
    public String getText() {
        return text.getText();
    }
}
