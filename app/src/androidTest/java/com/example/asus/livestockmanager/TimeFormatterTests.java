package com.example.asus.livestockmanager;

import android.test.InstrumentationTestCase;

import BusinessEntities.TimeFormatter;

/**
 * Created by asus on 17/02/2016.
 */
public class TimeFormatterTests extends InstrumentationTestCase {

    public void test_TimeFormatter_FormatsTimeCorrectly_ReturnTrue() {
        String time = "Mon Feb 15 12:45:00 GMT+00:00 2015";
        assertTrue(TimeFormatter.formatTimeForDisplay(time).equals("12:45:00"));
    }

    public void test_TimeFormatter_FormatsTimeCorrectly_ReturnsFalse() {
        String time = "Mon Feb 15 12:45:00 GMT+00:00 2015";
        assertFalse(TimeFormatter.formatTimeForDisplay(time).equals("12:45:00:00"));
    }
}
