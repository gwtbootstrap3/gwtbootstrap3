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
import com.svenjacobs.gwtbootstrap3.demo.client.demos.components.*;
import com.svenjacobs.gwtbootstrap3.demo.client.demos.css.*;
import com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript.*;
import com.svenjacobs.gwtbootstrap3.demo.client.demos.setup.Setup;

/**
 * @author Joshua Godi
 */
public class DemoEntryPoint implements EntryPoint {
    interface DemoEntryPointUiBinder extends UiBinder<Widget, DemoEntryPoint> {
    }

    private static final DemoEntryPointUiBinder ourUiBinder = GWT.create(DemoEntryPointUiBinder.class);

    @UiField
    Row container;
    @UiField
    NavbarBrand brand;
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
    @UiField
    ListItem alertsLink;
    @UiField
    ListItem wellsLink;
    @UiField
    ListItem badgesLink;
    @UiField
    ListItem breadcrumbsLink;
    @UiField
    ListItem buttonDropdownsLink;
    @UiField
    ListItem buttonGroupsLink;
    @UiField
    ListItem dropdownsLink;
    @UiField
    ListItem iconsLink;
    @UiField
    ListItem inputGroupsLink;
    @UiField
    ListItem jumobtronLink;
    @UiField
    ListItem labelsLink;
    @UiField
    ListItem listGroupLink;
    @UiField
    ListItem mediaObjectsLink;
    @UiField
    ListItem navBarLink;
    @UiField
    ListItem navsLink;
    @UiField
    ListItem pageHeaderLink;
    @UiField
    ListItem paginationLink;
    @UiField
    ListItem panelsLink;
    @UiField
    ListItem progressBarLink;
    @UiField
    ListItem thumbnailsLink;
    @UiField
    ListItem carouselLink;
    @UiField
    ListItem collapseLink;
    @UiField
    ListItem modalsLink;
    @UiField
    ListItem popoverLink;
    @UiField
    ListItem affixLink;
    @UiField
    com.svenjacobs.gwtbootstrap3.client.ui.Jumbotron jumbotron;
    @UiField
    ListItem dateTimePickerLink;
    @UiField
    ListItem tooltipsLink;
    @UiField
    ListItem bootboxLink;
    @UiField
    ListItem setupLink;

    @UiHandler("brand")
    public void handleBrandClick(final ClickEvent event) {
        container.clear();
        container.add(jumbotron);
    }

    @Override
    public void onModuleLoad() {
        RootPanel.get().add(ourUiBinder.createAndBindUi(this));

        setupLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                container.clear();
                container.add(new Setup());
            }
        });

        /**
         * CSS LINKS
         */

        gridSystemLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new GridSystem());
            }
        });

        typographyLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Typography());
            }
        });

        codeLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new com.svenjacobs.gwtbootstrap3.demo.client.demos.css.Code());
            }
        });

        tablesLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Tables());
            }
        });

        formsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Forms());
            }
        });

        buttonsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Buttons());
            }
        });

        imagesLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Images());
            }
        });

        responsiveUtilitiesLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new ResponsiveUtilities());
            }
        });

        /**
         * COMPONENTS LINKS
         */

        alertsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Alerts());
            }
        });

        badgesLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Badges());
            }
        });

        breadcrumbsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Breadcrumbs());
            }
        });

        buttonDropdownsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new ButtonDropdowns());
            }
        });

        buttonGroupsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new ButtonGroups());
            }
        });

        dropdownsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Dropdowns());
            }
        });

        iconsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Icons());
            }
        });

        inputGroupsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new InputGroups());
            }
        });

        jumobtronLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Jumbotron());
            }
        });

        labelsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Labels());
            }
        });

        listGroupLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new ListGroup());
            }
        });

        mediaObjectsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new MediaObjects());
            }
        });

        navBarLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Navbar());
            }
        });

        navsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Navs());
            }
        });

        pageHeaderLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new PageHeader());
            }
        });

        paginationLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Pagination());
            }
        });

        panelsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Panels());
            }
        });

        progressBarLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new ProgressBars());
            }
        });

        thumbnailsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Thumbnails());
            }
        });

        wellsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Wells());
            }
        });

        /**
         * JAVASCRIPT LINKS
         */

        affixLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Affix());
            }
        });

        carouselLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Carousel());
            }
        });

        collapseLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Collapse());
            }
        });

        dateTimePickerLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new DateTimePickers());
            }
        });

        modalsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Modals());
            }
        });

        popoverLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Popover());
            }
        });

        tooltipsLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                container.clear();
                container.add(new Tooltips());
            }
        });

        bootboxLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                container.clear();
                container.add(new BootboxJS());
            }
        });
    }
}