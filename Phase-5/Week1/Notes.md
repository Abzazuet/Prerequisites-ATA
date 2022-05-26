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

