package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 */
public class TextBox extends com.google.gwt.user.client.ui.TextBox implements HasId {

    private final IdMixin idMixin = new IdMixin(this);

    public TextBox() {
        super(DOM.createInputText());
        setStyleName(Styles.FORM_CONTROL);
    }

    public void setPlaceHolder(final String placeHolder) {
        getElement().setAttribute("placeholder", placeHolder != null ? placeHolder : "");
    }

    public void setAutoComplete(final boolean autoComplete) {
        getElement().setAttribute("autocomplete", autoComplete ? "on" : "off");
    }

    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }
}
