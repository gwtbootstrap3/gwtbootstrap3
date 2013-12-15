package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.IconType;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class CarouselControl extends ComplexWidget {
    private Icon icon = new Icon();

    public CarouselControl() {
        setElement(DOM.createAnchor());
        setStyleName(Styles.CAROUSEL_CONTROL);

        add(icon);
    }

    public void setIconType(IconType iconType) {
        icon.setType(iconType);
    }

    public void setHref(String href) {
        getElement().setAttribute("href", href);
    }

    public void setPrev(boolean prev) {
        getElement().removeAttribute("data-slide");
        getElement().setAttribute("data-slide", "prev");
        StyleHelper.toggleStyleName(this, prev, Styles.LEFT);
        icon.addStyleName(Styles.ICON_PREV);
    }

    public void setNext(boolean next) {
        getElement().removeAttribute("data-slide");
        getElement().setAttribute("data-slide", "next");
        StyleHelper.toggleStyleName(this, next, Styles.RIGHT);
        icon.addStyleName(Styles.ICON_NEXT);
    }
}
