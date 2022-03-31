# JavaScript

## Variables

### Syntax

- Giving names to values.
- `let x = 3;`.
- Case sensitive.
- _keyword_ **name** = value;
- Semicolon (;) ends the statement.
- You can use other type of variables
- `var fgImage = new SimpleImage("drewRobert.png");`
- _new_ makes a new Object
- After _new_ goes the _type_ and then the _parameter_.

### Semantics

- Declaration
- Initialization

## Methods

- Perform some operation
- Act of an object
- `nameObject.method(parameters);`
- Execution goes into the method
- Do whatever code is there
- The method returns an answer back
- Method call evaluates to that value
- You can see what a method does by reading the documentation

## Functions

- Useful to avoid repeating code
- function name (parameters){statements}

```JavaScript
function square (x){
    let ans = x * x;
    return ans;
}
let y = square (4);
```

- Abstraction: separate interface from implementation

## Types of Data

- It specifies the number
- How to interpret it?
- How to operate on it?
- JavaScript keeps track of the type with the value
- Dynamically typed: it keeps track of the types while it runs the program

## For

- They repeat statements.
- `for (let pixel of image.values()){statements}`

## Conditional Execution

- `if (true_condition){statement}; else{statement}`
