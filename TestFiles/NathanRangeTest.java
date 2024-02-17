package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range anotherExampleRange;
    private Range nullRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-3, 5);  	
    	anotherExampleRange = new Range(-14, 11);
    	nullRange = new Range(Double.NaN, Double.NaN);
    }
    
    /*------------------------- getLowerBound -------------------------*/
    @Test
    public void testPositiveLowerBound() {
    	Range positiveLowerBound = new Range(5, 10);
    	Range barelyPositiveLowerBound = new Range(0.1, 3);
    	
    	assertEquals("The lower bound value should be 5", 
    			5, positiveLowerBound.getLowerBound(), .000000001d);
    	
    	assertEquals("The lower bound value should be 0.1", 
    			0.1, barelyPositiveLowerBound.getLowerBound(), .000000001d);
    }
    
    @Test
    public void testNegativeLowerBound() {
    	Range negativeLowerBound = new Range(-3, 6);
    	Range barelyNegativeLowerBound = new Range(-0.1, 2);
    	
    	assertEquals("The lower bound value should be -3", 
    			-3, negativeLowerBound.getLowerBound(), .000000001d);
    	
    	assertEquals("The lower bound value should be -0.1", 
    			-0.1, barelyNegativeLowerBound.getLowerBound(), .000000001d);
    }
    
    @Test
    public void testZeroLowerBound() {
    	Range zeroLowerBound = new Range(0, 10);
    	Range barelyZeroLowerBoundPostive = new Range(0.0000001, 5);
    	Range barelyZeroLowerBoundNegative = new Range(-0.0000001, 3);
    	
    	assertEquals("The lower bound value should be 0", 
    			0, zeroLowerBound.getLowerBound(), .000000001d);
    	
    	assertEquals("The lower bound value should be 0.0000001", 
    			0.0000001, barelyZeroLowerBoundPostive.getLowerBound(), .000000001d);
    	
    	assertEquals("The lower bound value should be -0.0000001", 
    			-0.0000001, barelyZeroLowerBoundNegative.getLowerBound(), .000000001d);
    }
    
    @Test
    public void testNullLowerBound() {
    	assertTrue("The lower bound should be null", Double.isNaN(nullRange.getLowerBound()));
    }
    

    /*------------------------- contains -------------------------*/
    
    @Test
    public void testContains_ValueInRange() {
    	assertTrue("Range should contain 2", exampleRange.contains(2));
    	assertTrue("Range should contain -1", exampleRange.contains(-1));
    	assertTrue("Range should contain 2", exampleRange.contains(0));
    }
    
    @Test
    public void testContains_ValueNotInRange() {
    	assertFalse("Range should not contain -5", exampleRange.contains(-5));
    	assertFalse("Range should not contain 8", exampleRange.contains(8));
    }
    
    @Test
    public void testContains_LowerBound() {
    	assertTrue("Range should contain -3", exampleRange.contains(-3));
    	assertTrue("Range should contain -2.9999", exampleRange.contains(-2.9999));
    	assertFalse("Range should not contain -3.0001", exampleRange.contains(-3.0001));
    	
    	assertTrue("Range should contain -14", anotherExampleRange.contains(-14));
    	assertTrue("Range should contain -13.9999", anotherExampleRange.contains(-13.9999));
    	assertFalse("Range should not contain -14.0001", anotherExampleRange.contains(-14.0001));
    }
    
    @Test
    public void testContains_UpperBound() {
    	assertTrue("Range should contain 5", exampleRange.contains(5));
    	assertTrue("Range should contain 4.9999", exampleRange.contains(4.9999));
    	assertFalse("Range should not contain 5.0001", exampleRange.contains(5.0001));
    	
    	assertTrue("Range should contain 11", anotherExampleRange.contains(11));
    	assertTrue("Range should contain 10.9999", anotherExampleRange.contains(10.9999));
    	assertFalse("Range should not contain 11.0001", anotherExampleRange.contains(11.0001));
    }
    
    @Test
    public void testContains_NullRange() {
    	assertFalse("Range should not contain anything", nullRange.contains(0));
    	assertFalse("Range should not contain anything", nullRange.contains(12));
    	assertFalse("Range should not contain anything", nullRange.contains(-5));
    }    
    
    /*------------------------- After stuff -------------------------*/
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
