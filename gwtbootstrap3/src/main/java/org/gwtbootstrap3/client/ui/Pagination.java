package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import org.gwtbootstrap3.client.ui.base.HasPaginationSize;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.PaginationSize;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.UnorderedList;

/**
 * Support for Bootstrap pagination (http://getbootstrap.com/components/#pagination)
 *
 * @author Joshua Godi
 */
public class Pagination extends UnorderedList implements HasResponsiveness, HasPaginationSize {

    public Pagination() {
        setStyleName(Styles.PAGINATION);
    }

    public Pagination(final PaginationSize paginationSize) {
        this();
        setPaginationSize(paginationSize);
    }

    @Override
    public void setPaginationSize(final PaginationSize paginationSize) {
        StyleHelper.addUniqueEnumStyleName(this, PaginationSize.class, paginationSize);
    }

    @Override
    public PaginationSize getPaginationSize() {
        return PaginationSize.fromStyleName(getStyleName());
    }

    public AnchorListItem addPreviousLink() {
        final AnchorListItem listItem = new AnchorListItem();
        listItem.setIcon(IconType.ANGLE_DOUBLE_LEFT);
        insert(listItem, 0);
        return listItem;
    }

    public AnchorListItem addNextLink() {
        final AnchorListItem listItem = new AnchorListItem();
        listItem.setIcon(IconType.ANGLE_DOUBLE_RIGHT);
        add(listItem);
        return listItem;
    }

    /**
     * This will help to rebuild the Pagination based on the data inside the SimplePager passed in.
     * <p/>
     * Make sure to all this after adding/remove data from any of the grid to ensure that this stays
     * current with the SimplePager.
     * <p/>
     * ex.
     * dataProvider.getList().addAll(newData);
     * pagination.rebuild(mySimplePager);
     *
     * @param pager the SimplePager of the CellTable/DataGrid
     */
    public void rebuild(final SimplePager pager) {
        clear();

        if (pager.getPageCount() == 0) {
            return;
        }

        final AnchorListItem prev = addPreviousLink();
        prev.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                pager.previousPage();
            }
        });
        prev.setEnabled(pager.hasPreviousPage());

        for (int i = 0; i < pager.getPageCount(); i++) {
            final int display = i + 1;
            final AnchorListItem page = new AnchorListItem(String.valueOf(display));
            page.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(final ClickEvent event) {
                    pager.setPage(display - 1);
                }
            });

            if (i == pager.getPage()) {
                page.setActive(true);
            }

            add(page);
        }

        final AnchorListItem next = addNextLink();
        next.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                pager.nextPage();
            }
        });
        next.setEnabled(pager.hasNextPage());
    }
}