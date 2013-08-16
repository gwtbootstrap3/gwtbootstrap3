package com.svenjacobs.gwtbootstrap3.client.ui.base.button;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HasText;
import com.svenjacobs.gwtbootstrap3.client.ui.HasActive;
import com.svenjacobs.gwtbootstrap3.client.ui.InputButton;
import com.svenjacobs.gwtbootstrap3.client.ui.base.Text;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ButtonType;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.TypeAttrType;

/**
 * Base class for {@link com.svenjacobs.gwtbootstrap3.client.ui.CheckBoxButton} and
 * {@link com.svenjacobs.gwtbootstrap3.client.ui.RadioButton} which are encapsulated {@code <input>} elements within
 * {@code <label>}.
 *
 * @author Sven Jacobs
 */
public abstract class AbstractLabelButton extends AbstractButton implements HasText, HasActive {

    private final ActiveMixin activeMixin = new ActiveMixin(this);
    private final InputButton input;
    private final Text text;

    protected AbstractLabelButton(final TypeAttrType typeAttr) {
        super(ButtonType.DEFAULT);

        input = new InputButton(typeAttr);
        text = new Text();

        input.setStyleName("");

        add(input, getElement());
        add(text, getElement());
    }

    @Override
    public void setText(final String txt) {
        text.setText(txt);
    }

    @Override
    public String getText() {
        return text.getText();
    }

    @Override
    public void setEnabled(final boolean enabled) {
        if (enabled) {
            removeStyleName(Styles.DISABLED);
        } else {
            addStyleName(Styles.DISABLED);
        }

        input.setEnabled(enabled);
    }

    @Override
    public boolean isEnabled() {
        return input.isEnabled();
    }

    @Override
    public void setActive(final boolean active) {
        activeMixin.setActive(active);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }

    @Override
    protected Element createElement() {
        return DOM.createLabel();
    }
}
