package com.svenjacobs.gwtbootstrap3.client.ui.base.button;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasEnabled;
import com.svenjacobs.gwtbootstrap3.client.ui.HasSize;
import com.svenjacobs.gwtbootstrap3.client.ui.HasTarget;
import com.svenjacobs.gwtbootstrap3.client.ui.HasType;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.TargetMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.*;

/**
 * Abstract base class for different kinds of buttons.
 *
 * @author Sven Jacobs
 */
public abstract class AbstractButton extends ComplexPanel
        implements HasEnabled, HasType<ButtonType>, HasSize<ButtonSize>, HasTarget, HasClickHandlers {

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
    private final TargetMixin targetMixin = new TargetMixin(this);

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
    public void setTarget(final String target) {
        targetMixin.setTarget(target);
    }

    @Override
    public String getTarget() {
        return targetMixin.getTarget();
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
     * If button is inside a {@link com.svenjacobs.gwtbootstrap3.client.ui.Modal} and dismiss type is {@code MODAL}
     * the button will act as the dismiss (close) button for this Modal. Same goes for
     * {@link com.svenjacobs.gwtbootstrap3.client.ui.Alert} and dismiss type {@code ALERT}.
     *
     * @param dismiss Dismiss type of button
     * @see com.svenjacobs.gwtbootstrap3.client.ui.Modal
     * @see com.svenjacobs.gwtbootstrap3.client.ui.Alert
     */
    public void setDismiss(final ButtonDismiss dismiss) {
        if (dismiss != null) {
            getElement().setAttribute(Attributes.DATA_DISMISS, dismiss.getDismiss());
        } else {
            getElement().removeAttribute(Attributes.DATA_DISMISS);
        }
    }

    public void setLoadingText(final String loadingText) {
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

    protected abstract Element createElement();

    private native void button(final Element e, final String arg) /*-{
        $wnd.jQuery(e).button(arg);
    }-*/;
}
