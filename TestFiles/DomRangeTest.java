package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range; 
import org.junit.*;
import org.junit.Test;

public class RangeTest {
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {}

	@Before
	public void setUp() throws Exception {}

	@Test
	public void testGetLength_ZeroLength() {
		Range zeroRange = new Range(1, 1);
		assertEquals("The length of 1 to 1 should be 0", 0, zeroRange.getLength(), .000000001d);
	}

	@Test
	public void testGetLength_PositiveLength() {
		Range fourRange = new Range(1, 5);
		assertEquals("The length of 1 to 5 should be 4", 5, fourRange.getLength(), .000000001d);
	}
	
	@Test
	public void testGetLength_InfiniteLength() {
		Range infRange = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		assertEquals("The length of -inf to +inf should be +inf", Double.POSITIVE_INFINITY, infRange.getLength(), .000000001d);
	}
	
	@Test
	public void testGetLength_FractionLength() {
		Range fracRange = new Range(0.99, 2);
		assertEquals("The length of 0.99 to 2 should be 1.01", 1.01, fracRange.getLength(), .000000001d);
	}

	@Test
	public void testGetLength_NullLength() {
		Range nullRange = new Range(Double.NaN, Double.NaN);
		assertEquals("The length of NaN to NaN should be null", null, nullRange.getLength(), .000000001d);
	}

	@After
	public void tearDown() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

}
