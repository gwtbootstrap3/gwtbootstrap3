package org.gwtbootstrap3.client.ui.html;

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

import org.gwtbootstrap3.client.ui.ListItem;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;

/**
 * Widget representing an Unordered List
 * <p/>
 * ** Children must be of type ListItem
 * <p/>
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:UnorderedList>
 *    ... [ListItems]
 * </b:UnorderedList>
 * }
 * </pre>
 *
 * @author Joshua Godi
 * @see org.gwtbootstrap3.client.ui.ListItem
 */
public class UnorderedList extends ComplexWidget {

    /**
     * Creates an empty list.
     */
    public UnorderedList() {
        setElement(Document.get().createULElement());
    }

    /**
     * Creates a list and adds the given widgets.
     *
     * @param widgets widgets to be added
     */
    public UnorderedList(final ListItem... widgets) {
        this();

        // Add all the list items to the widget
        for (final ListItem li : widgets) {
            add(li);
        }
    }

    /**
     * Sets the UnorderedList to be unstyled
     *
     * @param unstyled boolean true/false to make unstyled
     */
    public void setUnstyled(final boolean unstyled) {
        setStyleName(Styles.UNSTYLED, unstyled);
    }

    /**
     * Returns a boolean of whether or not the UnorderedList is unstyled
     *
     * @return true/false for unstyled or not
     */
    public boolean isUnstyled() {
        return StyleHelper.containsStyle(Styles.UNSTYLED, getStyleName());
    }

    /**
     * Sets the UnorderedList to appear inline rather then stacked
     *
     * @param inline true/false for inline or not
     */
    public void setInline(final boolean inline) {
        StyleHelper.toggleStyleName(this, inline, Styles.LIST_INLINE);
    }

    /**
     * Returns a boolean of whether or not the UnorderedList in inline
     *
     * @return true/false for inline or not
     */
    public boolean isInline() {
        return StyleHelper.containsStyle(Styles.LIST_INLINE, getStyleName());
    }
}
