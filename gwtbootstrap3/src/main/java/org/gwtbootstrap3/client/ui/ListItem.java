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

import com.google.gwt.user.client.ui.HasText;
import org.gwtbootstrap3.client.ui.base.AbstractAnchorListItem;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;

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
public class ListItem extends AbstractAnchorListItem implements HasText, HasIcon, HasIconSize, HasIconPosition {

    public ListItem() {
    }

    @Override
    public void setText(final String text) {
        anchor.setText(text);
    }

    @Override
    public String getText() {
        return anchor.getText();
    }

    @Override
    public void setIcon(final IconType iconType) {
        anchor.setIcon(iconType);
    }

    @Override
    public IconType getIcon() {
        return anchor.getIcon();
    }

    @Override
    public void setIconPosition(final IconPosition iconPosition) {
        anchor.setIconPosition(iconPosition);
    }

    @Override
    public IconPosition getIconPosition() {
        return anchor.getIconPosition();
    }

    @Override
    public void setIconSize(IconSize iconSize) {
        anchor.setIconSize(iconSize);
    }

    @Override
    public IconSize getIconSize() {
        return anchor.getIconSize();
    }
}
