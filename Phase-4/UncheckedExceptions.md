# Exceptions

- Is an event that, while a program is executing, disrupts the flow of a program.
- An exception could occur and cause the program to stop.
- Exceptions are what you throw when some part of your program can no longer fulfill its purpose.

## Throwing your own exceptions

- `java.lang.IllegalArgumentException`
```JAVA
    if(condition){
        throw new IllegalArgumentException("Some descriptive text");
    }
    if(condition){
        throw new IllegalArgumentException("Some other descriptive text");
    }
    return wishedValueWhichWillOnlyReturnIfNoExceptionIsThrown;

```
## Difference between an error and an Exception

-