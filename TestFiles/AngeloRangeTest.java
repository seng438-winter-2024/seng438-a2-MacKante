package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        // Set up the exampleRange object before each test case
        exampleRange = null; // Initialize to null to avoid potential issues
    }

    // Test case 1: Central value of a range from -1 to 1 should be 0
    @Test
    public void centralValueShouldBeZero() {
        exampleRange = new Range(-1, 1);
        assertEquals("The central value of -1 and 1 should be 0",
                0, exampleRange.getCentralValue(), .000000001d);
    }

    // Test case 2: Central value of a range from 0 to 1 should be 0.5
    @Test
    public void centralValueShouldBeZeroPointFive() {
        exampleRange = new Range(0, 1);
        assertEquals("The central value of 0 and 1 should be 0.5",
                0.5, exampleRange.getCentralValue(), .000000001d);
    }

    // Test case 3: Central value of a range from -2 to 2 should be 0
    @Test
    public void centralValueShouldBeZeroForWideRange() {
        exampleRange = new Range(-2, 2);
        assertEquals("The central value of -2 and 2 should be 0",
                0, exampleRange.getCentralValue(), .000000001d);
    }

    // Test case 4: Central value of a range from -55 to 100 should be 22.5
    @Test
    public void centralValueShouldBeTwentyTwoPointFive() {
        exampleRange = new Range(-55, 100);
        assertEquals("The central value of -55 and 100 should be 22.5",
                22.5, exampleRange.getCentralValue(), .000000001d);
    }

    // Test case 5: Test for range with negative upper and lower bounds
    @Test
    public void negativeBounds() {
        exampleRange = new Range(-10, -5);
        assertEquals("The central value of -55 and 100 should be -7.5",
                -7.5, exampleRange.getCentralValue(), .000000001d);
    }

    // Test case 6: Test for range with zero bounds
    @Test
    public void zeroBounds() {
        exampleRange = new Range(0, 0);
        assertEquals("The central value of 0 and 0 should be 0",
                0, exampleRange.getCentralValue(), .000000001d);
    }

    @After
    public void tearDown() throws Exception {
        // Clean up resources after each test case if necessary
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
