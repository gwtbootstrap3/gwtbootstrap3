package com.svenjacobs.gwtbootstrap3.demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.ListItem;
import com.svenjacobs.gwtbootstrap3.client.ui.NavbarBrand;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;
import com.svenjacobs.gwtbootstrap3.demo.client.demos.css.*;

/**
 * @author Joshua Godi
 */
public class DemoEntryPoint implements EntryPoint {
    interface DemoEntryPointUiBinder extends UiBinder<Widget, DemoEntryPoint> {
    }

    private static DemoEntryPointUiBinder ourUiBinder = GWT.create(DemoEntryPointUiBinder.class);

    @UiField
    Row container;
    //    @UiField
//    Jumbotron jumbo;
    @UiField
    NavbarBrand brand;
    @UiField
    ListItem componentsLink;
    @UiField
    ListItem javaScriptLink;
    @UiField
    ListItem gridSystemLink;
    @UiField
    ListItem typographyLink;
    @UiField
    ListItem codeLink;
    @UiField
    ListItem tablesLink;
    @UiField
    ListItem formsLink;
    @UiField
    ListItem buttonsLink;
    @UiField
    ListItem imagesLink;
    @UiField
    ListItem responsiveUtilitiesLink;

    @UiHandler("brand")
    public void handleBrandClick(ClickEvent event) {
        container.clear();
    }


    @UiHandler("componentsLink")
    public void handleComponentsClick(ClickEvent event) {
        container.clear();
        container.add(new ComponentsPage().asWidget());
    }

    @UiHandler("javaScriptLink")
    public void handleJavaScriptClick(ClickEvent event) {
        container.clear();
        container.add(new JavaScriptPage().asWidget());
    }

    @Override
    public void onModuleLoad() {
        RootPanel.get().add(ourUiBinder.createAndBindUi(this));

        gridSystemLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                container.clear();
                container.add(new GridSystem());
            }
        });

        typographyLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                container.clear();
                container.add(new Typography());
            }
        });

        codeLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                container.clear();
                container.add(new com.svenjacobs.gwtbootstrap3.demo.client.demos.css.Code());
            }
        });

        tablesLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                container.clear();
                container.add(new Tables());
            }
        });

        formsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                container.clear();
                container.add(new Forms());
            }
        });

        buttonsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                container.clear();
                container.add(new Buttons());
            }
        });

        imagesLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                container.clear();
                container.add(new Images());
            }
        });

        responsiveUtilitiesLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                container.clear();
                container.add(new ResponsiveUtilities());
            }
        });
    }
}