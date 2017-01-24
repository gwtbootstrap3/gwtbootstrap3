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

import org.gwtbootstrap3.client.ui.base.HasActive;
import org.gwtbootstrap3.client.ui.base.HasIcon;
import org.gwtbootstrap3.client.ui.base.HasIconPosition;
import org.gwtbootstrap3.client.ui.base.HasSize;
import org.gwtbootstrap3.client.ui.base.HasType;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.IconFlip;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconRotate;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;

/**
 * Button representing a checkbox used within a {@link ButtonGroup} that has
 * toggle set to {@code Toogle.BUTTONS}.
 * <p/>
 * If you are looking for a classic checkbox see {@link CheckBox}.
 *
 * @author Sven Jacobs
 */
public class CheckBoxButton extends CheckBox implements HasActive,
        HasType<ButtonType>, HasSize<ButtonSize>, HasIcon, HasIconPosition {

    private final ActiveMixin<CheckBoxButton> activeMixin = new ActiveMixin<CheckBoxButton>(this);

    private IconPosition iconPosition = IconPosition.LEFT;
    private Icon icon;

    /**
     * Creates a check box button with the specified text label.
     * 
     * @param label
     *            the check box's label
     */
    public CheckBoxButton(SafeHtml label) {
        this(label.asString(), true);
    }

    /**
     * Creates a check box button with the specified text label.
     * 
     * @param label
     *            the check box's label
     * @param dir
     *            the text's direction. Note that {@code DEFAULT} means
     *            direction should be inherited from the widget's parent
     *            element.
     */
    public CheckBoxButton(SafeHtml label, Direction dir) {
        this();
        setHTML(label, dir);
    }

    /**
     * Creates a check box button with the specified text label.
     * 
     * @param label
     *            the check box's label
     * @param directionEstimator
     *            A DirectionEstimator object used for automatic direction
     *            adjustment. For convenience,
     *            {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
     */
    public CheckBoxButton(SafeHtml label, DirectionEstimator directionEstimator) {
        this();
        setDirectionEstimator(directionEstimator);
        setHTML(label.asString());
    }

    /**
     * Creates a check box button with the specified text label.
     * 
     * @param label
     *            the check box's label
     */
    public CheckBoxButton(String label) {
        this();
        setText(label);
    }

    /**
     * Creates a check box button with the specified text label.
     * 
     * @param label
     *            the check box's label
     * @param dir
     *            the text's direction. Note that {@code DEFAULT} means
     *            direction should be inherited from the widget's parent
     *            element.
     */
    public CheckBoxButton(String label, Direction dir) {
        this();
        setText(label, dir);
    }

    /**
     * Creates a label with the specified text and a default direction
     * estimator.
     * 
     * @param label
     *            the check box's label
     * @param directionEstimator
     *            A DirectionEstimator object used for automatic direction
     *            adjustment. For convenience,
     *            {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
     */
    public CheckBoxButton(String label, DirectionEstimator directionEstimator) {
        this();
        setDirectionEstimator(directionEstimator);
        setText(label);
    }

    /**
     * Creates a check box button with the specified text label.
     * 
     * @param label
     *            the check box's label
     * @param asHTML
     *            <code>true</code> to treat the specified label as html
     */
    public CheckBoxButton(String label, boolean asHTML) {
        this();
        if (asHTML) {
            setHTML(label);
        } else {
            setText(label);
        }
    }

    public CheckBoxButton() {
        this(Document.get().createCheckInputElement());
    }

    protected CheckBoxButton(InputElement element) {
        super(DOM.createLabel(), element);

        setStyleName(Styles.BTN);
        setType(ButtonType.DEFAULT);

        getElement().appendChild(inputElem);
        getElement().appendChild(Document.get().createTextNode(" "));
        getElement().appendChild(labelElem);
        getElement().appendChild(Document.get().createTextNode(" "));
    }

    @Override
    protected void ensureDomEventHandlers() {
        // Use a ClickHandler since Bootstrap's jQuery does not trigger native
        // change events:
        // http://learn.jquery.com/events/triggering-event-handlers/
        addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                ValueChangeEvent.fire(CheckBoxButton.this, getValue());
            }

        });
    }

    @Override
    public void sinkEvents(int eventBitsToAdd) {
        // Sink on the actual element because that's what gets clicked
        if (isOrWasAttached()) {
            Event.sinkEvents(getElement(),
                    eventBitsToAdd | Event.getEventsSunk(getElement()));
        } else {
            super.sinkEvents(eventBitsToAdd);
        }
    }

    @Override
    public void setSize(ButtonSize size) {
        StyleHelper.addUniqueEnumStyleName(this, ButtonSize.class, size);
    }

    @Override
    public ButtonSize getSize() {
        return ButtonSize.fromStyleName(getStyleName());
    }

    @Override
    public void setType(ButtonType type) {
        StyleHelper.addUniqueEnumStyleName(this, ButtonType.class, type);
    }

    @Override
    public ButtonType getType() {
        return ButtonType.fromStyleName(getStyleName());
    }

    @Override
    public void setActive(boolean active) {
        setValue(active);
        activeMixin.setActive(active);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }

    @Override
    public void setIconPosition(IconPosition iconPosition) {
        this.iconPosition = iconPosition;
        render();
    }

    @Override
    public IconPosition getIconPosition() {
        return iconPosition;
    }

    @Override
    public void setIcon(IconType iconType) {
        getActualIcon().setType(iconType);
    }

    @Override
    public IconType getIcon() {
        return getActualIcon().getType();
    }

    @Override
    public void setIconSize(IconSize iconSize) {
        getActualIcon().setSize(iconSize);
    }

    @Override
    public IconSize getIconSize() {
        return getActualIcon().getSize();
    }

    @Override
    public void setIconFlip(IconFlip iconFlip) {
        getActualIcon().setFlip(iconFlip);
    }

    @Override
    public IconFlip getIconFlip() {
        return getActualIcon().getFlip();
    }

    @Override
    public void setIconRotate(IconRotate iconRotate) {
        getActualIcon().setRotate(iconRotate);
    }

    @Override
    public IconRotate getIconRotate() {
        return getActualIcon().getRotate();
    }

    @Override
    public void setIconBordered(boolean iconBordered) {
        getActualIcon().setBorder(iconBordered);
    }

    @Override
    public boolean isIconBordered() {
        return getActualIcon().isBorder();
    }

    /** {@inheritDoc} */
    @Override
    public void setIconInverse(final boolean iconInverse) {
        getActualIcon().setInverse(iconInverse);
    }

    /** {@inheritDoc} */
    @Override
    public boolean isIconInverse() {
        return getActualIcon().isInverse();
    }

    @Override
    public void setIconSpin(boolean iconSpin) {
        getActualIcon().setSpin(iconSpin);
    }

    @Override
    public boolean isIconSpin() {
        return getActualIcon().isSpin();
    }

    @Override
    public void setIconPulse(boolean iconPulse) {
        getActualIcon().setPulse(iconPulse);
    }

    @Override
    public boolean isIconPulse() {
        return getActualIcon().isPulse();
    }

    @Override
    public void setIconFixedWidth(boolean iconFixedWidth) {
        getActualIcon().setFixedWidth(iconFixedWidth);
    }

    @Override
    public boolean isIconFixedWidth() {
        return getActualIcon().isFixedWidth();
    }

    private Icon getActualIcon() {
        if (icon == null) {
            icon = new Icon();
            render();
        }
        return icon;
    }

    private void render() {
        if (iconPosition == IconPosition.LEFT) {
            getElement().insertAfter(icon.getElement(), inputElem);
        } else {
            getElement().insertAfter(icon.getElement(), null);
        }
    }
    
    @Override
	public void setIconColor(String iconColor) {
		getActualIcon().setColor(iconColor);
	}
}
