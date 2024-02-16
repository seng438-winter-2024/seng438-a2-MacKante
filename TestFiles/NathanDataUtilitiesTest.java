package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
 
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
	
}
