package org.gwtbootstrap3.client.ui.constants;

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

/**
 * Enum for the different type of device sizes that are supported.
 *
 * @author Joshua Godi
 */
public enum DeviceSize implements Size {
    PRINT, /* Print Devices */
    XS, /* Phones <768px */
    SM, /* Tablets >=768px */
    MD, /* Desktops >=992px */
    LG, /* Desktops >=1200px */

    //    Helper sizes for different types for Hidden/Visible
    XS_SM,
    XS_MD,
    XS_LG,
    SM_MD,
    SM_LG,
    MD_LG,
    XS_SM_MD,
    XS_SM_LG,
    XS_MD_LG,
    SM_MD_LG,
    XS_SM_MD_LG
}
