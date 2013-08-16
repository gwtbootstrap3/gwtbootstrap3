package com.svenjacobs.gwtbootstrap3.client.ui.base.form;

import com.google.gwt.user.client.DOM;

/**
 * @author Sven Jacobs
 */
public abstract class AbstractForm extends FormElementContainer {

    public AbstractForm() {
        setElement(DOM.createForm());
    }
}
