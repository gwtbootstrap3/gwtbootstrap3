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
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import org.gwtbootstrap3.client.ui.base.HasActive;
import org.gwtbootstrap3.client.ui.base.HasFormValue;
import org.gwtbootstrap3.client.ui.base.HasIcon;
import org.gwtbootstrap3.client.ui.base.HasIconPosition;
import org.gwtbootstrap3.client.ui.constants.*;
import org.gwtbootstrap3.client.ui.html.Div;

/**
 * A checkbox with a label for use within a {@link Form}.
 *
 * Basically this is a non-styled {@link CheckBoxButton} encapsulated in a {@link org.gwtbootstrap3.client.ui.html.Div}.
 *
 * @author Sven Jacobs
 */
public class CheckBox extends Div implements HasName, HasEnabled, HasActive, HasText, HasIcon, HasIconPosition,
        HasClickHandlers, HasFormValue, HasValue<Boolean>, IsEditor<LeafValueEditor<Boolean>> {

    private final CheckBoxButton button = new CheckBoxButton();
    private LeafValueEditor<Boolean> editor;
    
    /**
     * Creates a check box with the specified text label.
     * 
     * @param label the check box's label
     */
    public CheckBox(String label) {
		this();
		setText(label);
    }

    public CheckBox() {
        setStyleName(Styles.CHECKBOX);
        button.setStyleName("");
        add(button, (Element) getElement());
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
    public boolean isEnabled() {
        return button.isEnabled();
    }

    @Override
    public void setEnabled(final boolean enabled) {
        button.setEnabled(enabled);
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

    @Override
    public void setIconFlip(final IconFlip iconFlip) {
        button.setIconFlip(iconFlip);
    }

    @Override
    public IconFlip getIconFlip() {
        return button.getIconFlip();
    }

    @Override
    public void setIconRotate(final IconRotate iconRotate) {
        button.setIconRotate(iconRotate);
    }

    @Override
    public IconRotate getIconRotate() {
        return button.getIconRotate();
    }

    @Override
    public void setIconBordered(final boolean iconBordered) {
        button.setIconBordered(iconBordered);
    }

    @Override
    public boolean isIconBordered() {
        return button.isIconBordered();
    }

    @Override
    public void setIconMuted(final boolean iconMuted) {
        button.setIconMuted(iconMuted);
    }

    @Override
    public boolean isIconMuted() {
        return button.isIconMuted();
    }

    @Override
    public void setIconLight(final boolean iconLight) {
        button.setIconLight(iconLight);
    }

    @Override
    public boolean isIconLight() {
        return button.isIconLight();
    }

    @Override
    public void setIconSpin(final boolean iconSpin) {
        button.setIconSpin(iconSpin);
    }

    @Override
    public boolean isIconSpin() {
        return button.isIconSpin();
    }

    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
        return button.addClickHandler(handler);
    }

    @Override
    public String getFormValue() {
        return button.getFormValue();
    }

    @Override
    public void setFormValue(final String value) {
        button.setFormValue(value);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Boolean> handler) {
        return button.addValueChangeHandler(handler);
    }

    @Override
    public Boolean getValue() {
        return button.getValue();
    }

    @Override
    public void setValue(final Boolean value) {
        button.setValue(value);
    }

    @Override
    public void setValue(final Boolean value, final boolean fireEvents) {
        button.setValue(value, fireEvents);
    }

    @Override
    public LeafValueEditor<Boolean> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

}
