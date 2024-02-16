package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { 
    }
   
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * check if the upper bound is returned correctly when it is equal to the lower bound
     */
    @Test
    public void testUpperBound_ReturnsWhenEqualLowerBound() {
    	exampleRange = new Range(1.0, 1.0);
    	assertEquals(1.0, exampleRange.getUpperBound(), .000000001d);
    }
    
    /**
     * check if the upper bound is returned correctly when it is greater than the lower bound
     */
    @Test
    public void testUpperBound_ReturnsWhenGreaterThanLowerBound() {
    	exampleRange = new Range(1.0, 5.0);
    	assertEquals(5.0, exampleRange.getUpperBound(), .000000001d);
    }
    
    /**
     * check if an exception is thrown when the upper bound is less than the lower bound
     * @throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testUpperBound_FailsWhenLessThanLowerBound() throws IllegalArgumentException {
    	exampleRange = new Range(5.0, 1.0);
    	assertEquals(1.0, exampleRange.getUpperBound(), .000000001d);
    }
    
    /**
     * check if the upper bound is returned correctly when it is very close to the lower bound using decimal places
     */
    @Test
    public void testUpperBound_ReturnsWhenGreaterThanLowerBound_BVT_ALB() {
    	exampleRange = new Range(1.0, 1.0001);
    	assertEquals(1.0001, exampleRange.getUpperBound(), .000000001d);
    }
    
    /**
     * check if an exception is thrown when the upper bound is less than the lower bound using decimal places
     * @throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testUpperBound_FailsWhenLessThanLowerBound_BVT_BLB() throws IllegalArgumentException {
    	exampleRange = new Range(5.0, 4.9999);
    	assertEquals(4.9999, exampleRange.getUpperBound(), .000000001d);
    }
   
    /**
     * check if the upper bound is returned correctly when it is negative
     */
    @Test
    public void testUpperBound_ReturnsEvenWhenNegative() {
    	exampleRange = new Range(-10, -9);
    	assertEquals(-9, exampleRange.getUpperBound(), .000000001d);
    }
    
    /**
     * check if the upper bound is returned correctly using more extreme decimal places
     */
    @Test
    public void testUpperBound_ExtremeDecimalPlaces() {
    	exampleRange = new Range(1.0, 1.000000001);
    	assertEquals(1.000000001, exampleRange.getUpperBound(), .000000001d);
    }
}
