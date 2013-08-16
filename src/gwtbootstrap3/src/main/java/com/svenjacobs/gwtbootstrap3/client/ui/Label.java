package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.LabelType;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Bootstrap's label, see <a href="http://getbootstrap.com/components/#labels">documentation</a>.
 * <p/>
 * Not to be confused with {@code <label>} (see {@link FormLabel}) or GWT's {@link com.google.gwt.user.client.ui.Label}
 *
 * @author Sven Jacobs
 * @see FormLabel
 */
public class Label extends AbstractTextWidget implements HasType<LabelType> {

    public Label() {
        this(LabelType.DEFAULT);
    }

    public Label(final LabelType type) {
        super(DOM.createSpan());
        setStyleName(Styles.LABEL);
        setType(type);
    }

    /**
     * Sets type of label.
     *
     * @param type Type of label
     */
    @Override
    public void setType(final LabelType type) {
        StyleHelper.addUniqueEnumStyleName(this, LabelType.class, type);
    }

    @Override
    public LabelType getType() {
        return LabelType.fromStyleName(getStyleName());
    }
}
