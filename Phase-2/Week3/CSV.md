# CSV

- Comma Separated Values
- Data in this format is portable between different spreadsheet format programs
- IETF made the standard for csv
- Apache csv parser is the one we'll be using
- `import org.apache.commons.csv.*`

## Select a file

- FileResource fr = new FileResource();

## Select various files

```JAVA
DirectoryResource dr = new DirectoryResource();
for (File f : dr.selectedFiles()) {
    FileResource fr = new FileResource(f);
    CSVParser csvFr = fr.getCSVParser();
}
```

## CSVParser

- Contains all the records of the file
- file.getCSVParser() to get the CSV of a file

## CSVRecord

- It just has one record
- With this one we can access specific elements by using .get("Temperature").
- We can check if the record contains x info by using .contains(x), it will return a boolean value.

## String to number

- Integer.parseInt(string);
- Double.parseDouble(string);

## NULL

- Means nothing
- You cannot call an object if it equalls null.
- Null is a special null type, literal null can be converted to any object type.
- **Primitive objects cannot be null**
- Object types CAN be null.

```

```
