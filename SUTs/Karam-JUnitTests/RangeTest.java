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
//    	exampleRange = new Range(-1, 1);
    }
   
    @Test
    public void upperBoundReturnsWhenEqualLowerBound() {
    	exampleRange = new Range(1.0, 1.0);
    	assertEquals(1.0, exampleRange.getUpperBound(), .000000001d);
    }
    @Test
    public void upperBoundReturnsWhenGreaterThanLowerBound() {
    	exampleRange = new Range(1.0, 5.0);
    	assertEquals(5.0, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void upperBoundFailsWhenLessThanLowerBound() throws IllegalArgumentException {
    	exampleRange = new Range(5.0, 1.0);
    	assertEquals(1.0, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void upperBoundReturnsWhenGreaterThanLowerBound_BVT_ALB() {
    	exampleRange = new Range(1.0, 1.0001);
    	assertEquals(1.0001, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void upperBoundFailsWhenLessThanLowerBound_BVT_BLB() throws IllegalArgumentException {
    	exampleRange = new Range(5.0, 4.9999);
    	assertEquals(4.9999, exampleRange.getUpperBound(), .000000001d);
    }
   
    @Test
    public void upperBoundReturnsEvenWhenNegative() {
    	exampleRange = new Range(-10, -9);
    	assertEquals(-9, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void upperBoundExtremeDecimalPlaces() {
    	exampleRange = new Range(1.0, 1.000000001);
    	assertEquals(1.000000001, exampleRange.getUpperBound(), .000000001d);
    }
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
