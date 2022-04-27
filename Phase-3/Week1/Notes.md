# Cryptography

- Necessary to encrypt information shared across servers and computers so even if it wants to be stolen it's encrypted.
- https = secure
- Modern cryotigraphy=RSA+AES

## Ceasar Cipher

- Substitute letter with letter + N.
- Pre-shift alphabet

## Building up strings

- Concatenation
- Strings are immutable, which means they cannot be changed

## StringBuilder

- Mutable string
- methods: append, insert, charAt, setCharAt, toString
- s.charAt(desiredPosition).

## Counting loops

- Indexing a string
- for is the same as while, just prettier.
- initialize, loop guard, increment.

## Character building

- Characters are declared using ''.
- It has several methods.
- Character.{toLowerCase(ch), isDigit(ch)}

# Arrays

- int[] a = new int[250].
- a.length to show the length of a given array
- indexed collection of values
- String[] s = new String[12]

# Random

- java.util.Random
- Random variable = new Random()

# Object Oriented Programming

- Object = Code + data
- Class = defines a type
- Object= instance of a class
- Fields, constructors, visibility
- A field leaves inside of an object instead of a method

## Fields or instance variables

- `private String alphabet;`
- Declared inside the object but outside of any method
- instance variables
- every instance has its own values
- they can be accessed by any method inside the object
- Class=noun, describes a thing
- Method=verb, what you do with the thing
- field = noun, describe things the class has; adjective, describe properties of a thing

## Visibility modifiers

### Public

- Any code can access it.
- what it does?
- Interface
- methods that the thing does
- classes
- constructors

### Private

- Only code inside that given class can access that code
- Separate interface from implementation
- how it does it?
- Implementation
- fields
- methods used as helpers

## Constructors

- public ClassName(parameter)
- the name has to be exactly the same as the class name
- it has no return type
- it has its parameter inside the parentheses
- you do not call them
- the code is always ran when you make a new object
- if you do not make one the compiler makes one automatically
- 