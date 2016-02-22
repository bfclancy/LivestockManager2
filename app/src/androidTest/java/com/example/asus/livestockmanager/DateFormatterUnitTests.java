package com.example.asus.livestockmanager;

import android.test.InstrumentationTestCase;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.Time;
import java.text.ParseException;
import java.util.Date;

import BusinessEntities.DateFormatter;

/**
 * Created by asus on 16/02/2016.
 */
public class DateFormatterUnitTests extends InstrumentationTestCase{

    public void test_DateFormatter_formatDateCorrectly_returnsTrue() throws Exception {
        String date = "Mon Feb 15 00:00:00 GMT+00:00 2015";
        assertTrue(DateFormatter.formatForDisplay(date).equals("15/02/2015"));
    }

    public void test_DateFormatter_formatDateCorrectly_returnsFalse() throws Exception {
        String date = "Mon Feb 15 00:00:00 GMT+00:00 2015";
        assertFalse(DateFormatter.formatForDisplay(date).equals("15/02/2014"));
    }

    public void test_DateFormatter_ReturnCorrectDateObject_returnsTrue(){
        String date = "Mon Feb 15 00:00:00 GMT+00:00 2015";
        assertTrue(DateFormatter.convertStringToDate(date) instanceof Date);
    }

    public void test_DateFormatter_ReturnIncorrectDateObject_returnsFalse(){
        String date = "Mon Feb 15 00:00:00 GMT+00:00 2015";
        assertFalse(DateFormatter.convertStringToDate(date) instanceof Time);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test (expected = ParseException.class)
    public void test_DateFormatterThrowsRuntimeException_ReturnsTrue(){
        DateFormatter.formatForDisplay("33,33,33,33");
    }
}
