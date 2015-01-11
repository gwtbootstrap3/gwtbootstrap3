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
import org.gwtbootstrap3.client.ui.base.HasSize;
import org.gwtbootstrap3.client.ui.base.HasType;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;

/**
 * Button representing a checkbox used within a {@link ButtonGroup} that has
 * toggle set to {@code Toogle.BUTTONS}.
 * <p/>
 * If you are looking for a classic checkbox see {@link CheckBox}.
 *
 * @author Sven Jacobs
 */
public class CheckBoxButton extends CheckBox implements HasActive, HasType<ButtonType>, HasSize<ButtonSize> {

    private final ActiveMixin<CheckBoxButton> activeMixin = new ActiveMixin<CheckBoxButton>(this);

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
        getElement().appendChild(labelElem);
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

}
