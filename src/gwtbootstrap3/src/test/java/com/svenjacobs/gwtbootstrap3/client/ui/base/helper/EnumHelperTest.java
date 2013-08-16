package com.svenjacobs.gwtbootstrap3.client.ui.base.helper;

import com.svenjacobs.gwtbootstrap3.client.ui.constants.Pull;
import org.junit.Test;

import static com.svenjacobs.gwtbootstrap3.client.ui.base.helper.EnumHelper.fromStyleName;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Sven Jacobs
 */
public class EnumHelperTest {

    @Test
    public void testFromStyleName() {
        assertThat(fromStyleName("123 pull-left abc", Pull.class, null), is(Pull.LEFT));
        assertThat(fromStyleName("123 pull-right abc", Pull.class, null), is(Pull.RIGHT));
        assertThat(fromStyleName("pull-left pull-right abc", Pull.class, null), is(Pull.LEFT));
        assertThat(fromStyleName("123 abc", Pull.class, null), is(nullValue()));
        assertThat(fromStyleName("123 abc", Pull.class, Pull.LEFT), is(Pull.LEFT));
        assertThat(fromStyleName("123 abc", null, null), is(nullValue()));
        assertThat(fromStyleName(null, Pull.class, null), is(nullValue()));
    }
}
