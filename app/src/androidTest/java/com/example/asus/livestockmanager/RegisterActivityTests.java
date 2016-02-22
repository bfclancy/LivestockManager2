package com.example.asus.livestockmanager;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by asus on 16/02/2016.
 */
public class RegisterActivityTests extends ActivityInstrumentationTestCase2<Register> {

    public RegisterActivityTests() {
        super(Register.class);
    }

    public void testActivityExists() {
        Register activity = getActivity();
        assertNotNull(activity);
    }
}
