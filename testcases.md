# Test Cases:
## RangeTest:
testGetLowerBound_PositiveLowerBound<br/>
testGetLowerBound_NegativeLowerBound<br/>
testGetLowerBound_ZeroLowerBound<br/>
testGetLowerBound_NullLowerBound<br/>
testContains_ValueInRange<br/>
testContains_ValueNotInRange<br/>
testContains_LowerBound<br/>
testContains_UpperBound<br/>
testContains_NullRange<br/>
testGetLength_ZeroLength<br/>
testGetLength_PositiveLength<br/>
testGetLength_InfiniteLength<br/>
testGetLength_FractionLength<br/>
testUpperBound_ExtremeDecimalPlaces<br/>
testUpperBound_ReturnsEvenWhenNegative<br/>
testUpperBound_FailsWhenLessThanLowerBound_BVT_BLB<br/>
testUpperBound_ReturnsWhenGreaterThanLowerBound_BVT_ALB<br/>
testUpperBound_FailsWhenLessThanLowerBound<br/>
testUpperBound_ReturnsWhenGreaterThanLowerBound<br/>
testUpperBound_ReturnsWhenEqualLowerBound<br/>
testcentralValueShouldBeZero<br/>
testcentralValueShouldBeZeroPointFive<br/>
testcentralValueShouldBeZeroForWideRange<br/>
testcentralValueShouldBeTwentyTwoPointFive<br/>
testnegativeBounds<br/>
testzeroBounds<br/>

## DataUtilitiesTest
testCreateNumberArray_PositiveValues<br/>
testCreateNumberArray_NegativeValues<br/>
testCreateNumberArray_ZeroValues<br/>
testCreateNumberArray_EmptyArray<br/>
testCalculateColumnTotal_UsingNullAsDataArgument<br/>
testCalculateColumnTotal_ZeroRows<br/>
testCalculateColumnTotal_ZeroColumns<br/>
testCalculateColumnTotal_NegativeColumnArg_BLB<br/>
testCalculateColumnTotal_ColumnEqualsZero_LB<br/>
testCalculateColumnTotal_ColumnIsNominal<br/>
testCalculateColumnTotal_ColumnIsAtUB<br/>
testCalculateColumnTotal_ColumnIsAUB<br/>
testGetCumulativePercentages_EmptyDataArg<br/>
testGetCumulativePercentages_NullDataArg<br/>
testGetCumulativePercentages_ExampleFromDocs<br/>
testGetCumulativePercentages_WithNegativeNumbers<br/>
testGetCumulativePercentages_WithAZero<br/>
testGetCumulativePercentages_WithAllZeros<br/>
testGetCumulativePercentages_WithAllNulls<br/>
testGetCumulativePercentages_WithAllNegativeNumbers<br/>
testGetCumulativePercentages_WithSingleValue<br/>
testGetCumulativePercentages_WithVerySmallValues<br/>
testcalculateRowTotal_CorrectTotal<br/>
testcalculateRowTotalWithEmptyDataSet_ReturnZeroTotal<br/>
testcalculateRowTotalWithZeroValues_ReturnCorrectTotal<br/>
testcalculateRowTotalWithNegativeValues_ReturnCorrectTotal<br/>
testCreateNumberArray2D_ValidArray<br/>
testCreateNumberArray2D_EmptyArray<br/> 
testCreateNumberArray2D_NullArray<br/>

------------------------------------------------------------------------------------------------------
# adD YoUr sTufF hERe
✓☑✅︎

| Test Index                                                | Equivalence Class                         | Boundary Value Analysis       |
|-----------------------------------------------------------|-------------------------------------------|-------------------------------|
| testGetLowerBound_PositiveLowerBound                      | Positive lower bound value                | barely positive lower bound   |
| testGetLowerBound_NegativeLowerBound                      | Negative Lower bound value                | barely negative lower bound   |
| testGetLowerBound_ZeroLowerBound                          | Zero lower bound value                    | barely zero lower bound       |
| testGetLowerBound_NullLowerBound                          | Null range                                | none applied                  |
| testContains_ValueInRange                                 | Valid input, inside range                 | Barely inside range           |
| testContains_ValueNotInRange                              | Invalid input, outside range              | Barely outside range          |
| testContains_LowerBound                                   | lower bound input                         | Above and below lower bound   |
| testContains_UpperBound                                   | upper bound input                         | Above and below upper bound   |
| testContains_NullRange                                    | null range                                | none applied                  |
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
| testcalculateRowTotal_CorrectTotal                            | Valid data object, Positive Values                                                                                                               | Between Zero and Positive                     |
| testcalculateRowTotalWithEmptyDataSet_ReturnZeroTotal         | Valid data object, Empty Values                    | Boundary Values for Null                      |
| testcalculateRowTotalWithZeroValues_ReturnCorrectTotal        | Valid data object, Zero Values                     | Between Zero and Positive                     |
| testcalculateRowTotalWithNegativeValues_ReturnCorrectTotal    | Valid data object, Negative Values                 | Between Positive and Negative                                                                                                                                                             |
| testCreateNumberArray2D_ValidArray                            | Valid array input                                  | none applied                                  |
| testCreateNumberArray2D_EmptyArray                            | Empty array input                                  | none applied                                  |
| testCreateNumberArray2D_NullArray                             | Null array inpput                                  | none applied                                  |
