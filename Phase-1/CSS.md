# CSS

- Cascading Style Sheets
- Specifies the look and formatting
- Separates content from presentation
- Size, colors, mobile or desktop
- Scales

## Why?

- Reusability
- Maintainability

## Viewing and experiencing web pages

- Web page may be displayed differently based on the kind of device

## Accesibility

- Remove barriers
- Good user experience
- Quick Load

## Where?

- file.css
- include `<link>` in head.

## How?

- Selector
- Curly brackets
- Property to change
- :
- Value
- ;

```CSS
    selector, tag, #id, .className {
        prtoperty: option;
        color: blue;
    }
```
## Approaches to style
- Use a class with a descriptive name
```HTML
<li class="foodLi">Chocolate</li>
```
```CSS
.foodLi{
    color: green;
}
```
- Use an id
```HTML
<li id="foodLi">Chocolate</li>
```
```CSS
#foodLi{
    color: green;
}
```
- Combinators: nested elements, child, parent, sibling, etc.

