package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class CarouselIndicators extends ComplexWidget {

    public CarouselIndicators() {
        setElement(Document.get().createOLElement());
        setStyleName(Styles.CAROUSEL_INDICATORS);
    }

    @Override
    public void add(Widget child) {
        if (!(child instanceof CarouselIndicator)) {
            throw new IllegalArgumentException("Children can only be of type CarouselIndicator");
        }
        super.add(child);
    }
}
