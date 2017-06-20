package model;

import static org.junit.Assert.assertEquals;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExampleTest {
    private Example example;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }


    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testGetName() {
        final String expected = "Example test";
        assertEquals(expected, this.example.getName());
    }

    @Test
    public void testSetName() {
        String expected = "Example test";
        assertEquals(expected, this.example.getName());
        expected = "Example test modified";
        this.example.setName(expected);
        assertEquals(expected, this.example.getName());
    }

    @Test
    public void testToString() {
        final String expected = "1 : Example test";
        assertEquals(expected, this.example.toString());
    }

}