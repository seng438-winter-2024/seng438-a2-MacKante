# Just list the description of your test case, one for each line
# Imma chatgpt it to make us a nice markdown list

testGetLowerBound_PositiveLowerBound
testGetLowerBound_NegativeLowerBound
testGetLowerBound_ZeroLowerBound
testGetLowerBound_NullLowerBound
testContains_ValueInRange
testContains_ValueNotInRange
testContains_LowerBound
testContains_UpperBound
testContains_NullRange
testGetLength_ZeroLength
testGetLength_PositiveLength
testGetLength_NegativeLength
testGetLength_FractionLength
testUpperBound_ExtremeDecimalPlaces
testUpperBound_ReturnsEvenWhenNegative
testUpperBound_FailsWhenLessThanLowerBound_BVT_BLB
testUpperBound_ReturnsWhenGreaterThanLowerBound_BVT_ALB
testUpperBound_FailsWhenLessThanLowerBound
testUpperBound_ReturnsWhenGreaterThanLowerBound
testUpperBound_ReturnsWhenEqualLowerBound
testcentralValueShouldBeZero
testcentralValueShouldBeZeroPointFive
testcentralValueShouldBeZeroForWideRange
testcentralValueShouldBeTwentyTwoPointFive
testnegativeBounds
testzeroBounds

testCreateNumberArray_PositiveValues
testCreateNumberArray_NegativeValues
testCreateNumberArray_ZeroValues
testCreateNumberArray_EmptyArray
testCalculateColumnTotal_UsingNullAsDataArgument
testCalculateColumnTotal_ZeroRows
testCalculateColumnTotal_ZeroColumns
testCalculateColumnTotal_NegativeColumnArg_BLB
testCalculateColumnTotal_ColumnEqualsZero_LB
testCalculateColumnTotal_ColumnIsNominal
testCalculateColumnTotal_ColumnIsAtUB
testCalculateColumnTotal_ColumnIsAUB
testGetCumulativePercentages_EmptyDataArg
testGetCumulativePercentages_NullDataArg
testGetCumulativePercentages_ExampleFromDocs
testGetCumulativePercentages_WithNegativeNumbers
testGetCumulativePercentages_WithAZero
testGetCumulativePercentages_WithAllZeros
testGetCumulativePercentages_WithAllNulls
testGetCumulativePercentages_WithAllNegativeNumbers
testGetCumulativePercentages_WithSingleValue
testGetCumulativePercentages_WithVerySmallValues
testcalculateRowTotal_CorrectTotal
testcalculateRowTotalWithEmptyDataSet_ReturnZeroTotal
testcalculateRowTotalWithZeroValues_ReturnCorrectTotal
testcalculateRowTotalWithNegativeValues_ReturnCorrectTotal
testCreateNumberArray2D_ValidArray 
testCreateNumberArray2D_EmptyArray 
testCreateNumberArray2D_NullArray 

------------------------------------------------------------------------------------------------------
# adD YoUr sTufF hERe
✓☑✅︎

| Test Index                                                | Equivalence Class                         | Boundary Value Analysis       |
|-----------------------------------------------------------|-------------------------------------------|-------------------------------|
| testGetLowerBound_PositiveLowerBound                      |                                           |                               |
| testGetLowerBound_NegativeLowerBound                      |                                           |                               |
| testGetLowerBound_ZeroLowerBound                          |                                           |                               |
| testGetLowerBound_NullLowerBound                          |                                           |                               |
| testContains_ValueInRange                                 |                                           |                               |
| testContains_ValueNotInRange                              |                                           |                               |
| testContains_LowerBound                                   |                                           |                               |
| testContains_UpperBound                                   |                                           |                               |
| testContains_NullRange                                    |                                           |                               |
| testGetLength_ZeroLength                                  |                                           |                               |
| testGetLength_PositiveLength                              |                                           |                               |
| testGetLength_NegativeLength                              |                                           |                               |
| testGetLength_FractionLength                              |                                           |                               |
| testUpperBound_ExtremeDecimalPlaces                       |upper > lower (valid)                      | Above Lower Bound             |
| testUpperBound_ReturnsEvenWhenNegative                    |upper > lower (valid)                      | Above Lower Bound             |
| testUpperBound_FailsWhenLessThanLowerBound_BVT_BLB        |upper < lower (invalid)                    | Below Lower Bound             |
| testUpperBound_ReturnsWhenGreaterThanLowerBound_BVT_ALB   |upper > lower (valid)                      | Above Lower Bound             |
| testUpperBound_FailsWhenLessThanLowerBound                |upper < lower (invalid)                    | Below Lower Bound             |
| testUpperBound_ReturnsWhenGreaterThanLowerBound           |upper > lower (valid)                      | Above Lower Bound             |
| testUpperBound_ReturnsWhenEqualLowerBound                 |upper == lower (valid)                     | At Lower Bound                |
| testcentralValueShouldBeZero                              |lower <= 0 < upper (valid)                 | Above and Below Lower Bound   |
| testcentralValueShouldBeZeroPointFive                     |lower <= 0 < upper (valid)                 | Above and Below Lower Bound   |
| testcentralValueShouldBeZeroForWideRange                  |lower <= 0 < upper (valid)                 | Above and Below Lower Bound   |
| testcentralValueShouldBeTwentyTwoPointFive                |lower <= 0 < upper (valid)                 | Above and Below Lower Bound   |
| testnegativeBounds                                        |lower <= 0 < upper (valid)                 | Above and Below Lower Bound   |
| testzeroBounds                                            |lower == upper (valid)                     | Above and Below Lower Bound   |

test centralValues
- lower <= 0 < upper (valid)
- lower == upper (valid)  

| Test Index                                                    | Equivalence Class                                  | Boundary Value Analysis                       |
|---------------------------------------------------------------|----------------------------------------------------|-----------------------------------------------|
| testCreateNumberArray_PositiveValues                          |                                                    |                                               |
| testCreateNumberArray_NegativeValues                          |                                                    |                                               |
| testCreateNumberArray_ZeroValues                              |                                                    |                                               |
| testCreateNumberArray_EmptyArray                              |                                                    |                                               |
| testCalculateColumnTotal_UsingNullAsDataArgument              | Invalid data object                                | Data object invalid                           |
| testCalculateColumnTotal_ZeroRows                             | Valid data object, 0 <= column < n (valid)         | Data object has 0 rows, column is nominal     |
| testCalculateColumnTotal_ZeroColumns                          | Valid data object, 0 <= column < n (valid)         | Data object has 0 columns, column is nominal  |
| testCalculateColumnTotal_NegativeColumnArg_BLB                | Valid data object, column < 0 (invalid)            | Data object nominal, column below lower bound |
| testCalculateColumnTotal_ColumnEqualsZero_LB                  | Valid data object, 0 <= column < n (valid)         | Data object nominal, column at lower bound    |
| testCalculateColumnTotal_ColumnIsNominal                      | Valid data object, 0 <= column < n (valid)         | Data object nominal, column is nominal        |
| testCalculateColumnTotal_ColumnIsAtUB                         | Valid data object, n <= column (invalid)           | Data object nominal, column at upper bound    |
| testCalculateColumnTotal_ColumnIsAUB                          | Valid data object, n <= column (invalid)           | Data object nominal, column above upper bound |
| testGetCumulativePercentages_EmptyDataArg                     | Valid data object                                  | Empty                                         |
| testGetCumulativePercentages_NullDataArg                      | Invalid data object                                | Null                                          |
| testGetCumulativePercentages_ExampleFromDocs                  | Valid data object, valid contents in object        | Nominal                                       |
| testGetCumulativePercentages_WithNegativeNumbers              | Valid data object, valid contents in object        | Nominal                                       |
| testGetCumulativePercentages_WithAZero                        | Valid data object, valid contents in object        | Nominal                                       |
| testGetCumulativePercentages_WithAllZeros                     | Valid data object, invalid contents in object      | Contains zeros                                |
| testGetCumulativePercentages_WithAllNulls                     | Valid data object, invalid contents in object      | Contains nulls                                |
| testGetCumulativePercentages_WithAllNegativeNumbers           | Valid data object, invalid contents in object      | Contains negative numbers                     |
| testGetCumulativePercentages_WithSingleValue                  | Valid data object, valid contents in object        | Nominal                                       |
| testGetCumulativePercentages_WithVerySmallValues              | Valid data object, valid contents in object        | Nominal                                       |
| testcalculateRowTotal_CorrectTotal                            |                                                    |                                               |
| testcalculateRowTotalWithEmptyDataSet_ReturnZeroTotal         |                                                    |                                               |
| testcalculateRowTotalWithZeroValues_ReturnCorrectTotal        |                                                    |                                               |
| testcalculateRowTotalWithNegativeValues_ReturnCorrectTotal    |                                                    |                                               |
| testCreateNumberArray2D_ValidArray                            |                                                    |                                               |
| testCreateNumberArray2D_EmptyArray                            |                                                    |                                               |
| testCreateNumberArray2D_NullArray                             |                                                    |                                               |