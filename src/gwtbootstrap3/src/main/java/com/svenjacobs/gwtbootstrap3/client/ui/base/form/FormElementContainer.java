package com.svenjacobs.gwtbootstrap3.client.ui.base.form;

import com.google.gwt.user.client.ui.*;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Base class for {@link com.svenjacobs.gwtbootstrap3.client.ui.Form} related widgets that may contain form input
 * elements.
 * <p/>
 * Input elements styleName is adjusted during {@link #add(com.google.gwt.user.client.ui.Widget)}.
 *
 * @author Sven Jacobs
 */
public abstract class FormElementContainer extends ComplexPanel {

    @Override
    public void add(final Widget w) {

        if (w instanceof TextBoxBase || w instanceof SimpleCheckBox || w instanceof CheckBox || w instanceof ListBox ||
                w instanceof FileUpload) {

            w.addStyleName(Styles.FORM_CONTROL);
        }

        add(w, getElement());
    }
}
