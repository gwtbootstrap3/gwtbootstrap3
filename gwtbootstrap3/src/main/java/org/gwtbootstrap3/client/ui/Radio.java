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

import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.impl.RadioImpl;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;

/**
 * A mutually-exclusive selection radio button widget. Fires
 * {@link com.google.gwt.event.dom.client.ClickEvent ClickEvents} when the radio
 * button is clicked, and {@link ValueChangeEvent ValueChangeEvents} when the
 * button becomes checked. Note, however, that browser limitations prevent
 * ValueChangeEvents from being sent when the radio button is cleared as a side
 * effect of another in the group being clicked.
 * 
 * <p>
 * <h3>Built-in Bidi Text Support</h3>
 * This widget is capable of automatically adjusting its direction according to
 * its content. This feature is controlled by {@link #setDirectionEstimator} or
 * passing a DirectionEstimator parameter to the constructor, and is off by
 * default.
 * </p>
 *
 * @author Sven Jacobs
 */
public class Radio extends CheckBox {

    private static final RadioImpl impl = GWT.create(RadioImpl.class);

    /**
     * Creates a new radio associated with a particular group, and initialized
     * with the given HTML label. All radio buttons associated with the same
     * group name belong to a mutually-exclusive set.
     * 
     * Radio buttons are grouped by their name attribute, so changing their name
     * using the setName() method will also change their associated group.
     * 
     * @param name
     *            the group name with which to associate the radio button
     * @param label
     *            this radio button's html label
     */
    public Radio(String name, SafeHtml label) {
        this(name, label.asString(), true);
    }

    /**
     * @see #RadioButton(String, SafeHtml)
     * 
     * @param name
     *            the group name with which to associate the radio button
     * @param label
     *            this radio button's html label
     * @param dir
     *            the text's direction. Note that {@code DEFAULT} means
     *            direction should be inherited from the widget's parent
     *            element.
     */
    public Radio(String name, SafeHtml label, Direction dir) {
        this(name);
        setHTML(label, dir);
    }

    /**
     * @see #RadioButton(String, SafeHtml)
     * 
     * @param name
     *            the group name with which to associate the radio button
     * @param label
     *            this radio button's html label
     * @param directionEstimator
     *            A DirectionEstimator object used for automatic direction
     *            adjustment. For convenience,
     *            {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
     */
    public Radio(String name, SafeHtml label, DirectionEstimator directionEstimator) {
        this(name);
        setDirectionEstimator(directionEstimator);
        setHTML(label.asString());
    }

    /**
     * Creates a new radio associated with a particular group, and initialized
     * with the given HTML label. All radio buttons associated with the same
     * group name belong to a mutually-exclusive set.
     * 
     * Radio buttons are grouped by their name attribute, so changing their name
     * using the setName() method will also change their associated group.
     * 
     * @param name
     *            the group name with which to associate the radio button
     * @param label
     *            this radio button's label
     */
    public Radio(String name, String label) {
        this(name);
        setText(label);
    }

    /**
     * @see #RadioButton(String, SafeHtml)
     * 
     * @param name
     *            the group name with which to associate the radio button
     * @param label
     *            this radio button's label
     * @param dir
     *            the text's direction. Note that {@code DEFAULT} means
     *            direction should be inherited from the widget's parent
     *            element.
     */
    public Radio(String name, String label, Direction dir) {
        this(name);
        setText(label, dir);
    }

    /**
     * @see #RadioButton(String, SafeHtml)
     * 
     * @param name
     *            the group name with which to associate the radio button
     * @param label
     *            this radio button's label
     * @param directionEstimator
     *            A DirectionEstimator object used for automatic direction
     *            adjustment. For convenience,
     *            {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
     */
    public Radio(String name, String label, DirectionEstimator directionEstimator) {
        this(name);
        setDirectionEstimator(directionEstimator);
        setText(label);
    }

    /**
     * Creates a new radio button associated with a particular group, and
     * initialized with the given label (optionally treated as HTML). All radio
     * buttons associated with the same group name belong to a
     * mutually-exclusive set.
     * 
     * Radio buttons are grouped by their name attribute, so changing their name
     * using the setName() method will also change their associated group.
     * 
     * @param name
     *            name the group with which to associate the radio button
     * @param label
     *            this radio button's label
     * @param asHTML
     *            <code>true</code> to treat the specified label as HTML
     */
    public Radio(String name, String label, boolean asHTML) {
        this(name);
        if (asHTML) {
            setHTML(label);
        } else {
            setText(label);
        }
    }

    /**
     * Creates a new radio associated with a particular group name. All radio
     * buttons associated with the same group name belong to a
     * mutually-exclusive set.
     * 
     * Radio buttons are grouped by their name attribute, so changing their name
     * using the setName() method will also change their associated group.
     * 
     * @param name
     *            the group name with which to associate the radio button
     */
    @UiConstructor
    public Radio(String name) {
        super(DOM.createDiv(), Document.get().createRadioInputElement(name));
        setStyleName(Styles.RADIO);

        LabelElement label = Document.get().createLabelElement();
        label.appendChild(inputElem);
        label.appendChild(labelElem);

        getElement().appendChild(label);
    }

    protected Radio(Element elem, InputElement inputElement) {
        super(elem, inputElement);
    }

    /**
     * Change the group name of this radio button.
     * 
     * Radio buttons are grouped by their name attribute, so changing their name
     * using the setName() method will also change their associated group.
     * 
     * If changing this group name results in a new radio group with multiple
     * radio buttons selected, this radio button will remain selected and the
     * other radio buttons will be unselected.
     * 
     * @param name
     *            name the group with which to associate the radio button
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    protected void ensureDomEventHandlers() {
        impl.ensureDomEventHandlers(this);
    }

    @Override
    public void sinkEvents(int eventBitsToAdd) {
        if (isOrWasAttached()) {
            impl.sinkEvents(eventBitsToAdd, inputElem, labelElem);
        } else {
            super.sinkEvents(eventBitsToAdd);
        }
    }

}
