package org.gwtbootstrap3.client.ui.base.button;

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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.base.*;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap3.client.ui.base.mixin.DataTargetMixin;
import org.gwtbootstrap3.client.ui.base.mixin.FocusableMixin;
import org.gwtbootstrap3.client.ui.constants.*;

import java.util.List;

/**
 * Abstract base class for different kinds of buttons.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 */
public abstract class AbstractButton extends ComplexWidget implements HasEnabled, HasActive, HasType<ButtonType>,
        HasSize<ButtonSize>, HasDataTarget, HasClickHandlers, HasTargetHistoryToken, HasHref, Focusable, HasAllMouseHandlers {

    public class ButtonStateHandler {
        private ButtonStateHandler() {
        }

        public void loading() {
            button(getElement(), "loading");
        }

        public void reset() {
            button(getElement(), "reset");
        }

        /**
         * Resets button to specified text state.
         *
         * @param state Text state
         */
        public void reset(final String state) {
            button(getElement(), state);
        }
    }

    private final ButtonStateHandler buttonStateHandler = new ButtonStateHandler();
    private final DataTargetMixin<AbstractButton> targetMixin = new DataTargetMixin<AbstractButton>(this);
    private final ActiveMixin<AbstractButton> activeMixin = new ActiveMixin<AbstractButton>(this);
    private final FocusableMixin<AbstractButton> focusableMixin = new FocusableMixin<AbstractButton>(this);

    private String targetHistoryToken;

    /**
     * Creates button with DEFAULT type.
     */
    protected AbstractButton() {
        this(ButtonType.DEFAULT);
    }

    protected AbstractButton(final ButtonType type) {
        setElement(createElement());
        setStyleName(Styles.BTN);
        setType(type);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }

    @Override
    public void setActive(final boolean active) {
        activeMixin.setActive(active);
    }

    @Override
    public void setEnabled(final boolean enabled) {
        getElement().setPropertyBoolean("disabled", !enabled);
    }

    @Override
    public boolean isEnabled() {
        return !getElement().getPropertyBoolean("disabled");
    }

    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }

    /**
     * Sets type of button.
     *
     * @param type Type of button
     */
    @Override
    public void setType(final ButtonType type) {
        StyleHelper.addUniqueEnumStyleName(this, ButtonType.class, type);
    }

    @Override
    public ButtonType getType() {
        return ButtonType.fromStyleName(getStyleName());
    }

    /**
     * Sets size of button.
     *
     * @param size Size of button
     */
    @Override
    public void setSize(final ButtonSize size) {
        StyleHelper.addUniqueEnumStyleName(this, ButtonSize.class, size);
    }

    @Override
    public ButtonSize getSize() {
        return ButtonSize.fromStyleName(getStyleName());
    }

    @Override
    public void setDataTargetWidgets(final List<Widget> widgets) {
        targetMixin.setDataTargetWidgets(widgets);
    }

    @Override
    public void setDataTargetWidget(final Widget widget) {
        targetMixin.setDataTargetWidget(widget);
    }

    @Override
    public void setDataTarget(final String dataTarget) {
        targetMixin.setDataTarget(dataTarget);
    }

    @Override
    public String getDataTarget() {
        return targetMixin.getDataTarget();
    }

    @Override
    public void setTargetHistoryToken(final String targetHistoryToken) {
        this.targetHistoryToken = targetHistoryToken;
        final String hash = History.encodeHistoryToken(targetHistoryToken);
        setHref("#" + hash);
    }

    @Override
    public String getTargetHistoryToken() {
        return targetHistoryToken;
    }

    @Override
    public void setHref(final String href) {
        getElement().setAttribute(HREF, href);
    }

    @Override
    public String getHref() {
        return getElement().getAttribute(HREF);
    }

    @Override
    public int getTabIndex() {
        return focusableMixin.getTabIndex();
    }

    @Override
    public void setAccessKey(final char key) {
        focusableMixin.setAccessKey(key);
    }

    @Override
    public void setFocus(final boolean focused) {
        focusableMixin.setFocus(focused);
    }

    @Override
    public void setTabIndex(final int index) {
        focusableMixin.setTabIndex(index);
    }

    @Override
    public HandlerRegistration addMouseDownHandler(final MouseDownHandler handler) {
        return addDomHandler(handler, MouseDownEvent.getType());
    }

    @Override
    public HandlerRegistration addMouseMoveHandler(final MouseMoveHandler handler) {
        return addDomHandler(handler, MouseMoveEvent.getType());
    }

    @Override
    public HandlerRegistration addMouseOutHandler(final MouseOutHandler handler) {
        return addDomHandler(handler, MouseOutEvent.getType());
    }

    @Override
    public HandlerRegistration addMouseOverHandler(final MouseOverHandler handler) {
        return addDomHandler(handler, MouseOverEvent.getType());
    }

    @Override
    public HandlerRegistration addMouseUpHandler(final MouseUpHandler handler) {
        return addDomHandler(handler, MouseUpEvent.getType());
    }

    @Override
    public HandlerRegistration addMouseWheelHandler(final MouseWheelHandler handler) {
        return addDomHandler(handler, MouseWheelEvent.getType());
    }

    /**
     * Makes button a block level element that spawns full width of parent.
     *
     * @param block True for block level element
     */
    public void setBlock(final boolean block) {
        if (block) {
            addStyleName(Styles.BTN_BLOCK);
        } else {
            removeStyleName(Styles.BTN_BLOCK);
        }
    }

    /**
     * Sets dismiss type of button.
     * <p/>
     * If button is inside a
     * {@link org.gwtbootstrap3.client.ui.Modal} and dismiss type is
     * {@code MODAL} the button will act as the dismiss (close) button for this
     * Modal. Same goes for {@link org.gwtbootstrap3.client.ui.Alert}
     * and dismiss type {@code ALERT}.
     *
     * @param dismiss Dismiss type of button
     * @see org.gwtbootstrap3.client.ui.Modal
     * @see org.gwtbootstrap3.client.ui.Alert
     */
    public void setDataDismiss(final ButtonDismiss dismiss) {
        if (dismiss != null) {
            getElement().setAttribute(Attributes.DATA_DISMISS, dismiss.getDismiss());
        } else {
            getElement().removeAttribute(Attributes.DATA_DISMISS);
        }
    }

    public void setDataLoadingText(final String loadingText) {
        if (loadingText != null) {
            getElement().setAttribute(Attributes.DATA_LOADING_TEXT, loadingText);
        } else {
            getElement().removeAttribute(Attributes.DATA_LOADING_TEXT);
        }
    }

    public void toggle() {
        button(getElement(), "toggle");
    }

    public ButtonStateHandler state() {
        return buttonStateHandler;
    }

    public void click() {
        final NativeEvent event = Document.get().createClickEvent(0, 0, 0, 0, 0, false, false, false, false);
        DomEvent.fireNativeEvent(event, this);
    }

    protected abstract Element createElement();

    // @formatter:off

    private native void button(final Element e, final String arg) /*-{
        $wnd.jQuery(e).button(arg);
    }-*/;
}
