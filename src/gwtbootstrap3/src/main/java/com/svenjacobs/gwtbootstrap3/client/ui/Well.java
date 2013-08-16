package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.WellSize;

/**
 * Well, well Mr. Anderson...
 *
 * @author Sven Jacobs
 */
public class Well extends HTMLPanel implements HasSize<WellSize> {

    public Well(final String html) {
        super(html);
        setStyleName(Styles.WELL);
    }

    public Well(final SafeHtml safeHtml) {
        this(safeHtml.asString());
    }

    @Override
    public void setSize(final WellSize size) {
        StyleHelper.addUniqueEnumStyleName(this, WellSize.class, size);
    }

    @Override
    public WellSize getSize() {
        return WellSize.fromStyleName(getStyleName());
    }
}
