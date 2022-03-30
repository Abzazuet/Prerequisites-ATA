# HTML

- Specifies the content of the web page
- Not a programming language, it's a markup language
- HTML5 is the standard
- First was in 1993

## Metadata elements

- They contain information about the page.

  1. `<html>`: all other elements must be define inside it. It tells the browser that it should display the file using the html standard.
  2. `<head>`: contains general information about the page. Title, scripts, css
  3. `title`: specifies the title page. Must be inside head.

## Sectioning Elements

- They define regions of the page

  1. `<body>`: Contains all elements seen on page.
  2. `<h1>`: Section head, and we have till h6
  3. `<div>` : Helps divide sections.

## Text Content

- `<p>`: most basic text container tag.

## Formatting text

1. `<b>`: bold
2. `<em>`: emphasize

## Adding images

- `<img src= "" alt = "" width= "" height = " "/>`: adding an image where src is the location of the image, alt is optional text and the last two are optional for the size.

### Issues when using images

- copyright concerns.
- where are the images store?
- Good to use images in public domain.
- Wikimedia.
- Hostage concers.
- Inline link: the image is stored in another site and you use the URL to access it.
- Copy image URL to use the hotline link.

## Links

- `<a href=""> Link to other page</a>`: takes us to another webpage when clicked.

## Lists and Tables

- `<ul><li>item1</li><li>item2</li></ul>`: Unorded List. Some lists use circles or bullets. Called like that cause the labels are the same.
    <ul>
    <li>Item 1</li>
    <li>Item 2</li>
    </ul>

- We can put more than just li, like img and a.
- `<ol><li>item1</li><li>item2</li></ol>`: Ordered List.
    <ol>
    <li>Item 1</li>
    <li>Item 2</li>
    </ol>

- Composition: put elements together to get more complex results.
- List of list= _Nested List_.

## Tables
- Rows and columns
- CSS preferred
1. `<table>`: begin table
2. `<tr></tr>`: Table Row. one for each row.
3. `<th></th>`: Table Header. Specifies the name of the header
4. `<td></td>`: Table Data. Table cells.
3. `</table>`: end table