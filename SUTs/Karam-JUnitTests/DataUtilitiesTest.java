package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jmock.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues; 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	private Mockery context;
	private Values2D values2DMock;
	private KeyedValues keyedValuesMock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
        // Create a new mockery
        context = new Mockery();

        // Create a mock for Values2D
        values2DMock = context.mock(Values2D.class);
        
        // Create a mock for Values2D
        keyedValuesMock = context.mock(KeyedValues.class);
	}

	@After
	public void tearDown() throws Exception {
        // Shutdown the mockery
        context.assertIsSatisfied();
	}

	@Test(expected=InvalidParameterException.class)
	public void testCalculateColumnTotalUsingNullAsDataArgument() {
		assertEquals(0, DataUtilities.calculateColumnTotal(null, 0), .000000001d);
	}
	
	@Test
	public void testCalculateColumnTotalZeroRows() {

        // Define expectations for the mock
        context.checking(new Expectations() {{
        	oneOf(values2DMock).getColumnCount();
            will(returnValue(5));
            oneOf(values2DMock).getRowCount();
            will(returnValue(0));
        }});

        double result = DataUtilities.calculateColumnTotal(values2DMock, 1);

        // Verify the result
        assertEquals(0, result, 0.0001);
    }
	
	@Test
	public void testCalculateColumnTotalZeroColumns() {

        // Define expectations for the mock
        context.checking(new Expectations() {{
        	oneOf(values2DMock).getColumnCount();
            will(returnValue(0));
            oneOf(values2DMock).getRowCount();
            will(returnValue(5));
        }});

        double result = DataUtilities.calculateColumnTotal(values2DMock, 1);

        // Verify the result
        assertEquals(0, result, 0.0001); // With invalid input, a total of zero will be returned.
    }
	
	@Test
	public void testCalculateColumnTotalNegativeColumnArg_BLB() {
        double result = DataUtilities.calculateColumnTotal(values2DMock, -1);

        // Verify the result
        assertEquals(0, result, 0.0001); // With invalid input, a total of zero will be returned.
    }
	
	@Test
	public void testCalculateColumnTotalColumnEqualsZero_LB() {
        // Define expectations for the mock
        context.checking(new Expectations() {{
        	// column count should always be called to check that the argument is within boundary
            oneOf(values2DMock).getColumnCount();
            will(returnValue(5));
            oneOf(values2DMock).getRowCount();
            will(returnValue(5));
            exactly(5).of(values2DMock).getValue(with(any(int.class)), with(0));
            will(returnValue(10));

        }});

        double result = DataUtilities.calculateColumnTotal(values2DMock, 0);

        // Verify the result
        assertEquals(50, result, 0.0001); // With invalid input, a total of zero will be returned.

    }
	
	@Test
	public void testCalculateColumnTotalColumnIsNominal() {
        // Define expectations for the mock
        context.checking(new Expectations() {{
        	// column count should always be called to check that the argument is within boundary
            oneOf(values2DMock).getColumnCount();
            will(returnValue(5));
            oneOf(values2DMock).getRowCount();
            will(returnValue(5));
            exactly(5).of(values2DMock).getValue(with(any(int.class)), with(2));
            will(returnValue(10));
        }});

        double result = DataUtilities.calculateColumnTotal(values2DMock, 2);

        // Verify the result
        assertEquals(50, result, 0.0001); // With invalid input, a total of zero will be returned.
    }
	
	@Test
	public void testCalculateColumnTotalColumnIsAtUB() {
        // Define expectations for the mock
        context.checking(new Expectations() {{
        	// column count should always be called to check that the argument is within boundary
            oneOf(values2DMock).getColumnCount();
            will(returnValue(5));
        }});

        // here, column is out of bounds
        double result = DataUtilities.calculateColumnTotal(values2DMock, 5);

        // Verify the result
        assertEquals(50, result, 0.0001); // With invalid input, a total of zero will be returned.
    }
	
	@Test
	public void testCalculateColumnTotalColumnIsAUB() {

        context.checking(new Expectations() {{
            oneOf(values2DMock).getColumnCount();
            will(returnValue(1));
        }});
        // if column arg is too large, doesn't need to find row count and just returns 0
        double result = DataUtilities.calculateColumnTotal(values2DMock, 5);

        // Verify the result
        assertEquals(0, result, 0.0001); // With invalid input, a total of zero will be returned.


    }	
	
	@Test
	public void testGetCumulativePercentagesEmptyDataArg() {
		context.checking(new Expectations() {{
			atLeast(1).of(keyedValuesMock).getItemCount();
			will(returnValue(0));
		}});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValuesMock);
		
		assertNotNull(result);
		assertEquals(0, result.getItemCount()); // check that its empty too
	}
	
	@Test(expected=InvalidParameterException.class)
	public void testGetCumulativePercentagesNullDataArg() {

		KeyedValues result = DataUtilities.getCumulativePercentages(null);
		
		assertNotNull(result);
		assertEquals(0, result.getItemCount()); // check that its empty too
	}
	
	@Test
	public void testGetCumulativePercentagesExampleFromDocs() {
		context.checking(new Expectations() {{
			atLeast(1).of(keyedValuesMock).getItemCount();
			will(returnValue(3));
			
			oneOf(keyedValuesMock).getKey(0);
			will(returnValue(0));
			
			oneOf(keyedValuesMock).getKey(1);
			will(returnValue(1));
			
			oneOf(keyedValuesMock).getKey(2);
			will(returnValue(2));
			
			atLeast(1).of(keyedValuesMock).getValue(0);
			will(returnValue(5));
			
			atLeast(1).of(keyedValuesMock).getValue(1);
			will(returnValue(9));
			
			atLeast(1).of(keyedValuesMock).getValue(2);
			will(returnValue(2));
		}});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValuesMock);
		
		assertNotNull(result);
		assertEquals(3, result.getItemCount());
		assertEquals(0.3125, result.getValue(0));
		assertEquals(0.875, result.getValue(1));
		assertEquals(1.0, result.getValue(2));
	}
	
	@Test
	public void testGetCumulativePercentagesWithNegativeNumbers() {
		context.checking(new Expectations() {{
			atLeast(1).of(keyedValuesMock).getItemCount();
			will(returnValue(3));
			
			oneOf(keyedValuesMock).getKey(0);
			will(returnValue(0));
			
			oneOf(keyedValuesMock).getKey(1);
			will(returnValue(1));
			
			oneOf(keyedValuesMock).getKey(2);
			will(returnValue(2));
			
			atLeast(1).of(keyedValuesMock).getValue(0);
			will(returnValue(-5));
			
			atLeast(1).of(keyedValuesMock).getValue(1);
			will(returnValue(9));
			
			atLeast(1).of(keyedValuesMock).getValue(2);
			will(returnValue(2));
		}});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValuesMock);
		
		assertNotNull(result);
		assertEquals(3, result.getItemCount());
		assertEquals(1.0, result.getValue(2));
	}
	
	@Test
	public void testGetCumulativePercentagesWithAZero() {
		context.checking(new Expectations() {{
			atLeast(1).of(keyedValuesMock).getItemCount();
			will(returnValue(3));
			
			oneOf(keyedValuesMock).getKey(0);
			will(returnValue(0));
			
			oneOf(keyedValuesMock).getKey(1);
			will(returnValue(1));
			
			oneOf(keyedValuesMock).getKey(2);
			will(returnValue(2));
			
			atLeast(1).of(keyedValuesMock).getValue(0);
			will(returnValue(5));
			
			atLeast(1).of(keyedValuesMock).getValue(1);
			will(returnValue(0));
			
			atLeast(1).of(keyedValuesMock).getValue(2);
			will(returnValue(2));
		}});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValuesMock);
		
		assertNotNull(result);
		assertEquals(3, result.getItemCount());
		assertEquals(5.0/7, result.getValue(0));
		assertEquals(5.0/7, result.getValue(1));
		assertEquals(1.0, result.getValue(2));
	}
	
	@Test
	public void testGetCumulativePercentagesWithAllZeros() {
		context.checking(new Expectations() {{
			atLeast(1).of(keyedValuesMock).getItemCount();
			will(returnValue(3));
			
			oneOf(keyedValuesMock).getKey(0);
			will(returnValue(0));
			
			oneOf(keyedValuesMock).getKey(1);
			will(returnValue(1));
			
			oneOf(keyedValuesMock).getKey(2);
			will(returnValue(2));
			
			atLeast(1).of(keyedValuesMock).getValue(0);
			will(returnValue(0));
			
			atLeast(1).of(keyedValuesMock).getValue(1);
			will(returnValue(0));
			
			atLeast(1).of(keyedValuesMock).getValue(2);
			will(returnValue(0));
		}});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValuesMock);
		
		assertNotNull(result);
		assertEquals(3, result.getItemCount());
		// division by 0
		assertEquals(0.0, result.getValue(0));
		assertEquals(0.0, result.getValue(1));
		assertEquals(0.0, result.getValue(2));
	}
	
	@Test
	public void testGetCumulativePercentagesWithAllNulls() {
		context.checking(new Expectations() {{
			atLeast(1).of(keyedValuesMock).getItemCount();
			will(returnValue(3));
			
			oneOf(keyedValuesMock).getKey(0);
			will(returnValue(0));
			
			oneOf(keyedValuesMock).getKey(1);
			will(returnValue(1));
			
			oneOf(keyedValuesMock).getKey(2);
			will(returnValue(2));
			
			atLeast(1).of(keyedValuesMock).getValue(0);
			will(returnValue(null));
			
			atLeast(1).of(keyedValuesMock).getValue(1);
			will(returnValue(null));
			
			atLeast(1).of(keyedValuesMock).getValue(2);
			will(returnValue(null));
		}});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValuesMock);
		
		assertNotNull(result);
		assertEquals(3, result.getItemCount());
		// division by 0
		assertEquals(5.0/0.0, result.getValue(0));
		assertEquals(0.0, result.getValue(1));
		assertEquals(0.0, result.getValue(2));
	}
}
