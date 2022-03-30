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
- The main difference between id and class is that id is used for just one element and class can be used multiple times.
## Colors
- 140 named colors.
- Use rgb(0,0,0).
- Use hex #000000.
- Use rgba (0,0,0,1). Let's adjust transparency
- Use hsl (5, %, %). Hue Saturation Light
- You can use a color picker tool.

