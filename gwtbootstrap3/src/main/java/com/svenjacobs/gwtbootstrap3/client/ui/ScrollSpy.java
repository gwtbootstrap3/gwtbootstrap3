package com.svenjacobs.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 Sven Jacobs
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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.UIObject;

/**
 * A ScrollSpy handles scrolling events (typically on {@code <body>}) and
 * updates "active" states of a {@link Nav} accordingly. <h3>Note</h3> The
 * target element <strong>must</strong> be a parent element of a
 * {@code <ul class="nav">} or {@link Nav}.
 * <p/>
 * Also the ScrollSpy must be initialized when the target element has been added
 * to the DOM, for example in
 * {@link com.google.gwt.user.client.ui.Widget#onAttach()}.
 * 
 * <pre>
 * {@code
 *     &#64;Override
 *     protected void onAttach() {
 *         super.onAttach();
 *         ScrollSpy.scrollSpy(this);
 *     }
 * }
 * </pre>
 * <p/>
 * See Bootstrap's <a
 * href="http://getbootstrap.com/javascript/#scrollspy">documentation</a>.
 * 
 * @author Sven Jacobs
 */
public class ScrollSpy {

    private final Element spyOn;
    private final String target;

    /**
     * Attaches ScrollSpy to document {@code <body>} and with the specified
     * target CSS selector.
     * 
     * @param selector CSS selector for target element
     */
    public static ScrollSpy scrollSpy(final String selector) {
        return new ScrollSpy((Element) Document.get().getBody().cast(), selector);
    }

    /**
     * Attaches ScrollSpy to document {@code <body>} and with the specified
     * target element that <strong>must</strong> have an ID.
     * 
     * @param target Target element having an ID
     */
    public static ScrollSpy scrollSpy(final HasId target) {
        return new ScrollSpy((Element) Document.get().getBody().cast(), target);
    }

    /**
     * Attaches ScrollSpy to specified object with specified target selector.
     * 
     * @param spyOn Spy on this object
     * @param selector CSS selector of target element
     */
    public static ScrollSpy scrollSpy(final UIObject spyOn, final String selector) {
        return new ScrollSpy(spyOn.getElement(), selector);
    }

    /**
     * Attaches ScrollSpy to specified object with specified target element.
     * 
     * @param spyOn Spy on this object
     * @param target Target element having an ID
     */
    public static ScrollSpy scrollSpy(final UIObject spyOn, final HasId target) {
        return new ScrollSpy(spyOn.getElement(), target);
    }

    /**
     * Attaches ScrollSpy to specified element with specified target selector.
     * 
     * @param spyOn Spy on this element
     * @param selector CSS selector of target element
     */
    public static ScrollSpy scrollSpy(final Element spyOn, final String selector) {
        return new ScrollSpy(spyOn, selector);
    }

    private ScrollSpy(final Element spyOn, final String selector) {

        this.spyOn = spyOn;
        this.target = selector;

        init(this.spyOn, this.target);
    }

    private ScrollSpy(final Element spyOn, final HasId target) {

        final String id = target.getId();

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ScrollSpy target element must have id");
        }

        this.spyOn = spyOn;
        this.target = "#" + id;

        init(this.spyOn, this.target);
    }

    /**
     * Refresh ScrollSpy after elements have been added to or removed from the
     * DOM.
     */
    public void refresh() {
        refresh(spyOn);
    }

    private native void init(final Element e, final String target) /*-{
                                                                   var $e = $wnd.jQuery(e);

                                                                   $e.scrollspy({
                                                                   target: target
                                                                   });
                                                                   }-*/;

    private native void refresh(final Element e) /*-{
                                                 $wnd.jQuery(e).scrollspy('refresh');
                                                 }-*/;
}
