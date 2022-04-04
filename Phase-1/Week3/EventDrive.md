# Interativity

- Adding js to add actions to our HTML/CSS elements.
- Javascript is used to control our components in html.

## Buttons with divs

- To create a button we follow the sytax
- `onclick` is an event in which we call our JS function in ""

```HTML
    <input type="button" value="change" onclick="doChange()">

```

## Accesing HTML elements with JS

- We usually access element by id.
- .className to add a class.
- .innerHTML to access the text within that element

## Canvas

- Use to store images
- Special methods need to be used to put text in a canvas
- A container for graphics
- You need to get the context from the canvas to modify it in JS.
- `variable.getContext("id")`
- .fillStyle="Color"
- .fillRect(x, y, w, h)
- .font = "90px Arial";
- .fillText("Text", x, y)

## Input and Events

- Input is used to create an HTML that takes an element from a user.
- `input type ="color" onchange=function()`.
- Input elements(type=): 

    1. Button
    2. Color
    3. Range
- Event types:

    1. oninput
    2. onchange
    3. onclick
