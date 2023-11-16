# Task01
Objective: Write a Java program to analyze each category, printing out key analytics like average rating, highest rating, lowest rating and the respective Google Play Store Application.

# Run Instructions
## Compile
`javac -d task01/classes task01/src/*.java`
## Run
`java -cp task01/classes Main googleplaystore.csv`

# Expected Output
```
...
Category: COMMUNICATION
  Highest: BV, 5
  Lowest: CJ DVD RENTALS, 1
  Average: 4.158537
  Count: 328
  Discarded: 59
Category: TOOLS
  Highest: DR. ES PV CALCULATOR, 5
  Lowest: DT FUTURE1 CAM, 1
  Average: 4.0474114
  Count: 734
  Discarded: 109
Total lines in file: 10841
```