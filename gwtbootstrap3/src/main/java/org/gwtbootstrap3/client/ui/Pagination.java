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

import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.PaginationSize;
import org.gwtbootstrap3.client.ui.constants.Styles;

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

    public ListItem addPreviousLink() {
        final ListItem listItem = new ListItem();
        listItem.setIcon(IconType.ANGLE_DOUBLE_LEFT);
        insert(listItem, 0);
        return listItem;
    }

    public ListItem addNextLink() {
        final ListItem listItem = new ListItem();
        listItem.setIcon(IconType.ANGLE_DOUBLE_RIGHT);
        add(listItem);
        return listItem;
    }
}