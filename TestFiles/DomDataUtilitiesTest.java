package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class DataUtilitiesTest {
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {}
	
	@Before 
	public void setUp() throws Exception {}

	@Test
	public void testCreateNumberArray_PositiveValues() {
		double[] values = {1.0, 2.0, 3.0, 4.0};
		Number[] expected = {1.0, 2.0, 3.0, 4.0};
		Number[] result = DataUtilities.createNumberArray(values);
		assertArrayEquals(expected, result);
	}

	@Test
	public void testCreateNumberArray_NegativeValues() {
		double[] values = {-1.0, -2.0, -3.0, -4.0};
		Number[] expected = {-1.0, -2.0, -3.0, -4.0};
		Number[] result = DataUtilities.createNumberArray(values);
		assertArrayEquals(expected, result);
	}

	@Test
	public void testCreateNumberArray_ZeroValues() {
		double[] values = {0.0, 0.0, 0.0, 0.0};
		Number[] expected = {0.0, 0.0, 0.0, 0.0};
		Number[] result = DataUtilities.createNumberArray(values);
		assertArrayEquals(expected, result);
	}

	@Test
	public void testCreateNumberArray_EmptyArray() {
		double[] values = {};
		Number[] expected = {};
		Number[] result = DataUtilities.createNumberArray(values);
		assertArrayEquals(expected, result);
	}
	
	@After
	public void tearDown() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}
}
