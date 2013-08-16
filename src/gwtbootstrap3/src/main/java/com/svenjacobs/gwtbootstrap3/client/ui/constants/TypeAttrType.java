package com.svenjacobs.gwtbootstrap3.client.ui.constants;

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

/**
 * Represents values for the {@code type=""} HTML attribute.
 *
 * @author Sven Jacobs
 */
public enum TypeAttrType implements Type {
    BUTTON("button"),
    SUBMIT("submit"),
    TEXT("text"),
    RADIO("radio"),
    CHECKBOX("checkbox");

    private final String inputType;

    private TypeAttrType(final String inputType) {
        this.inputType = inputType;
    }

    public String getInputType() {
        return inputType;
    }
}
