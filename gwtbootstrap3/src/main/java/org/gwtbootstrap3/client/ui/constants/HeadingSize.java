package org.gwtbootstrap3.client.ui.constants;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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


/**
 * @author Joshua Godi
 */
public enum HeadingSize implements Size {
    H1(1),
    H2(2),
    H3(3),
    H4(4),
    H5(5),
    H6(6);

    private final int headingSize;

    HeadingSize(final int headingSize) {
        this.headingSize = headingSize;
    }

    public int getHeadingSize() {
        return headingSize;
    }
}