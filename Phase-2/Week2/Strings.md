# Why work with strings?

- Easier to find data.
- Comma Separated Values

# Finding genes in DNA

- Work with Strings representing DNA
- 3 nucleotide make a codon which makes 1 aminoacid
- ATG is the start codon
- TAA is a stop codon
- Everything between the codons represents a gene

## How do we present a position in a string

- Use the substring method.

```JAVA
String s = "Abel Zazueta";
String x = s.substring(0, 4);
```

- .length()
- .indexOf("program", 5), starts looking in position 5
- .startsWith("string")
- .endsWith (string)
- Look for more methods java string documentation.
- https://docs.oracle.com/javase/7/docs/api/java/lang/String.html

# Indefinitive loop

```JAVA
while (x<y){
    statements;
    x++;
}
```

1. First Occurence of ATG and call its index, call it startIndex
2. Find the TAA starting from start+3, call this result currIndex
3. Check if curr-start is a multiple of3
4. If not, update currIndex to the index of the next TAA starting from currIndex+1
5. Check if currUbdex-start is a multiple of3
6. If so, the text between start and curr will be our gene

# Logical AND (&&) and Logical OR (||)

- Help us evaluate more than one condition at the time.
- AND indicates that both condition need to be true.
- OR indicates that you just need one condition needs to be true.
- It applies short circuit evaluation, very useful since the second statement might crash the program.

# StorageResource

- Holds a collection of strings
- iterable through .data()

