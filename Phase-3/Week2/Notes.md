# Generate Stories with random data

## ArrayList

- java.util.ArrayList;
- Combines StorageResource and Arrays
- Makes it easy to count all words in a file or URL
- java.util.ArrayList or java.util.\*
- expands as needed
- provides access via index
- `ArrayList <type> words = new ArrayList<type>()`;
- for numbers you must use Integer
- int value = myFreqs.get(index);
- myFreqs.set(index, value+1);
- indexable and growable

### Array vs. ArrayList

- Easier to increment in arrays
- Arrays don't grow

### methods

- .add(elt)
- .size()
- .get(idx)
- .set(idx)

# GladLibs

- GladLib.java

# HashMap

- java.util.HashMap;
- faster than having two parallel ArrayLists
- key is element in domain, value is what key maps to in range
- map.get("rainbow");//will return a value associated with it
- key is a strrng, associated value in integer.
- `HashMap <typeOfKey, typeOfValue> map = new HashMap <typeOfKey, typeOfValue>();`
- `map.put(word, map.get(w)+1);`add value to key.
- `if (!map.containsKey(w) map.put(w,1);` to add a key that is not declared in the map.
- `map.keySet()` returns all the keys.
- `map.get(key)` returns the value of a given key.
- HashMap is faster than ArrayList
- ArrayList requires looking at all elements, map in independent of number of keys
- `String[] labels = {str1, str2, str3};`
## Operations

- .containsKey(key)
- .put(key, value)
- .get(key)
- .keySet, returns iterable

## .properties file
- read file, store info in HashMap
- file associates labels and replacement info
