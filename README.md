# leetcodeJava [![Build Status](https://travis-ci.org/ddrsmile/leetcodeJava.svg?branch=master)](https://travis-ci.org/ddrsmile/leetcodeJava)  
This repository manages source I used to practice the algorithms on LeetCode with Java.  
All the problems belong to LeetCode.  
https://leetcode.com/  
Besides, not all the solutions are my original works.  
I did consult lots of resource on the internet.  
Mac OS X  

## Quick Start

### Prepare the files

#### 1. solutions

write down the solution with the class Solution, and then name the file with the # of the problem.  

ex. file name like `1.java` which contents the solution of problem 1.

```java
package sols;
import java.util.*;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] res = {-1, -1};
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        res[0] = map.get(target - nums[i]);
        res[1] = i + 1;
        break;
      } else {
        map.put(nums[i], i + 1);
      }
    }
    return res;
  }
}
```

put the file into "currentdir/src/sols/"

#### 2. main

write down the main procedure with the class, and then name the file with the # of the problem.  

ex. file name like `1.java`

```java
package main;
//Import the required classes of LeetCode;
import objs.*;
import utils.*;
import utils.inputparser;
import sols.Solution;

//Import the required libraries;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    // create integer parser
    ParserFactory<IntegerParser> factory = new ParserFactory<IntegerParser>(IntegerParser.class);
    IParser<Integer, int[]> intparser = factory.create(args[0]);
    // create solution object
    Solution sol = new Solution();
    // get input file's contents
    ArrayList<int[]> inputList = intparser.parseDataAsList();
    for (int i = 0; i < inputList.size()/2; i++) {
      int[] nums = inputList.get(2*i);
      int target = inputList.get(2*i + 1)[0];
      int[] res = sol.twoSum(nums, target);
      System.out.println(Arrays.toString(res));
    }
  }
}
```
put the file into "currentdir/src/main/"  
##### InputParser
InputParser class receives String variable which contents the path of input files to create the object.

###### Methods
```
parseDataAsSingleValue() return ArrayList<S>
parserDataAsList() return ArrayList<T>
parserDataAsLists() return ArrayList<ArrayList<T>>
```

where `S` is `Integer` for integer parser, `Double` for double parser and `String` for string parser.
and `T` is `int[]` for integer parser, `double[]` for double parser and `String[]` for string parser.

###### Create Parser

*Integer Parser*

```
// create integer parser
ParserFactory<IntegerParser> factory = new ParserFactory<IntegerParser>(IntegerParser.class);
IParser<Integer, int[]> intParser = factory.create(args[0]);
```

*Double Parser*

```
// create integer parser
ParserFactory<DoubleParser> factory = new ParserFactory<DoubleParser>(DoubleParser.class);
IParser<Double, double[]> doubleParser = factory.create(args[0]);
```

*String Parser*

```
// create integer parser
ParserFactory<IntegerParser> factory = new ParserFactory<IntegerParser>(IntegerParser.class);
IParser<Integer, int[]> stringParser = factory.create(args[0]);
```

where `args[0]` is the path of input file which is defined in `test.sh`

  
##### InputCleaner
InputCleaner class is used in InputParser.
The program will be stopped and the inappropriate contents will be shown when it is detected.  
The follows are the check points:  
1. Integer. ``` (1, 2, 34, -4, -62, ...)```  
2. Integer list. ``` ([1, 2, 34, -4], [34, -4, -62], [0, 3, 19], ...) ```  
3. The List of the Integer lists. ``` ([[1, 2, 34, -4], [34, -4, -62], [0, 3, 19]], ...) ```    
4. double Float. ``` (1.2, 32.2, 0.9, -5.2, -12.2, ...) ```  
5. double Float list. ``` ([1.2, 32.2, 0.9], [0.9, -5.2, -12.2], [0.0, 2.98, -84.234], ...) ```  
6. The List of the double Float lists. ``` ([[1.2, 32.2, 0.9], [0.9, -5.2, -12.2], [0.0, 2.98, -84.234]], ...) ```  

##### P.S.
1) Integer or double Float is valided for the check of the list and the list of the lists.  
2) [] is valided for the check of the list.  
3) [], [[]] are valided for the check of the list of the lists.  

### 3. prepare the input file
write down your input contents in the txt file as the test cases, and name the file with the # of problem.  
one input (one arguement) one line.

```java
Solution.sol1(int a)
Solution.sol2(int a, int b)
```  
For sol1, one line per test case. And two lines per testcase for sol2.

For example, the following input contents are used as 1 testcase for `Solution.sol(int[] nums, int target)`
```txt
[2, 7, 11, 15]
9
```

##### some simple rule
single int:
```txt
1  
-2  
3
```

int list:
```txt
[1,3,4]
```

int list of the lists:
```txt
[[1,2,3],[4,5,6],[7,8,9]]
```

single double float:  
```txt
1.3  
-0.2  
3.45
```

double float list:
```txt
[1.2,0.31,4.28]
```

double float list of the lists:
```txt
[[1.2,0.2,3.4],[5.4,5.02,8.46],[0.27,8.88,9.13]]
```

String:  
```txt
"string"
```

string list:  
```txt
["string1","string2","string3"]
```

To create the listNode, use int array as input.  
```txt
[1,3,4]
```

To create the binary tree, use String as input. Use # for the null node.
```txt
[1,2,#,4,5]
```  

### 4. ./test.sh

argument (optional) # of problem

ex. `>./test.sh 1` will run the problem 1 and show the output.

ex. `>./test.sh` or `>./test.sh all` will run all the problems and show the results
