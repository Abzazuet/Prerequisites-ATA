# this

- Within an instance of an object, this is a reference to the current object.
- Used to remove ambiguity when the parameters have the same name as our fields. 
- THerefore, by using this wee refer to our fields and assign the argument passed in our parameter.
- You could also change the name of parameters but that would reduce the clearness.

## this in Field

- used to refer to private variables.

## Explicit constructor invocation

- use the __this__ keyword to call another constructor in the same class from within the constructor.

- this is useful when you want your object to have multiple constructors for different implementations.

- when using this (values), calls another constructor from that function and passes the specified values.

## Reducing duplicate code

- If you have 2 or more constructors you can call one of the constructors to reduce code by using `this(parameters)`. Which would call the constructor with that number of parameters. You can only do it once per constructor.
- When we call a method inside another method from the same class, the compiler adds the `this` keyword to the method call

## DOCUMENTATION 
- https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html

