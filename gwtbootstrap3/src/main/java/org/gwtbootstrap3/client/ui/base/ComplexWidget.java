package org.gwtbootstrap3.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2016 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base class for widgets that contain further widgets.
 *
 * @author Sven Jacobs
 */
public class ComplexWidget extends ComplexPanel implements HasId, HasResponsiveness, HasInlineStyle, HasPull {
    private final IdMixin<ComplexWidget> idMixin = new IdMixin<ComplexWidget>(this);
    private final PullMixin<ComplexWidget> pullMixin = new PullMixin<ComplexWidget>(this);

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final Widget child) {
        add(child, (Element) getElement());
    }

    /**
     * Inserts a widget at a specific index
     *
     * @param child       - widget to be inserted
     * @param beforeIndex - index for the widget
     */
    public void insert(final Widget child, final int beforeIndex) {
        insert(child, (Element) getElement(), beforeIndex, true);
    }

    @Override
    @Deprecated
    protected void insert(Widget child, com.google.gwt.user.client.Element container,
        int beforeIndex, boolean domInsert) {
        // Validate index; adjust if the widget is already a child of this panel.
        beforeIndex = adjustIndex(child, beforeIndex);

        // Detach new child.
        child.removeFromParent();

        // Logical attach.
        getChildren().insert(child, beforeIndex);

        // Physical attach.
        if (domInsert) {
            // NOTE (issue #477): DO NOT call DOM.insertChild() to correctly handle
            // text nodes insertion according to the logical child widgets order.
            // Calling DOM.insertChild(container, TEXT_NODE, beforeIndex) will
            // always append the text node at the last position.
            //DOM.insertChild(container, child.getElement(), beforeIndex);
            Widget beforeWidget = getChildren().size() > beforeIndex + 1 ?
                    getChildren().get(beforeIndex + 1) : null;
            if (beforeWidget == null) {
                // Append to last position
                DOM.appendChild(container, child.getElement());
            } else {
                // Insert before the node of beforeWidget
                container.insertBefore(child.getElement(), beforeWidget.getElement());
            }
        } else {
            DOM.appendChild(container, child.getElement());
        }

        // Adopt.
        adopt(child);
    }

    /**
     * <p><b>
     * Overrides the remove(Widget) method to avoid potential NPE when
     * removing a {@link Text} node which is not supposed to be a
     * "widget" in GWT.
     * </b></p>
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Widget w) {
        // Validate.
        if (w.getParent() != this) {
            return false;
        }
        // Orphan.
        try {
            orphan(w);
        } finally {
            // Physical detach.
            Element elem = w.getElement();
            // NOTE (issue #486): DO NOT call DOM.getParent() to correctly handle
            // text node removing. Calling DOM.getParent(TEXT_NODE) will throw a
            // NPE exception.
            //DOM.getParent(elem).removeChild(elem);
            elem.removeFromParent();

            // Logical detach.
            getChildren().remove(w);
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return idMixin.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMarginTop(final double margin) {
        getElement().getStyle().setMarginTop(margin, Style.Unit.PX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMarginLeft(final double margin) {
        getElement().getStyle().setMarginLeft(margin, Style.Unit.PX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMarginRight(final double margin) {
        getElement().getStyle().setMarginRight(margin, Style.Unit.PX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMarginBottom(final double margin) {
        getElement().getStyle().setMarginBottom(margin, Style.Unit.PX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPaddingTop(final double padding) {
        getElement().getStyle().setPaddingTop(padding, Style.Unit.PX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPaddingLeft(final double padding) {
        getElement().getStyle().setPaddingLeft(padding, Style.Unit.PX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPaddingRight(final double padding) {
        getElement().getStyle().setPaddingRight(padding, Style.Unit.PX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPaddingBottom(final double padding) {
        getElement().getStyle().setPaddingBottom(padding, Style.Unit.PX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setColor(String color) {
        getElement().getStyle().setColor(color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPull(final Pull pull) {
        pullMixin.setPull(pull);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pull getPull() {
        return pullMixin.getPull();
    }
}
