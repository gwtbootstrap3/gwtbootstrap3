package com.svenjacobs.gwtbootstrap3.client.ui;

/**
 * Interface to set the visibility and hidden properties of elements
 * <p/>
 * Example:
 * <p/>
 * hiddenOn="SM MD"
 * visibleOn="SM LG"
 * hiddenOn="LG"
 *
 * @author Joshua Godi
 */
public interface HasResponsiveness {
    /**
     * Sets the devices that the element is visible on
     *
     * @param deviceSizeString space separated list of device sizes
     * @see com.svenjacobs.gwtbootstrap3.client.ui.constants.DeviceSize
     */
    void setVisibleOn(String deviceSizeString);

    /**
     * Sets the devices that the element is hidden on
     *
     * @param deviceSizeString space separated list of device sizes
     * @see com.svenjacobs.gwtbootstrap3.client.ui.constants.DeviceSize
     */
    void setHiddenOn(String deviceSizeString);
}
