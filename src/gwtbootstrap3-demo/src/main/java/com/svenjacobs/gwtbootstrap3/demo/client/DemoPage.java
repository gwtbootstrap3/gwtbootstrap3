package com.svenjacobs.gwtbootstrap3.demo.client;

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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.shared.event.ModalHiddenEvent;
import com.svenjacobs.gwtbootstrap3.client.shared.event.ModalHiddenHandler;
import com.svenjacobs.gwtbootstrap3.client.ui.Button;
import com.svenjacobs.gwtbootstrap3.client.ui.FlowPanel;
import com.svenjacobs.gwtbootstrap3.client.ui.ListItem;
import com.svenjacobs.gwtbootstrap3.client.ui.Modal;

import static com.svenjacobs.gwtbootstrap3.client.ui.Affix.affix;
import static com.svenjacobs.gwtbootstrap3.client.ui.ScrollSpy.scrollSpy;

/**
 * @author Sven Jacobs
 */
public class DemoPage implements IsWidget {

    interface MyUiBinder extends UiBinder<FlowPanel, DemoPage> {}

    private static final MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    private final FlowPanel root;

    @UiField
    Button button;

    @UiField
    ListItem dropDownMenuItem;

    @UiField
    Modal modal;

    @UiField
    FlowPanel navigation;

    public DemoPage() {
        root = uiBinder.createAndBindUi(this);

        root.addAttachHandler(new AttachEvent.Handler() {
            @Override
            public void onAttachOrDetach(final AttachEvent event) {
                if (event.isAttached()) {
                    affix(navigation);
                    scrollSpy(navigation);
                    prettyPrint();
                }
            }
        });

        // Demo of Modal event handler
        modal.addHandler(new ModalHiddenHandler() {
            @Override
            public void onHidden(final ModalHiddenEvent evt) {
                //Window.alert("Modal hidden");
            }
        }, ModalHiddenEvent.getType());
    }

    @Override
    public Widget asWidget() {
        return root;
    }

    @UiHandler("button")
    public void onButtonClick(final ClickEvent event) {
        button.state().loading();

        new Timer() {
            @Override
            public void run() {
                button.state().reset();
            }
        }.schedule(2000);
    }

    @UiHandler("dropDownMenuItem")
    public void onDropDownMenuItemClick(final ClickEvent event) {
        Window.alert("Dropdown item has been clicked");
    }

    private native void prettyPrint() /*-{
        $wnd.prettyPrint();
    }-*/;
}
