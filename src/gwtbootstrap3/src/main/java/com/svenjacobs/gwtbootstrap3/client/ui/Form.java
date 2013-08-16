package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.base.form.AbstractForm;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.FormType;

/**
 * A form.
 *
 * @author Sven Jacobs
 * @see FormGroup
 * @see FormLabel
 * @see FormStatic
 * @see Legend
 */
public class Form extends AbstractForm implements HasType<FormType> {

    @Override
    public void setType(final FormType type) {
        StyleHelper.addUniqueEnumStyleName(this, FormType.class, type);
    }

    @Override
    public FormType getType() {
        return FormType.fromStyleName(getStyleName());
    }
}
