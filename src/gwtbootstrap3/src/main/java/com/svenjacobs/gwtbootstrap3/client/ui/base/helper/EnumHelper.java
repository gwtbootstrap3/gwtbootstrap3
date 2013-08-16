package com.svenjacobs.gwtbootstrap3.client.ui.base.helper;

import com.google.gwt.dom.client.Style;

/**
 * @author Sven Jacobs
 */
public class EnumHelper {

    /**
     * Returns first enum constant found in at space-separated list of style names.
     *
     * @param styleName    Space-separated list of styles
     * @param enumClass    Type of enum
     * @param defaultValue Default value of no match was found
     * @param <E>
     * @return First enum constant found or default value
     */
    public static <E extends Enum<? extends Style.HasCssName>> E fromStyleName(final String styleName,
                                                                               final Class<E> enumClass,
                                                                               final E defaultValue) {

        if (styleName == null || enumClass == null) {
            return defaultValue;
        }

        for (final Enum<? extends Style.HasCssName> constant : enumClass.getEnumConstants()) {
            final Style.HasCssName anEnum = (Style.HasCssName) constant;
            final String cssClass = anEnum.getCssName();

            if (cssClass != null && StyleHelper.containsStyle(styleName, cssClass)) {
                //noinspection unchecked
                return (E) anEnum;
            }
        }

        return defaultValue;
    }
}
