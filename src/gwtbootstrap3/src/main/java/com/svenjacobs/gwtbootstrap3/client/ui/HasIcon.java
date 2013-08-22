package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.constants.IconType;

/**
 * @author Sven Jacobs
 */
public interface HasIcon {
    void setIcon(IconType iconType);

    IconType getIcon();
}
