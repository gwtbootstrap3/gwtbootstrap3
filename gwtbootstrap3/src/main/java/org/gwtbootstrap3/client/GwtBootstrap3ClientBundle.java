package org.gwtbootstrap3.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Sven Jacobs
 */
public interface GwtBootstrap3ClientBundle extends ClientBundle {

    static final GwtBootstrap3ClientBundle INSTANCE = GWT.create(GwtBootstrap3ClientBundle.class);

    @Source("resource/js/jquery-1.11.2.min.cache.js")
    TextResource jQuery();

    @Source("resource/js/bootstrap-3.3.2.min.cache.js")
    TextResource bootstrap();
}
