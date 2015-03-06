package org.gwtbootstrap3.client.ui.form.validator;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
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

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link MessageFormat}.
 * 
 * @author Steven Jardine
 */
public class MessageFormatTest {

    /**
     * Test the {@link MessageFormat} class.
     */
    @Test
    public void test() {
        Assert.assertEquals(MessageFormat.format("{1} {2} {1}", new Object[] { "1", "2" }), "1 2 1");
        Assert.assertEquals(MessageFormat.format("{1} is a {2}", new Object[] { "This", "test" }), "This is a test");
        Assert.assertEquals(MessageFormat.format("{1} is a {2}", new Object[] { "This", "test", "test", "test" }),
            "This is a test");
        Assert.assertEquals(MessageFormat.format("{1} {2} {1}", new Object[0]), "{1} {2} {1}");
        Assert.assertEquals(MessageFormat.format("{1} {2} {1}", (Object[]) null), "{1} {2} {1}");
    }

}
