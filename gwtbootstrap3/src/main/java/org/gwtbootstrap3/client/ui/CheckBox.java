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

import org.gwtbootstrap3.client.ui.base.HasFormValue;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.gwt.ButtonBase;
import org.gwtbootstrap3.client.ui.gwt.FormPanel;
import org.gwtbootstrap3.client.ui.gwt.Widget;
import org.gwtbootstrap3.client.ui.impl.CheckBoxImpl;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Style.WhiteSpace;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.i18n.shared.HasDirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.DirectionalTextHelper;
import com.google.gwt.user.client.ui.HasDirectionalSafeHtml;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWordWrap;
import com.google.gwt.user.client.ui.UIObject;

/**
 * A standard check box widget.
 * 
 * This class also serves as a base class for {@link Radio}.
 * 
 * <p>
 * <h3>Built-in Bidi Text Support</h3>
 * This widget is capable of automatically adjusting its direction according to
 * its content. This feature is controlled by {@link #setDirectionEstimator} or
 * passing a DirectionEstimator parameter to the constructor, and is off by
 * default.
 * </p>
 */
public class CheckBox extends ButtonBase implements HasName, HasValue<Boolean>, HasWordWrap, HasDirectionalSafeHtml,
        HasDirectionEstimator, IsEditor<LeafValueEditor<Boolean>>, HasFormValue, HasChangeHandlers {

    private static final CheckBoxImpl impl = GWT.create(CheckBoxImpl.class);

    protected final SpanElement labelElem = Document.get().createSpanElement();
    protected final InputElement inputElem;

    private final DirectionalTextHelper directionalTextHelper =
            new DirectionalTextHelper(labelElem, true);

    private LeafValueEditor<Boolean> editor;
    private boolean valueChangeHandlerInitialized;

    /**
     * Creates a check box with the specified text label.
     * 
     * @param label
     *            the check box's label
     */
    public CheckBox(SafeHtml label) {
        this(label.asString(), true);
    }

    /**
     * Creates a check box with the specified text label.
     * 
     * @param label
     *            the check box's label
     * @param dir
     *            the text's direction. Note that {@code DEFAULT} means
     *            direction should be inherited from the widget's parent
     *            element.
     */
    public CheckBox(SafeHtml label, Direction dir) {
        this();
        setHTML(label, dir);
    }

    /**
     * Creates a check box with the specified text label.
     * 
     * @param label
     *            the check box's label
     * @param directionEstimator
     *            A DirectionEstimator object used for automatic direction
     *            adjustment. For convenience,
     *            {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
     */
    public CheckBox(SafeHtml label, DirectionEstimator directionEstimator) {
        this();
        setDirectionEstimator(directionEstimator);
        setHTML(label.asString());
    }

    /**
     * Creates a check box with the specified text label.
     * 
     * @param label
     *            the check box's label
     */
    public CheckBox(String label) {
        this();
        setText(label);
    }

    /**
     * Creates a check box with the specified text label.
     * 
     * @param label
     *            the check box's label
     * @param dir
     *            the text's direction. Note that {@code DEFAULT} means
     *            direction should be inherited from the widget's parent
     *            element.
     */
    public CheckBox(String label, Direction dir) {
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
    public CheckBox(String label, DirectionEstimator directionEstimator) {
        this();
        setDirectionEstimator(directionEstimator);
        setText(label);
    }

    /**
     * Creates a check box with the specified text label.
     * 
     * @param label
     *            the check box's label
     * @param asHTML
     *            <code>true</code> to treat the specified label as html
     */
    public CheckBox(String label, boolean asHTML) {
        this();
        if (asHTML) {
            setHTML(label);
        } else {
            setText(label);
        }
    }

    public CheckBox() {
        this(DOM.createDiv(), Document.get().createCheckInputElement());
        setStyleName(Styles.CHECKBOX);

        LabelElement label = Document.get().createLabelElement();
        label.appendChild(inputElem);
        label.appendChild(labelElem);

        getElement().appendChild(label);
    }

    protected CheckBox(Element element, InputElement inputElement) {
        super(element);
        inputElem = inputElement;

        // Accessibility: setting tab index to be 0 by default, ensuring element
        // appears in tab sequence. FocusWidget's setElement method already
        // calls setTabIndex, which is overridden below. However, at the time
        // that this call is made, inputElem has not been created. So, we have
        // to call setTabIndex again, once inputElem has been created.
        setTabIndex(0);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
        // Is this the first value change handler? If so, time to add handlers
        if (!valueChangeHandlerInitialized) {
            ensureDomEventHandlers();
            valueChangeHandlerInitialized = true;
        }
        return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public HandlerRegistration addChangeHandler(ChangeHandler handler) {
        return addDomHandler(handler, ChangeEvent.getType());
    }

    @Override
    public LeafValueEditor<Boolean> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

    @Override
    public DirectionEstimator getDirectionEstimator() {
        return directionalTextHelper.getDirectionEstimator();
    }

    /**
     * Returns the value property of the input element that backs this widget.
     * This is the value that will be associated with the CheckBox name and
     * submitted to the server if a {@link FormPanel} that holds it is submitted
     * and the box is checked.
     * <p>
     * Don't confuse this with {@link #getValue}, which returns true or false if
     * the widget is checked.
     */
    @Override
    public String getFormValue() {
        return inputElem.getValue();
    }

    @Override
    public String getHTML() {
        return directionalTextHelper.getTextOrHtml(true);
    }

    @Override
    public String getName() {
        return inputElem.getName();
    }

    @Override
    public int getTabIndex() {
        return inputElem.getTabIndex();
    }

    @Override
    public String getText() {
        return directionalTextHelper.getTextOrHtml(false);
    }

    @Override
    public Direction getTextDirection() {
        return directionalTextHelper.getTextDirection();
    }

    /**
     * Determines whether this check box is currently checked.
     * <p>
     * Note that this <em>does not</em> return the value property of the
     * checkbox input element wrapped by this widget. For access to that
     * property, see {@link #getFormValue()}
     * 
     * @return <code>true</code> if the check box is checked, false otherwise.
     *         Will not return null
     */
    @Override
    public Boolean getValue() {
        if (isAttached()) {
            return inputElem.isChecked();
        } else {
            return inputElem.isDefaultChecked();
        }
    }

    @Override
    public boolean getWordWrap() {
        return !WhiteSpace.NOWRAP.getCssName().equals(getElement().getStyle().getWhiteSpace());
    }

    @Override
    public boolean isEnabled() {
        return !inputElem.isDisabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        inputElem.setDisabled(!enabled);
        if (enabled) {
            removeStyleName(Styles.DISABLED);
        } else {
            addStyleName(Styles.DISABLED);
        }
    }

    @Override
    public void setAccessKey(char key) {
        inputElem.setAccessKey("" + key);
    }

    /**
     * {@inheritDoc}
     * <p>
     * See note at {@link #setDirectionEstimator(DirectionEstimator)}.
     */
    @Override
    public void setDirectionEstimator(boolean enabled) {
        directionalTextHelper.setDirectionEstimator(enabled);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Note: DirectionEstimator should be set before the label has any content;
     * it's highly recommended to set it using a constructor. Reason: if the
     * label already has non-empty content, this will update its direction
     * according to the new estimator's result. This may cause flicker, and thus
     * should be avoided.
     */
    @Override
    public void setDirectionEstimator(DirectionEstimator directionEstimator) {
        directionalTextHelper.setDirectionEstimator(directionEstimator);
    }

    @Override
    public void setFocus(boolean focused) {
        if (focused) {
            inputElem.focus();
        } else {
            inputElem.blur();
        }
    }

    /**
     * Set the value property on the input element that backs this widget. This
     * is the value that will be associated with the CheckBox's name and
     * submitted to the server if a {@link FormPanel} that holds it is submitted
     * and the box is checked.
     * <p>
     * Don't confuse this with {@link #setValue}, which actually checks and
     * unchecks the box.
     * 
     * @param value
     */
    @Override
    public void setFormValue(String value) {
        inputElem.setValue(value);
    }

    @Override
    public void setHTML(SafeHtml html, Direction dir) {
        directionalTextHelper.setTextOrHtml(html.asString(), dir, true);
    }

    @Override
    public void setHTML(String html) {
        directionalTextHelper.setTextOrHtml(html, true);
    }

    @Override
    public void setName(String name) {
        inputElem.setName(name);
    }

    @Override
    public void setTabIndex(int index) {
        // Need to guard against call to setTabIndex before inputElem is
        // initialized. This happens because FocusWidget's (a superclass of
        // CheckBox) setElement method calls setTabIndex before inputElem is
        // initialized. See CheckBox's protected constructor for more
        // information.
        if (inputElem != null) {
            inputElem.setTabIndex(index);
        }
    }

    @Override
    public void setText(String text) {
        directionalTextHelper.setTextOrHtml(text, false);
    }

    @Override
    public void setText(String text, Direction dir) {
        directionalTextHelper.setTextOrHtml(text, dir, false);
    }

    /**
     * Checks or unchecks the check box.
     * <p>
     * Note that this <em>does not</em> set the value property of the checkbox
     * input element wrapped by this widget. For access to that property, see
     * {@link #setFormValue(String)}
     * 
     * @param value
     *            true to check, false to uncheck; null value implies false
     */
    @Override
    public void setValue(Boolean value) {
        setValue(value, false);
    }

    /**
     * Checks or unchecks the check box, firing {@link ValueChangeEvent} if
     * appropriate.
     * <p>
     * Note that this <em>does not</em> set the value property of the checkbox
     * input element wrapped by this widget. For access to that property, see
     * {@link #setFormValue(String)}
     * 
     * @param value
     *            true to check, false to uncheck; null value implies false
     * @param fireEvents
     *            If true, and value has changed, fire a
     *            {@link ValueChangeEvent}
     */
    @Override
    public void setValue(Boolean value, boolean fireEvents) {
        if (value == null) {
            value = Boolean.FALSE;
        }

        Boolean oldValue = getValue();
        inputElem.setChecked(value);
        inputElem.setDefaultChecked(value);
        if (value.equals(oldValue)) {
            return;
        }
        if (fireEvents) {
            ValueChangeEvent.fire(this, value);
        }
    }

    @Override
    public void setWordWrap(boolean wrap) {
        getElement().getStyle().setWhiteSpace(wrap ? WhiteSpace.NORMAL : WhiteSpace.NOWRAP);
    }

    // Unlike other widgets the CheckBox sinks on its inputElement, not
    // its wrapper
    @Override
    public void sinkEvents(int eventBitsToAdd) {
        if (isOrWasAttached()) {
            Event.sinkEvents(inputElem, eventBitsToAdd | Event.getEventsSunk(inputElem));
        } else {
            super.sinkEvents(eventBitsToAdd);
        }
    }

    protected void ensureDomEventHandlers() {
        impl.ensureDomEventHandlers(this);
    }

    /**
     * <b>Affected Elements:</b>
     * <ul>
     * <li>-input = checkbox.</li>
     * </ul>
     * 
     * @see UIObject#onEnsureDebugId(String)
     */
    @Override
    protected void onEnsureDebugId(String baseID) {
        super.onEnsureDebugId(baseID);
        ensureDebugId(inputElem, baseID, "input");
    }

    /**
     * This method is called when a widget is attached to the browser's
     * document. onAttach needs special handling for the CheckBox case. Must
     * still call {@link Widget#onAttach()} to preserve the
     * <code>onAttach</code> contract.
     */
    @Override
    protected void onLoad() {
        DOM.setEventListener(inputElem, this);
    }

    /**
     * This method is called when a widget is detached from the browser's
     * document. Overridden because of IE bug that throws away checked state and
     * in order to clear the event listener off of the <code>inputElem</code>.
     */
    @Override
    protected void onUnload() {
        // Clear out the inputElem's event listener (breaking the circular
        // reference between it and the widget).
        DOM.setEventListener(inputElem, null);
        setValue(getValue());
    }

}
