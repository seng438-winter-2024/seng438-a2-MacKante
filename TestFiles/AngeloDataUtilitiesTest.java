package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.junit.Test;

public class DataUtilitiesTest {

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
