# Earthquake Data

- Object orientation with classes
- Searching, sorting and understanding data.
- Use API

## Relationships between classes

- POJO: plain old java object

## Licensing and APIs

- Location class from Android system
- Read API doc
- Create location objects according to API
- Apacha 2.0 licence
  - Allows for reuse and adaptation
- https://developer.android.com/reference/android/location/Location.html link for documentation

## Filter data

- Avoid duplicating data when creating different filters
- TO accomplish this we are going to use _iNTERFACES_
- Whenever you think about copying and pasting code

## Interfaces

- `public interface Name{}`
- Type which promises certan methods
- Classes can implement an interface
- Must define the promised methods
- Can be treated as the interface type
- `public class Name implements INterface{}`
- We are gonna be using the Filter class and the .satisfies method
- Java remembers the type when we use new, this is called _DYNAMIC DISPATCH_

## Filter

- Create a filter class that takes in a filter parameter

```java
public ArrayList <QuakeEntry> filter (ArrayList<QuakeEntry> quakeData, Filter f){
  ArrayList <QuakeEntry> answer = new ArrayList<QuakeEntry>();
  for(QuakeEntry qe: quakeData){
    if(f.satisfies(qe)){
      answer.add(qe);
    }
  }
  return answer;
}
```

- In the code above we define a filter method in which we pass the data and a filter with a satisfies method.
- However, we need to change the satisfies method for every filter we create, since we want it to filter according to our needs.
- Filter is an interface not a class.
- An interface is a type that promises that certain method will be implemented
- Classes can implement interfacesa and define the promised methods
- You can also write other methods in the class.

```java
//Creating the FIlter interface
public interface Filter {
  public boolean satisfies(QuakeEntry qe);
}
```

```java
// Now we will implement the interface class in a MinMagFilter, making sure we implement the promised methods
public class MinMagFilter implements Filter{
  private double magMin;
  public MinMagFilter(double min){
    magMin = min;
  }
  public boolean satisfies(QuakeEntry qe){
    return qe.getMagnitude() >= magMin;
  }
}
```

```java
//Putting it all together, list has all the quakes
Filter f = new MinMagFilter(4.0);
ArrayList<QuakeEntry> largeQuakes = filter(list, f);
f = new DistanceFilter(myLoc, 100);
ArrayList<QuakeEntry> shallowQuakes = filter(list, f);
```

## Dynamic dispatch

- Thanks to do java know what .satisfies to call, since it stores the class type

```java
Filter f1 = new MinMagFilter(4.0); //Java know that f1 should call the .satisifes with the MinMagFilter type
Filter f2 = new DepthFilter(-32160, -1800);//Java know that f2 should call the .satisifes with the DepthFilter type
```

- It figures out what method to call
