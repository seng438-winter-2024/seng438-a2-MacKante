package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jmock.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	private Mockery context;
	private Values2D values2DMock;
	private KeyedValues keyedValuesMock;

	/*------------------------- Before stuff -------------------------*/
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	/**
	 * Sets up the test cases by creating a new mockery and creating mocks for Values2D and KeyedValues
	 * @throws Exception
	 */
	public void setUp() throws Exception {
        // Create a new mockery
        context = new Mockery();

        // Create a mock for Values2D
        values2DMock = context.mock(Values2D.class);
        
        // Create a mock for Values2D
        keyedValuesMock = context.mock(KeyedValues.class);
	}
	
	/*------------------------- After stuff -------------------------*/

	@After
	/**
	 * Tears down the test cases by shutting down the mockery
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
        // Shutdown the mockery
        context.assertIsSatisfied();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/*------------------------- Tests -------------------------*/
	
	/*------------------------- calculateColumnTotal -------------------------*/

	/**
	 * Test calculateColumnTotal with null as the data argument
	 * Should throw an InvalidParameterException since the data argument is invalid
	 * @throws InvalidParameterException
	 */
	@Test(expected=InvalidParameterException.class)
	public void testCalculateColumnTotal_UsingNullAsDataArgument() throws InvalidParameterException {
		assertEquals(0, DataUtilities.calculateColumnTotal(null, 0), .000000001d);
	}
	
	/**
	 * Check that the method returns 0 when the data argument has no rows
	 */
	@Test
	public void testCalculateColumnTotal_ZeroRows() {

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
	
	/**
	 * Check that the method returns 0 when the data argument has no columns
	 */
	@Test
	public void testCalculateColumnTotal_ZeroColumns() {

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
	
	/**
	 * Check that the method returns 0 when the column argument is negative
	 */
	@Test
	public void testCalculateColumnTotal_NegativeColumnArg_BLB() {
        double result = DataUtilities.calculateColumnTotal(values2DMock, -1);

        // Verify the result
        assertEquals(0, result, 0.0001); // With invalid input, a total of zero will be returned.
    }
	
	/**
	 * Check if the method returns the correct total when the column argument is 0 (LB)
	 */
	@Test
	public void testCalculateColumnTotal_ColumnEqualsZero_LB() {
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
	
	/**
	 * Check if the method returns the correct total when the column argument is a nominal value
	 */
	@Test
	public void testCalculateColumnTotal_ColumnIsNominal() {
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
	
	/**
	 * Check if the method returns 0 when the column argument is out of bounds at the upper bound
	 */
	@Test
	public void testCalculateColumnTotal_ColumnIsAtUB() {
        // Define expectations for the mock
        context.checking(new Expectations() {{
        	// column count should always be called to check that the argument is within boundary
            oneOf(values2DMock).getColumnCount();
            will(returnValue(5));
        }});

        // here, column is out of bounds
        double result = DataUtilities.calculateColumnTotal(values2DMock, 5);

        // Verify the result
        assertEquals(0, result, 0.0001); // With invalid input, a total of zero will be returned.
    }
	
	/**
	 * Check if the method returns 0 when the column argument is out of bounds above the upper bound
	 */
	@Test
	public void testCalculateColumnTotal_ColumnIsAUB() {

        context.checking(new Expectations() {{
            oneOf(values2DMock).getColumnCount();
            will(returnValue(1));
        }});
        // if column arg is too large, doesn't need to find row count and just returns 0
        double result = DataUtilities.calculateColumnTotal(values2DMock, 5);

        // Verify the result
        assertEquals(0, result, 0.0001); // With invalid input, a total of zero will be returned.


    }	
	
	/*------------------------- getCumulativePercentages -------------------------*/

	/**
	 * Check that the result object is empty when the data argument is empty
	 */
	@Test
	public void testGetCumulativePercentages_EmptyDataArg() {
		context.checking(new Expectations() {{
			atLeast(1).of(keyedValuesMock).getItemCount();
			will(returnValue(0));
		}});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValuesMock);
		
		assertNotNull(result);
		assertEquals(0, result.getItemCount()); // check that its empty too
	}
	
	/**
	 * Check that the method throws an InvalidParameterException when the data argument is null
	 * @throws InvalidParameterException
	 */
	@Test(expected=InvalidParameterException.class)
	public void testGetCumulativePercentages_NullDataArg() throws InvalidParameterException {

		KeyedValues result = DataUtilities.getCumulativePercentages(null);
		
		assertNotNull(result);
		assertEquals(0, result.getItemCount()); // check that its empty too
	}
	
	/**
	 * Check that the method returns the correct cumulative percentages for a simple example
	 */
	@Test
	public void testGetCumulativePercentages_ExampleFromDocs() {
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
	
	/**
	 * Check that the method returns the correct cumulative percentages for an example with negative numbers
	 */
	@Test
	public void testGetCumulativePercentages_WithNegativeNumbers() {
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
	
	/**
	 * Check that the method returns the correct cumulative percentages for an example with a zero value
	 */
	@Test
	public void testGetCumulativePercentages_WithAZero() {
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
	
	/**
	 * Check that the method returns NaN as the percentages for an example with all zeros
	 * This is because Java's floating point division has 0.0 / 0.0 = NaN
	 */
	@Test
	public void testGetCumulativePercentages_WithAllZeros() {
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
		// floating point division of 0.0/0.0 = NaN
		assertEquals(0.0/0.0, result.getValue(2));
	}
	
	/**
	 * Check that the method returns a KeyedValues object with nulls for an example with all nulls
	 */
	@Test
	public void testGetCumulativePercentages_WithAllNulls() {
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
		assertEquals(null, result.getValue(0));
		assertEquals(null, result.getValue(1));
		assertEquals(null, result.getValue(2));
	}

	/**
	 * Check that the method returns the correct cumulative percentages for an example with all negative numbers
	 */
	@Test
	public void testGetCumulativePercentages_WithAllNegativeNumbers() {
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
			will(returnValue(-9));
			
			atLeast(1).of(keyedValuesMock).getValue(2);
			will(returnValue(-2));
		}});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValuesMock);
		
		assertNotNull(result);
		assertEquals(3, result.getItemCount());
		// double negative should allow for positive decimal values
		assertEquals(0.3125, result.getValue(0));
		assertEquals(0.875, result.getValue(1));
		assertEquals(1.0, result.getValue(2));
	}
	
	/**
	 * Check that the method returns the correct cumulative percentage for an example with a single value in the data argument
	 */
	@Test
	public void testGetCumulativePercentages_WithSingleValue() {
		context.checking(new Expectations() {{
			atLeast(1).of(keyedValuesMock).getItemCount();
			will(returnValue(1));
			
			oneOf(keyedValuesMock).getKey(0);
			will(returnValue(0));
			
			atLeast(1).of(keyedValuesMock).getValue(0);
			will(returnValue(2));
		}});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValuesMock);
		
		assertNotNull(result);
		assertEquals(1, result.getItemCount());
		assertEquals(1.0, result.getValue(0));
	}

	/**
	 * Check that the method returns the correct cumulative percentages for an example with very small values
	 */
	@Test
	public void testGetCumulativePercentages_WithVerySmallValues() {
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
			will(returnValue(0.0000000000005));
			
			atLeast(1).of(keyedValuesMock).getValue(1);
			will(returnValue(0.0000000000002));
			
			atLeast(1).of(keyedValuesMock).getValue(2);
			will(returnValue(0.0000000000003));
		}});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValuesMock);
		
		assertNotNull(result);
		assertEquals(3, result.getItemCount());
		assertEquals(0.5, result.getValue(0));
		assertEquals(0.7, result.getValue(1));
		assertEquals(1.0, result.getValue(2));
	}
	
	/*------------------------- createNumberArray -------------------------*/
	
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
	
	/*------------------------- calculateRowTotal -------------------------*/
	
    @Test
    public void calculateRowTotal_CorrectTotal() {

        Values2D values = new CreateValues2D(); //calls a constructor for creating a sample values2D for testing purposes
        int row = 0; // assign row to 0

        double expectedTotal = 6.0; // Expected row total
        assertEquals("The calculated row total should be correct",
                expectedTotal, DataUtilities.calculateRowTotal(values, row), .000000001d);
    }
    
    @Test
    public void calculateRowTotalWithNegativeValues_ReturnCorrectTotal() {

        Values2D values = new CreateValues2D(); //calls a constructor for creating a sample values2D for testing purposes
        int row = 0; // assign row to 0

        double expectedTotal = 3.0; // Expected row total

        assertEquals("The calculated row total should be correct",
                expectedTotal, DataUtilities.calculateRowTotal(values, row), .000000001d);
    }

    @Test
    public void calculateRowTotalWithZeroValues_ReturnCorrectTotal() {

        Values2D values = new CreateValues2D(); //calls a constructor for creating a sample values2D for testing purposes
        int row = 0; // assign row to 0

        double expectedTotal = 0.0; // Expected row total

        assertEquals("The calculated row total should be correct",
                expectedTotal, DataUtilities.calculateRowTotal(values, row), .000000001d);
    }

    @Test
    public void calculateRowTotalWithEmptyDataSet_ReturnZeroTotal() {

        Values2D values = new CreateEmptyValues2D(); //calls a constructor for creating a sample values2D without dataset for testing purposes
        int row = 0; // assign row to 0

        double expectedTotal = 0.0; // Expected row total

        assertEquals("The calculated row total should be zero for an empty dataset",
                expectedTotal, DataUtilities.calculateRowTotal(values, row), .000000001d);
    }

	@Test
	 public void testCreateNumberArray2D_ValidArray() {
		 double[][] exampleArray1 = {{0, 1, 5}, {-2, 3, -9}};
		 double[][] exampleArray2 = {{3, 7, -6}, {4, -1, -4}};
		 
		 Number[][] newNumberArray1 = DataUtilities.createNumberArray2D(exampleArray1);
		 Number[][] newNumberArray2 = DataUtilities.createNumberArray2D(exampleArray1);
		 
		 assertNotNull("newNumberArray1 should not be null", newNumberArray1);
		 assertNotNull("newNumberArray2 should not be null", newNumberArray2);
		 
		 for( int i = 0; i <newNumberArray1.length; i++ ) {
			 for( int j = 0;  j < newNumberArray1[i].length; j++ ) {
				 assertTrue("Row: " + i + " Column: " + j + " should be a Number object: " + newNumberArray1[i][j], newNumberArray1[i][j] instanceof Number);
			 }
		 }
	 }
	
	 @Test
	 public void testCreateNumberArray2D_EmptyArray() {
		 double[][] emptyArray = {};
		 Number[][] newNumberArray = DataUtilities.createNumberArray2D(emptyArray);
		 
		 assertEquals("Length should be zero", 0, newNumberArray.length);
	 }
	 
	 @Test
	 public void testCreateNumberArray2D_NullArray() {
		 double[][] nullArray = null;
		 try {
		 	Number[][] newNumberArray = DataUtilities.createNumberArray2D(nullArray);
		 	fail("Should not have created an array will null input, length of new array: " + newNumberArray.length);
		 } catch (Exception e) {
			 assertTrue("Array should be null", true);
		 }
	 }
    
	/*------------------------- Helper Classes -------------------------*/

    // Uses a private class to create Values2D
    private class CreateValues2D implements Values2D {
        //implementing getters for row and column
        @Override
        public int getRowCount() {
            return 1; // only one row
        }

        @Override
        public int getColumnCount() {
            return 3; // only three columns
        }

        @Override
        public Number getValue(int row, int column) {
            // creates sample data with values 1, 2, and 3,
            double[][] data = {
                    {1.0, 2.0, 3.0}
            };
            return data[row][column]; //returns data with one row and three columns
        }
    }
    // Uses a private class to create an empty dataset for Values2D
    private class CreateEmptyValues2D implements Values2D {
        //implementing getters for row and column
        @Override
        public int getRowCount() {
            return 0; // Empty dataset
        }

        @Override
        public int getColumnCount() {
            return 0; // Empty dataset
        }

        @Override
        public Number getValue(int row, int column) {
            return null; // No values in the dataset
        }
    }
	

	
}
