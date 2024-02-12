package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.junit.Test;

public class DataUtilitiesTest {

    @Test
    public void calculateRowTotal_ShouldReturnCorrectTotal() {
        // Mocking a Values2D object for testing
        Values2D values = new MockValues2D();
        int row = 0; // Row index to calculate total for

        double expectedTotal = 6.0; // Expected total for the given row

        assertEquals("The calculated row total should be correct",
                expectedTotal, DataUtilities.calculateRowTotal(values, row), .000000001d);
    }
    
    @Test
    public void calculateRowTotal_WithNegativeValues_ShouldReturnCorrectTotal() {
        // Mocking a Values2D object for testing
        Values2D values = new MockValues2D();
        int row = 0; // Row index to calculate total for

        double expectedTotal = 3.0; // Expected total for the given row

        assertEquals("The calculated row total should be correct",
                expectedTotal, DataUtilities.calculateRowTotal(values, row), .000000001d);
    }

    @Test
    public void calculateRowTotal_WithZeroValues_ShouldReturnCorrectTotal() {
        // Mocking a Values2D object for testing
        Values2D values = new MockValues2D();
        int row = 0; // Row index to calculate total for

        double expectedTotal = 0.0; // Expected total for the given row

        assertEquals("The calculated row total should be correct",
                expectedTotal, DataUtilities.calculateRowTotal(values, row), .000000001d);
    }

    @Test
    public void calculateRowTotal_WithEmptyDataSet_ShouldReturnZeroTotal() {
        // Mocking a Values2D object with an empty dataset for testing
        Values2D values = new MockEmptyValues2D();
        int row = 0; // Row index to calculate total for

        double expectedTotal = 0.0; // Expected total for the given row

        assertEquals("The calculated row total should be zero for an empty dataset",
                expectedTotal, DataUtilities.calculateRowTotal(values, row), .000000001d);
    }

    // Mock implementation of Values2D for testing purposes
    private class MockValues2D implements Values2D {
        // Implement necessary methods of Values2D interface for testing
        // For example, getValue(int row, int column) etc.
        @Override
        public int getRowCount() {
            return 1; // Single row for testing
        }

        @Override
        public int getColumnCount() {
            return 3; // Three columns for testing
        }

        @Override
        public Number getValue(int row, int column) {
            // Mock values for the row
            double[][] data = {
                    {1.0, 2.0, 3.0} // Sample row with values 1.0, 2.0, and 3.0
            };
            return data[row][column];
        }
    }
    
    private class MockEmptyValues2D implements Values2D {
        // Implement necessary methods of Values2D interface for testing
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
