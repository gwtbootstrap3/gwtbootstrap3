package org.gwtbootstrap3.client;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;

/**
 * @author Sven Jacobs
 */
public class GwtBootstrap3Entry implements EntryPoint {

    @Override
    public void onModuleLoad() {
        ScriptInjector.fromString(GwtBootstrap3ClientBundle.INSTANCE.jQuery().getText())
                .setWindow(ScriptInjector.TOP_WINDOW)
                .inject();

        ScriptInjector.fromString(GwtBootstrap3ClientBundle.INSTANCE.bootstrap().getText())
                .setWindow(ScriptInjector.TOP_WINDOW)
                .inject();
    }
}
