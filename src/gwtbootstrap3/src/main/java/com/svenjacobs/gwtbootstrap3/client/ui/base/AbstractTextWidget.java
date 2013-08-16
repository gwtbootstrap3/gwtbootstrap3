package com.svenjacobs.gwtbootstrap3.client.ui.base;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.HasId;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.IdMixin;

/**
 * Base class for {@link Widget} that just contains text.
 *
 * @author Sven Jacobs
 */
public abstract class AbstractTextWidget extends Widget implements HasId, HasText {

    private final IdMixin idMixin = new IdMixin(this);

    protected AbstractTextWidget(final Element element) {
        setElement(element);
    }

    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }

    @Override
    public void setText(final String text) {
        getElement().setInnerText(text);
    }

    @Override
    public String getText() {
        return getElement().getInnerText();
    }
}
