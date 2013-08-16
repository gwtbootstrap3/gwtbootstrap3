package com.svenjacobs.gwtbootstrap3.demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Sven Jacobs
 */
public class GwtBootstrap3Demo implements EntryPoint {
    @Override
    public void onModuleLoad() {
        RootPanel.get().add(new DemoPage().asWidget());
    }
}
