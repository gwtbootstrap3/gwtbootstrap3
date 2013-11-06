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
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.FlowPanel;

import static com.svenjacobs.gwtbootstrap3.client.ui.Affix.affix;
import static com.svenjacobs.gwtbootstrap3.client.ui.ScrollSpy.scrollSpy;

/**
 * @author Joshua Godi
 */
public class CssPage implements IsWidget {

    interface MyUiBinder extends UiBinder<FlowPanel, CssPage> {
    }

    private static final MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField
    FlowPanel navigation;

    private final FlowPanel root;

    public CssPage() {
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
    }

    @Override
    public Widget asWidget() {
        return root;
    }

    private native void prettyPrint() /*-{
        $wnd.prettyPrint();
    }-*/;
}