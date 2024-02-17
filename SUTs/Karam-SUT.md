# Range
## ctor (for reference):
public Range(double lower, double upper) <br/>
Creates a new range. <br/>
#### Parameters:
    lower - the lower bound (must be <= upper bound).
    upper - the upper bound (must be >= lower bound).

## double	getUpperBound()
#### Returns the upper bound for the range.
#### Returns: 
    The upper bound.

Equivalence Class Partitions:
- upper > lower (valid)
- upper == lower (valid)
- upper < lower (invalid)

BVT/Robustness
- BLB: upper < lower
- LB: upper == lower
- ALB: maybe
- Nominal: upper > lower

Extra test cases:
- test negative upper bound
- test very small decimals

# DataUtilities

## static double calculateColumnTotal(Values2D data, int column)
#### Returns the sum of the values in one column of the supplied data table. With invalid input, a total of zero will be returned.
#### Parameters:
    data - the table of values (null not permitted).
    column - the column index (zero-based).
#### Returns:
    The sum of the values in the specified column.
#### Throws:
    InvalidParameterException - if invalid data object is passed in.

Equivalence Class Partitions:
- Values2D data
    - Normal Values2D object (valid)
    - Empty Values2D object (valid)
    - null (invalid) [throw exception]
- int column (assume data has n columns)
    - column < 0 (invalid)
    - 0 <= column < n (valid)
    - n <= column (invalid)

BVT/Robustness:
- BLB: column < 0 
- LB: column == 0
- ALB: column == 1
- nom: 1 <= column < n - 1
- BUB: column == n - 1
- UB: column == n
- AUB: column > n

Extra test cases:
- integer overflow

## static KeyedValues getCumulativePercentages(KeyedValues data)
#### Returns a KeyedValues instance that contains the cumulative percentage values for the data in another KeyedValues instance. The cumulative percentage is each value's cumulative sum's portion of the sum of all the values.
eg: Input:

Key      Value <br/>
0  &ensp;5 <br/>
1  &ensp;9 <br/>
2  &ensp;2 <br/>

Returns:

Key  Value <br/>
0 &ensp;    0.3125 (5 / 16) <br/>
1 &ensp;    0.875 ((5 + 9) / 16) <br/>
2 &ensp;    1.0 ((5 + 9 + 2) / 16) <br/>
The percentages are values between 0.0 and 1.0 (where 1.0 = 100%).

#### Parameters:
    data - the data (null not permitted).

#### Returns:
    The cumulative percentages.
#### Throws:
    InvalidParameterException - if invalid data object is passed in.

Equivalence Class Partitions
- data
    - Normal KeyedValues object (valid)
    - Empty KeyedValues object (valid)
    - null (invalid) [throw exception]
- Values inside data
    - negative
    - all zeros
    - positive
    - nulls
    - really small decimals

- Extra Test Cases:
    - zeros mixed in