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

import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.base.AbstractAnchorListItem;

/**
 * A {@code <li>} list item that contains further widgets.
 * <p/>
 * Use it instead of a {@link ListItem} if you for example want to embed a
 * {@link Nav} within a {@code <li>}.
 *
 * @author Sven Jacobs
 * @see ListItem
 */
public class ListItemPanel extends AbstractAnchorListItem {

    @Override
    public void add(final Widget child) {
        add(child, getElement());
    }

    public void setText(final String text) {
        anchor.setText(text);
    }
}
