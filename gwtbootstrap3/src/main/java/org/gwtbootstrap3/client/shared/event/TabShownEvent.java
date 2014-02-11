package org.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import org.gwtbootstrap3.client.ui.TabListItem;

/**
 * @author godi
 */
public class TabShownEvent extends GwtEvent<TabShownHandler> implements TabEvent {

    private static final Type<TabShownHandler> TYPE = new Type<TabShownHandler>();

    private final TabListItem tab;
    private final Event nativeEvent;

    public static Type<TabShownHandler> getType() {
        return TYPE;
    }

    public TabShownEvent(final TabListItem tab, final Event nativeEvent) {
        this.tab = tab;
        this.nativeEvent = nativeEvent;
    }

    @Override
    public TabListItem getTab() {
        return tab;
    }

    @Override
    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<TabShownHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final TabShownHandler handler) {
        handler.onShown(this);
    }
}