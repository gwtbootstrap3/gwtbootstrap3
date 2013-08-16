package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.UIObject;

/**
 * An Affix is an element/container that gets "pinned" as soon as a certain amount of pixels have been scrolled.
 * <p/>
 * Any element/container can become an Affix. Usually used for sidebar navigation.
 * <p/>
 * <strong>Note:</strong> Bootstrap adds/removes classes from Affix based on scroll position which requires custom
 * styling. See Bootstrap's <a href="http://getbootstrap.com/javascript/#affix">documentation</a>.
 *
 * @author Sven Jacobs
 */
public class Affix {

    /**
     * Applys affix functionality to specified element.
     *
     * @param element Element to "affixnize"
     */
    public static void affix(final Element element) {
        internalAffix(element, 10);
    }

    /**
     * Applys affix functionality to specified element.
     *
     * @param element Element to "affixnize"
     * @param offset  Offset of affix
     */
    public static void affix(final Element element,
                             final int offset) {
        internalAffix(element, offset);
    }

    /**
     * Applys affix functionality to specified object.
     *
     * @param object Object to "affixnize"
     */
    public static void affix(final UIObject object) {
        affix(object.getElement());
    }

    /**
     * Applys affix functionality to specified object.
     *
     * @param object Object to "affixnize"
     * @param offset Offset of affix
     */
    public static void affix(final UIObject object,
                             final int offset) {
        affix(object.getElement(), offset);
    }

    private static native void internalAffix(final Element e,
                                             final int offset) /*-{
        $wnd.jQuery(e).affix({
            offset: offset
        });
    }-*/;
}
