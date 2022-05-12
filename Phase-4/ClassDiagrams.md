# UML

- UNIFIED MODELING LANGUAGE
- Ruleset that makes it possible for us to describe large, complicated systems in precise yet easily understood ways.

## Class diagrams

- They show the overall structure of a software program by describing its classes and their relationships.
- They do not explain how a system manipulates data or how any specific problem in the system is solved.

### Classes
- Represented by a box with three section

    1. The top section contains the class name
    2. The middle section contains the class's attributes and specifies their names, types and visibility.
    3. The bottom section includes the class's methods and specifies their names, arguments and argument types, return types and visibility.

- Do not inclide private methods in class diagrams, nor getters nor setters
- Red box is for private and green circle for public
- '-' for private and '+' for public.

### Enumerations

- THey include a decoration called a "stereotype"
- They include getters and setters if they have them
- they are declared `<<enumaration>>`, which is the stereotype

### Compostion and Aggregation

- We build programs and classes starting with the simpler classes
- THe descriptions "is-part-of" or "owns" would be fit and this is called composition
- When an object has many items is called aggregation
- Diamond indicates compisiton 
- The open diamond indicates aggregation
- We can also add cardinality 
```
Order "1" *-- "1..*" LineItem
LineItem "1" o- "1" Item : "refers to"
```
- Create lines with --
- o to draw an open diamond with aggregation
- add label by appending a colon : and a descriptive string
- Double dashes to request vertical line
- Single dashes to request horizontal line
- Add spaces to strings to move them away from edges
- CHange the order of classes to change the rendering
- Swap the direction of the relationship

### Relationship
- Useful to connect objects, aka uses relationship
- We represent plain relationships with a line, labeled but without any diamonds