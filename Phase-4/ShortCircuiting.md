# Short Circuiting

- Used in logical operators && ||.
- It means that it will evaluate just the number of expressions necessary to have an outcome.
- This is useful when we have more than one condition, since the second condition might depend on the first one being true or false and our program might crush if we dont manage this correctly. 
- SHort circuitig helps us fix that problem since it won't evaluate the second expression.