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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gwtbootstrap3.client.ui.BaseGwt;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.form.validator.ValidationChangedEvent.ValidationChangedHandler;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.user.client.Command;

/**
 * Tests for {@link MessageFormat}.
 * 
 * @author Steven Jardine
 */
public class ValidatorsGwt extends BaseGwt {

    /**
     * Test the {@link BlankValidator} class.
     */
    public void testBlankValidator() {
        BlankValidator<String> v = new BlankValidator<String>();
        List<EditorError> errors = v.validate(null, null);
        assertFalse(errors.isEmpty());
        errors = v.validate(null, "");
        assertFalse(errors.isEmpty());
        errors = v.validate(null, "Test");
        assertTrue(errors.isEmpty());

        BlankValidator<Date> dv = new BlankValidator<Date>();
        errors = dv.validate(null, null);
        assertFalse(errors.isEmpty());
        errors = dv.validate(null, new Date());
        assertTrue(errors.isEmpty());
    }

    /**
     * Test the {@link DecimalMaxValidator} class.
     */
    public void testDecimalMaxValidator() {
        DecimalMaxValidator<Double> v = new DecimalMaxValidator<Double>(1.25);
        List<EditorError> errors = v.validate(null, null);
        assertTrue(errors.isEmpty());
        errors = v.validate(null, -2.0);
        assertTrue(errors.isEmpty());
        errors = v.validate(null, 0.0);
        assertTrue(errors.isEmpty());
        errors = v.validate(null, 1.25);
        assertTrue(errors.isEmpty());
        errors = v.validate(null, 2.0);
        assertFalse(errors.isEmpty());
    }

    /**
     * Test the {@link DecimalMinValidator} class.
     */
    public void testDecimalMinValidator() {
        DecimalMinValidator<Float> v = new DecimalMinValidator<Float>(1.25f);
        List<EditorError> errors = v.validate(null, null);
        assertTrue(errors.isEmpty());
        errors = v.validate(null, -2.0f);
        assertFalse(errors.isEmpty());
        errors = v.validate(null, 0.0f);
        assertFalse(errors.isEmpty());
        errors = v.validate(null, 1.25f);
        assertTrue(errors.isEmpty());
        errors = v.validate(null, 2.0f);
        assertTrue(errors.isEmpty());
    }

    /**
     * Test the {@link FieldMatchValidator} class.
     */
    public void testFieldMatchValidator() {
        TextBox field1 = new TextBox();
        TextBox field2 = new TextBox();

        field1.setValue("1234");
        field2.setValue(field1.getValue());
        field2.addValidator(new FieldMatchValidator<String>(field1));
        assertTrue(field2.validate());

        field2.setValue("12345");
        assertFalse(field2.validate());
    }

    /**
     * Test the {@link FutureValidator} class.
     */
    public void testFutureValidator() {
        FutureValidator v = new FutureValidator();
        List<EditorError> errors = v.validate(null, null);
        assertTrue(errors.isEmpty());

        long now = new Date().getTime();
        // One minute ago.
        errors = v.validate(null, new Date(now - (60 * 1000)));
        assertFalse(errors.isEmpty());
        // One minute from now.
        errors = v.validate(null, new Date(now + (60 * 1000)));
        assertTrue(errors.isEmpty());
    }

    /**
     * Test the {@link PastValidator} class.
     */
    public void testPastValidator() {
        PastValidator v = new PastValidator();
        List<EditorError> errors = v.validate(null, null);
        assertTrue(errors.isEmpty());

        long now = new Date().getTime();
        // One minute ago.
        errors = v.validate(null, new Date(now - (60 * 1000)));
        assertTrue(errors.isEmpty());
        // One minute from now.
        errors = v.validate(null, new Date(now + (60 * 1000)));
        assertFalse(errors.isEmpty());
    }

    /**
     * Test the {@link RegExValidator} class.
     */
    public void testRegExValidator() {
        String pattern = "^\\d{3}-\\d{3}-\\d{4}(\\sx\\d{1,5})?$";
        RegExValidator v = new RegExValidator(pattern);
        List<EditorError> errors = v.validate(null, null);
        assertTrue(errors.isEmpty());
        errors = v.validate(null, "");
        assertFalse(errors.isEmpty());
        errors = v.validate(null, "123-123-1234");
        assertTrue(errors.isEmpty());
        errors = v.validate(null, "123-123-1234 x111");
        assertTrue(errors.isEmpty());
        errors = v.validate(null, "123-123-1234 x123456");
        assertFalse(errors.isEmpty());
        errors = v.validate(null, "123-123-1a34");
        assertFalse(errors.isEmpty());
    }

    /**
     * Test the {@link SizeValidator} class.
     */
    public void testSizeValidator() {
        SizeValidator<String> sv = new SizeValidator<String>(5, 10);
        List<EditorError> errors = sv.validate(null, null);
        assertFalse(errors.isEmpty());

        errors = sv.validate(null, "1234");
        assertFalse(errors.isEmpty());
        errors = sv.validate(null, "12345");
        assertTrue(errors.isEmpty());
        errors = sv.validate(null, "123456");
        assertTrue(errors.isEmpty());
        errors = sv.validate(null, "1234567");
        assertTrue(errors.isEmpty());
        errors = sv.validate(null, "12345678");
        assertTrue(errors.isEmpty());
        errors = sv.validate(null, "123456789");
        assertTrue(errors.isEmpty());
        errors = sv.validate(null, "1234567890");
        assertTrue(errors.isEmpty());
        errors = sv.validate(null, "12345678901");
        assertFalse(errors.isEmpty());

        SizeValidator<Collection<String>> cv = new SizeValidator<Collection<String>>(0, 1);
        errors = cv.validate(null, null);
        assertTrue(errors.isEmpty());

        errors = cv.validate(null, new ArrayList<String>());
        assertTrue(errors.isEmpty());
        errors = cv.validate(null, Arrays.asList("test"));
        assertTrue(errors.isEmpty());
        errors = cv.validate(null, Arrays.asList("1", "2"));
        assertFalse(errors.isEmpty());

        SizeValidator<String[]> av = new SizeValidator<String[]>(2, 4);
        errors = av.validate(null, null);
        assertFalse(errors.isEmpty());
        errors = av.validate(null, new String[0]);
        assertFalse(errors.isEmpty());
        errors = av.validate(null, new String[] { "1" });
        assertFalse(errors.isEmpty());
        errors = av.validate(null, new String[] { "1", "2" });
        assertTrue(errors.isEmpty());
        errors = av.validate(null, new String[] { "1", "2" });
        assertTrue(errors.isEmpty());
        errors = av.validate(null, new String[] { "1", "2", "3" });
        assertTrue(errors.isEmpty());
        errors = av.validate(null, new String[] { "1", "2", "3", "4" });
        assertTrue(errors.isEmpty());
        errors = av.validate(null, new String[] { "1", "2", "3", "4", "5" });
        assertFalse(errors.isEmpty());

        SizeValidator<Map<String, String>> mv = new SizeValidator<Map<String, String>>(3, 20);
        errors = mv.validate(null, null);
        assertFalse(errors.isEmpty());

        Map<String, String> map = new HashMap<String, String>();
        for (int count = 1; count <= 25; count++) {
            map.put(Integer.toString(count), Integer.toString(count));
            errors = mv.validate(null, map);
            if (count < 3 || count > 20) {
                assertFalse(errors.isEmpty());
            } else {
                assertTrue(errors.isEmpty());
            }
        }
    }

    public void testGroupValidators() {

        final TextBox box1 = new TextBox();
        box1.setAllowBlank(false);
        final TextBox box2 = new TextBox();
        box2.setAllowBlank(false);
        final TextBox box3 = new TextBox();
        box3.setAllowBlank(false);

        assertFalse(box1.validate(false));
        assertFalse(box2.validate(false));
        assertFalse(box3.validate(false));

        GroupValidator validatorGroup = new GroupValidator();
        validatorGroup.add(box1);
        validatorGroup.add(box2);
        validatorGroup.add(box3);

        box1.setValue("box1");
        assertFalse(validatorGroup.validate(false));
        box2.setValue("box2");
        assertFalse(validatorGroup.validate(false));
        box3.setValue("box3");
        assertTrue(validatorGroup.validate(false));

        validatorGroup.addValidationChangedHandler(new ValidationChangedHandler() {
            @Override
            public void onValidationChanged(ValidationChangedEvent event) {
                assertFalse(event.isValid());
                finishTest();
            }
        });

        delayTestFinish(500);
        Scheduler.get().scheduleDeferred(new Command() {
            @Override
            public void execute() {
                box1.setValue("", true);
            }
        });

    }

}
