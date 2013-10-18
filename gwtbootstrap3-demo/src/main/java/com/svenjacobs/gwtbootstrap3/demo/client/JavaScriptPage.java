package com.svenjacobs.gwtbootstrap3.demo.client;

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
public class JavaScriptPage implements IsWidget {

    interface MyUiBinder extends UiBinder<FlowPanel, JavaScriptPage> {
    }

    private static final MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField
    FlowPanel navigation;

    private final FlowPanel root;

    public JavaScriptPage() {
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