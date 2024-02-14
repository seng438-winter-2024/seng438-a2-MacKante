## SUT for getCentralValue

### Test Case 1: Central value of a range from -1 to 1 should be 0
**Input:** -1 and 1
**Expected Output:** 0 
**Actual Output:** 0

### Test Case 2: Central value of a range from 0 to 1 should be 0.5
**Input:** 0 and 1
**Expected Output:** 0.5 
**Actual Output:** 0.5

### Test Case 3: Central value of a range from -2 to 2 should be 0
**Input:** -2 and 2
**Expected Output:** 0 
**Actual Output:** 0

### Test Case 4: Central value of a range from -55 to 100 should be 22.5
**Input:** -55 and 100
**Expected Output:** 22.5 
**Actual Output:** 22.5

### Test Case 5: Central value of a range from -10 to -5 should be -7.5
**Input:** -10 and -5
**Expected Output:** -7.5 
**Actual Output:** -7.5

### Test Case 6: Central value of a range from 0 to 0 should be 0
**Input:** 0 and 0
**Expected Output:** 0
**Actual Output:** 0






## SUT for calculateRowTotal

### Test Case 1: calculateRowTotal_ShouldReturnCorrectTotal
**Input:** row = 1 and column = 3
**Expected Output:** 6.0
**Actual Output:** 3.0

### Test Case 2: calculateRowTotal_WithNegativeValues_ShouldReturnCorrectTotal
**Input:** row = 1 and column = 3
**Expected Output:** 0
**Actual Output:** 3.0

### Test Case 3: calculateRowTotal_WithZeroValues_ShouldReturnCorrectTotal
**Input:** 0
**Expected Output:** 0 
**Actual Output:** 0

### Test Case 4: calculateRowTotal_WithEmptyDataSet_ShouldReturnZeroTotal
**Input:** Empty Dataset
**Expected Output:** 0
**Actual Output:** 0
