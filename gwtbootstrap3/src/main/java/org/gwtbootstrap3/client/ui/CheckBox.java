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

import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasText;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * A checkbox with a label for use within a {@link Form}.
 * <p/>
 * Basically this is a non-styled {@link CheckBoxButton} encapsulated in a {@link Div}.
 *
 * @author Sven Jacobs
 */
public class CheckBox extends Div implements HasName, HasActive, HasText, HasIcon, HasIconPosition, HasIconSize {

    private final CheckBoxButton button;

    public CheckBox() {
        setStyleName(Styles.CHECKBOX);
        button = new CheckBoxButton();
        button.setStyleName("");
        add(button, getElement());
    }

    @Override
    public void setName(final String name) {
        button.setName(name);
    }

    @Override
    public String getName() {
        return button.getName();
    }

    @Override
    public void setActive(final boolean active) {
        button.setActive(active);
    }

    @Override
    public boolean isActive() {
        return button.isActive();
    }

    @Override
    public String getText() {
        return button.getText();
    }

    @Override
    public void setText(final String text) {
        button.setText(text);
    }

    @Override
    public void setIcon(final IconType iconType) {
        button.setIcon(iconType);
    }

    @Override
    public IconType getIcon() {
        return button.getIcon();
    }

    @Override
    public void setIconPosition(final IconPosition iconPosition) {
        button.setIconPosition(iconPosition);
    }

    @Override
    public IconPosition getIconPosition() {
        return button.getIconPosition();
    }

    @Override
    public void setIconSize(final IconSize iconSize) {
        button.setIconSize(iconSize);
    }

    @Override
    public IconSize getIconSize() {
        return button.getIconSize();
    }
}
