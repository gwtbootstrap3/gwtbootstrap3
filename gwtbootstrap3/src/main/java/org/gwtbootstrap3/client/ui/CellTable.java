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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.TableType;

/**
 * @author Joshua Godi
 */
public class CellTable<T> extends com.google.gwt.user.cellview.client.CellTable<T> implements HasResponsiveness {
    private static final int DEFAULT_PAGESIZE = 15;
    private static Resources DEFAULT_RESOURCES;

    /**
     * Constructs a table with a default page size of 15.
     */
    public CellTable() {
        this(DEFAULT_PAGESIZE);
    }

    /**
     * Constructs a table with the given page size.
     *
     * @param pageSize the page size
     */
    public CellTable(final int pageSize) {
        this(pageSize, getDefaultResources());
    }

    /**
     * Constructs a table with a default page size of 15, and the given
     * {@link ProvidesKey key provider}.
     *
     * @param keyProvider an instance of ProvidesKey<T>, or null if the record
     *                    object should act as its own key
     */
    public CellTable(final ProvidesKey<T> keyProvider) {
        this(DEFAULT_PAGESIZE, keyProvider);
    }

    /**
     * Constructs a table with the given page size with the specified
     * {@link Resources}.
     *
     * @param pageSize  the page size
     * @param resources the resources to use for this widget
     */
    public CellTable(final int pageSize, final Resources resources) {
        super(pageSize, resources, null);
    }

    /**
     * Constructs a table with the given page size and the given
     * {@link ProvidesKey key provider}.
     *
     * @param pageSize    the page size
     * @param keyProvider an instance of ProvidesKey<T>, or null if the record
     *                    object should act as its own key
     */
    public CellTable(final int pageSize, final ProvidesKey<T> keyProvider) {
        super(pageSize, getDefaultResources(), keyProvider);
    }

    /**
     * Constructs a table with the specified page size, {@link Resources}, key
     * provider, and loading indicator.
     *
     * @param pageSize         the page size
     * @param resources        the resources to use for this widget
     * @param keyProvider      an instance of ProvidesKey<T>, or null if the record
     *                         object should act as its own key
     * @param loadingIndicator the widget to use as a loading indicator, or null
     *                         to disable
     */
    public CellTable(final int pageSize, final Resources resources, final ProvidesKey<T> keyProvider, final Widget loadingIndicator) {
        this(pageSize, resources, keyProvider, loadingIndicator, true, true);
    }

    /**
     * Constructs a table with the specified page size, {@link Resources}, key
     * provider, and loading indicator.
     *
     * @param pageSize           the page size
     * @param resources          the resources to use for this widget
     * @param keyProvider        an instance of ProvidesKey<T>, or null if the record
     *                           object should act as its own key
     * @param loadingIndicator   the widget to use as a loading indicator, or null
     *                           to disable
     * @param enableColGroup     enable colgroup element. This is used when the table is using fixed
     *                           layout and when column style is added. Ignoring this element will boost rendering
     *                           performance. Note that when colgroup is disabled, {@link #setColumnWidth}
     * @param attachLoadingPanel attaching the table section that contains the empty table widget and
     *                           the loading indicator. Attaching this to the table significantly improve the rendering
     *                           performance in webkit based browsers but also introduces significantly larger latency
     *                           in IE. If the panel is not attached to the table, it won't be displayed. But the user
     *                           can call {@link #getTableLoadingSection} and attach it to other elements outside the
     *                           table element
     */
    public CellTable(final int pageSize, final Resources resources, final ProvidesKey<T> keyProvider,
                     final Widget loadingIndicator, final boolean enableColGroup, final boolean attachLoadingPanel) {
        super(pageSize, resources, keyProvider, loadingIndicator, enableColGroup, attachLoadingPanel);
        StyleHelper.addEnumStyleName(this, TableType.DEFAULT);
    }

    private static Resources getDefaultResources() {
        if (DEFAULT_RESOURCES == null) {
            CellTable.Resources cellTableResources = GWT.create(CellTable.Resources.class);
            DEFAULT_RESOURCES = new ResourcesAdapter(cellTableResources);
        }
        return DEFAULT_RESOURCES;
    }

    @Override
    public void setVisibleOn(final String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(final String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }

    public void setStriped(final boolean striped) {
        if (striped) {
            StyleHelper.addEnumStyleName(this, TableType.STRIPED);
        } else {
            StyleHelper.removeEnumStyleName(this, TableType.STRIPED);
        }
    }

    public void setBordered(final boolean bordered) {
        if (bordered) {
            StyleHelper.addEnumStyleName(this, TableType.BORDERED);
        } else {
            StyleHelper.removeEnumStyleName(this, TableType.BORDERED);
        }
    }

    public void setCondensed(final boolean condensed) {
        if (condensed) {
            StyleHelper.addEnumStyleName(this, TableType.CONDENSED);
        } else {
            StyleHelper.removeEnumStyleName(this, TableType.CONDENSED);
        }
    }

    public void setHover(final boolean hover) {
        if (hover) {
            StyleHelper.addEnumStyleName(this, TableType.HOVER);
        } else {
            StyleHelper.removeEnumStyleName(this, TableType.HOVER);
        }
    }

    /**
     * Resources/Styles to remove the GWT styling of the tables!
     */
    private static class ResourcesAdapter implements CellTable.Resources {
        private final CellTable.Resources resources;
        private final StyleAdapter style;

        public ResourcesAdapter(CellTable.Resources resources) {
            this.resources = resources;
            this.style = new StyleAdapter();
        }

        @Override
        public ImageResource cellTableFooterBackground() {
            return resources.cellTableFooterBackground();
        }

        @Override
        public ImageResource cellTableHeaderBackground() {
            return resources.cellTableHeaderBackground();
        }

        @Override
        public ImageResource cellTableLoading() {
            return resources.cellTableLoading();
        }

        @Override
        public ImageResource cellTableSelectedBackground() {
            return resources.cellTableSelectedBackground();
        }

        @Override
        public ImageResource cellTableSortAscending() {
            return resources.cellTableSortAscending();
        }

        @Override
        public ImageResource cellTableSortDescending() {
            return resources.cellTableSortDescending();
        }

        @Override
        public Style cellTableStyle() {
            return style;
        }
    }

    private static class StyleAdapter implements CellTable.Style {
        private static final String B = "gwtb3-";

        @Override
        public boolean ensureInjected() {
            return true;
        }

        @Override
        public String cellTableCell() {
            return B + "cellTableCell";
        }

        @Override
        public String cellTableEvenRow() {
            return B + "cellTableEvenRow";
        }

        @Override
        public String cellTableEvenRowCell() {
            return B + "cellTableEvenRowCell";
        }

        @Override
        public String cellTableFirstColumn() {
            return B + "cellTableFirtColumn";
        }

        @Override
        public String cellTableFirstColumnFooter() {
            return B + "cellTableFirstColumnFooter";
        }

        @Override
        public String cellTableFirstColumnHeader() {
            return B + "cellTableFirstColumnHeader";
        }

        @Override
        public String cellTableFooter() {
            return B + "cellTableFooter";
        }

        @Override
        public String cellTableHeader() {
            return B + "cellTableHeader";
        }

        @Override
        public String cellTableHoveredRow() {
            return B + "cellTableHoveredRow";
        }

        @Override
        public String cellTableHoveredRowCell() {
            return B + "cellTableHoveredRowCell";
        }

        @Override
        public String cellTableKeyboardSelectedCell() {
            return B + "cellTableKeyboardSelectedCell";
        }

        @Override
        public String cellTableKeyboardSelectedRow() {
            return B + "cellTableKeyboardSelectedRow";
        }

        @Override
        public String cellTableKeyboardSelectedRowCell() {
            return B + "cellTableKeyboardSelectedRowCell";
        }

        @Override
        public String cellTableLastColumn() {
            return B + "cellTableLastColumn";
        }

        @Override
        public String cellTableLastColumnFooter() {
            return B + "cellTableLastColumnFooter";
        }

        @Override
        public String cellTableLastColumnHeader() {
            return B + "cellTableLastColumnHeader";
        }

        @Override
        public String cellTableLoading() {
            return B + "cellTableLoading";
        }

        @Override
        public String cellTableOddRow() {
            return B + "cellTableOddRow";
        }

        @Override
        public String cellTableOddRowCell() {
            return B + "cellTableOddRowCell";
        }

        @Override
        public String cellTableSelectedRow() {
            return B + "cellTableSelectedRow";
        }

        @Override
        public String cellTableSelectedRowCell() {
            return B + "cellTableSelectedRowCell";
        }

        @Override
        public String cellTableSortableHeader() {
            return B + "cellTableSortableHeader";
        }

        @Override
        public String cellTableSortedHeaderAscending() {
            return B + "cellTableSortedHeaderAscending";
        }

        @Override
        public String cellTableSortedHeaderDescending() {
            return B + "cellTableSortedHeaderDescending";
        }

        @Override
        public String cellTableWidget() {
            return B + "cellTableWidget";
        }

        @Override
        public String getText() {
            return B;
        }

        @Override
        public String getName() {
            return B;
        }
    }
}
