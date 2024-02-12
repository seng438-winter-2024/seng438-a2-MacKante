## Range (5 of 15)

### double	getUpperBound()
Returns the upper bound for the range.

Range

public Range(double lower,
             double upper)
Creates a new range.
Parameters:
lower - the lower bound (must be <= upper bound).
upper - the upper bound (must be >= lower bound).

getUpperBound

public double getUpperBound()
Returns the upper bound for the range.
Returns:
The upper bound.

Equivalence Class Partitions:
upper > lower (valid)
upper == lower (valid)
upper < lower (invalid)

BVT/Robustness
BLB: upper < lower
LB: upper == lower
ALB: maybe
Nominal: upper > lower

ExtraStuff:
Set upper = NULL //invalid input
test (-)ive
test decimals rounding

## DataUtilities

DataUtilities

public DataUtilities() // default ctor

### static double calculateColumnTotal(Values2D data, int column)
Returns the sum of the values in one column of the supplied data table.

calculateColumnTotal

public static double calculateColumnTotal(Values2D data, int column)
Returns the sum of the values in one column of the supplied data table. With invalid input, a total of zero will be returned.
Parameters:
    data - the table of values (null not permitted).
    column - the column index (zero-based).
Returns:
    The sum of the values in the specified column.
Throws:
    InvalidParameterException - if invalid data object is passed in.

Equivalence class Partitions:
data
- Normal Values2D object (maybe empty one?) (valid)
- null (invalid) [throw exception]
- Any other type of object (arrayList or something) (invalid) [throw exception]
Column (assume data has n columns)
- column < 0 (invalid)
- 0 <= column < n (valid)
- n <= column (invalid)

BVT:
BLB: column < 0 
LB: column == 0
ALB: column == 1
nom: 1 <= column < n - 1
BUB: column == n - 1
UB column == n
AUB: column > n

Extra stuff:
column == null
integer overflow

### static KeyedValues getCumulativePercentages(KeyedValues data)
Returns a KeyedValues instance that contains the cumulative percentage values for the data in another KeyedValues instance.

getCumulativePercentages

public static KeyedValues getCumulativePercentages(KeyedValues data)
Returns a KeyedValues instance that contains the cumulative percentage values for the data in another KeyedValues instance. The cumulative percentage is each value's cumulative sum's portion of the sum of all the values.
eg:
Input:

Key  Value
0        5
1        9
2        2

Returns:

Key  Value
0     0.3125 (5 / 16)
1     0.875 ((5 + 9) / 16)
2     1.0 ((5 + 9 + 2) / 16)
The percentages are values between 0.0 and 1.0 (where 1.0 = 100%).

Parameters:
data - the data (null not permitted).
Returns:
The cumulative percentages.
Throws:
InvalidParameterException - if invalid data object is passed in.

Equiv classes
- data
    - Normal KeyedValues object (maybe empty one?) (valid)
    - null (invalid) throw exception
    - Any other type of object (arrayList or something) (invalid) throw exception
- Values inside data
    - negative
    - all zeros / zeros mixed in
    - positive
    - nulls
    - really small decimals?
    - none/empty object






