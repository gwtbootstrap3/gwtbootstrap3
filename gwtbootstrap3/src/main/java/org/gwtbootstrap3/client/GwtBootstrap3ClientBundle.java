package org.gwtbootstrap3.client;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2016 GwtBootstrap3
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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Sven Jacobs
 */
public interface GwtBootstrap3ClientBundle extends ClientBundle {

    static final GwtBootstrap3ClientBundle INSTANCE = GWT.create(GwtBootstrap3ClientBundle.class);

    @Source("resource/js/gwtbootstrap3.js")
    TextResource gwtBootstrap3();

    @Source("resource/js/jquery-1.12.4.min.cache.js")
    TextResource jQuery();

    @Source("resource/js/bootstrap-3.4.1.min.cache.js")
    TextResource bootstrap();
}
