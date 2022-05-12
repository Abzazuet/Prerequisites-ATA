# Enums

- Java data type used to define a fixed set of constants.
- Special kind of Java CLASS that defines the possible values a variable can have.
- Useful to represent a limited number of values

```JAVA
public enum Color {
    RED(255, 0, 0), BLUE(0, 0, 255), YELLOW(255, 255, 0), BLACK(0, 0, 0);

    private int red;
    private int green;
    private int blue;

    private Color(int r, int g, int b){
        this.red = r;
        this.green = g;
        this.blue = b;
    }
    public String rgbValue(){
        return String.format("(%d, %d, %d)", red, green, blue);
    }
    @Override
    public String toString(){//method run behind the scenes when printing out, currently overriding it
        String constName = super.toString();//Used to get the original name
        return consName.substring(0, 1) + constName.substring(1);
    }
}
```

- to declare
- you cannot make an instance of an enum, IMPOSSIBLE
- Name.value to access the value of the enum

## Constructor

- They can either be private or packaged private
- You cannot call the constructor outside the class, so you call it right next to the constants.

## Public

- Means you can access it from a different class.

## Final

- Means constant

## Static

- Call it on a type
- Used implicilty in enums

## Valid examples

```JAVA
public enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}
// access those values
DayOfWeek day1 = DayOfWeek.MONDAY;
//It has to be the exact name for it to match
```

- In the elements of enum we can also add a parameter to define a property wihin the constructor, like the next example.

```JAVA
public enum DayOfWeek {
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6);
    private int ordering;
    private DayOfWeek(int ordering) {
        this.ordering = ordering;
    }
    public DayOfWeek plus(int numberOfDays) {
        if(numberOfDays < 0) {
             throw new IllegalArgumentException("Number of days must be positive.");
        }

        int newOrderingValue = (this.ordering + numberOfDays) % 7;
        for (DayOfWeek day : DayOfWeek.values()) { // we describe the values method be
            if (day.ordering == newOrderingValue) {
                return day;
            }
        }
        // If we got here someone has broken the DayOfWeek enum. We no longer have 7 v
        throw new IllegalStateException("Could not find a day for ordering value: "
            + newOrderingValue);
    }

    @Override
    public String toString() {
        return name().substring(0, 1) + name().substring(1).toLowerCase();
    }
}
```

### .super

- Calls the implementation of the parent class.

## Methods

- The compiler adds some default methods such as the toString and values.
- toString will run when we print out something
- values is very useful when we want to iterate through the enum

## See all values

```JAVA
for (enumClass c : Name.values()){
    Syso(c);
}
```
