package org.gwtbootstrap3.client.ui;

import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.UnorderedList;

/**
 * Creates the unordered list with the media list styles for Media Objects
 *
 * @author Joshua Godi
 */
public class MediaList extends UnorderedList {

    /**
     * Creates the default media list with the default styles
     */
    public MediaList() {
        setStyleName(Styles.MEDIA_LIST);
    }
}
