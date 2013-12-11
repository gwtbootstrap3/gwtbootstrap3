package com.svenjacobs.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 Sven Jacobs
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

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.shared.event.ModalHiddenEvent;
import com.svenjacobs.gwtbootstrap3.client.shared.event.ModalHideEvent;
import com.svenjacobs.gwtbootstrap3.client.shared.event.ModalShowEvent;
import com.svenjacobs.gwtbootstrap3.client.shared.event.ModalShownEvent;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.base.modal.ModalContent;
import com.svenjacobs.gwtbootstrap3.client.ui.base.modal.ModalDialog;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Attributes;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ModalBackdrop;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Modal dialog.
 * <p/>
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:Modal title="Important information" b:id="modal1">
 *         <b:ModalBody>
 *             <g:HTML>Lorem ipsum...</g:HTML>
 *         </b:ModalBody>
 *         <b:ModalFooter>
 *             <b:Button type="PRIMARY">Do something</b:Button>
 *             <b:Button type="DANGER" dismiss="MODAL">Close</b:Button>
 *         </b:ModalFooter>
 *     </b:Modal>
 *     <b:Button target="#modal1" toggle="MODAL">Show modal</b:Button>
 * }</pre>
 * <p/>
 * It's also possible to specify a custom modal header:
 * <pre>{@code
 *     <b:Modal>
 *         <b:ModalHeader>
 *             <g:HTML>
 *                 <h4>Custom header</h4>
 *             </g:HTML>
 *         </b:ModalHeader>
 *         ...
 *     </b:Modal>
 * }</pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see ModalHeader
 * @see ModalBody
 * @see ModalFooter
 * @see ModalShowEvent
 * @see ModalShownEvent
 * @see ModalHideEvent
 * @see ModalHiddenEvent
 */
public class Modal extends FlowPanel implements IsClosable, HasResponsiveness {

    private final ModalContent content = new ModalContent();
    private ModalHeader header = new ModalHeader();

    public Modal() {
        setStyleName(Styles.MODAL);

        final ModalDialog dialog = new ModalDialog();

        content.add(header);
        dialog.add(content);

        add(dialog);

        bindJavaScriptEvents(getElement());
    }

    @Override
    public void add(final Widget w) {
        // User can supply own ModalHeader
        if (w instanceof ModalHeader) {
            header.removeFromParent();
            header = (ModalHeader) w;
        }

        if (w instanceof ModalComponent) {
            content.add(w);
        } else {
            super.add(w);
        }
    }

    public void setTitle(final String title) {
        header.setTitle(title);
    }

    @Override
    public void setClosable(final boolean closable) {
        header.setClosable(closable);
    }

    @Override
    public boolean isClosable() {
        return header.isClosable();
    }

    @Override
    public void setVisibleOn(final String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(final String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }

    /**
     * If set Modal will fade in/out.
     *
     * @param fade If {@code true} modal will fade in/out
     */
    public void setFade(final boolean fade) {
        if (fade) {
            addStyleName(Styles.FADE);
        } else {
            removeStyleName(Styles.FADE);
        }
    }

    /**
     * Sets backdrop of modal.
     *
     * @param backdrop Backdrop of modal
     * @see ModalBackdrop
     */
    public void setBackdrop(final ModalBackdrop backdrop) {
        if (backdrop != null) {
            getElement().setAttribute(Attributes.DATA_BACKDROP, backdrop.getBackdrop());
        } else {
            getElement().removeAttribute(Attributes.DATA_BACKDROP);
        }
    }

    public void setKeyboard(final boolean keyboard) {
        getElement().setAttribute(Attributes.DATA_KEYBOARD, Boolean.toString(keyboard));
    }

    public void toggle() {
        modal(getElement(), "toggle");
    }

    public void show() {
        modal(getElement(), "show");
    }

    public void hide() {
        modal(getElement(), "hide");
    }

    /**
     * Can be override by subclasses to handle Modal's "show" event
     * however it's recommended to add an event handler to the modal.
     *
     * @param evt Event
     * @see ModalShowEvent
     */
    protected void onShow(final Event evt) {
        fireEvent(new ModalShowEvent(this, evt));
    }

    /**
     * Can be override by subclasses to handle Modal's "shown" event
     * however it's recommended to add an event handler to the modal.
     *
     * @param evt Event
     * @see ModalShownEvent
     */
    protected void onShown(final Event evt) {
        fireEvent(new ModalShownEvent(this, evt));
    }

    /**
     * Can be override by subclasses to handle Modal's "hide" event
     * however it's recommended to add an event handler to the modal.
     *
     * @param evt Event
     * @see ModalHideEvent
     */
    protected void onHide(final Event evt) {
        fireEvent(new ModalHideEvent(this, evt));
    }

    /**
     * Can be override by subclasses to handle Modal's "hidden" event
     * however it's recommended to add an event handler to the modal.
     *
     * @param evt Event
     * @see ModalHiddenEvent
     */
    protected void onHidden(final Event evt) {
        fireEvent(new ModalHiddenEvent(this, evt));
    }

    private native void bindJavaScriptEvents(final Element e) /*-{
        var target = this;
        var $modal = $wnd.jQuery(e);

        $modal.on('show.bs.modal', function (evt) {
            target.@com.svenjacobs.gwtbootstrap3.client.ui.Modal::onShow(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $modal.on('shown.bs.modal', function (evt) {
            target.@com.svenjacobs.gwtbootstrap3.client.ui.Modal::onShown(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $modal.on('hide.bs.modal', function (evt) {
            target.@com.svenjacobs.gwtbootstrap3.client.ui.Modal::onHide(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $modal.on('hidden.bs.modal', function (evt) {
            target.@com.svenjacobs.gwtbootstrap3.client.ui.Modal::onHidden(Lcom/google/gwt/user/client/Event;)(evt);
        });
    }-*/;

    private native void modal(final Element e, final String arg) /*-{
        $wnd.jQuery(e).modal(arg);
    }-*/;
}
