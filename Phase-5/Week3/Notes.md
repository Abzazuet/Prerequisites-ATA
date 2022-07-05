# Markov Text Generation
- Statistical and probabilistic models
- Illustrate Java concepts with amusing program
- Idea behind Maching learning
- Order Zero text: lots of e's
- Order one: often pronounceable
- Order two: words and would be word

## Order-zero
- Choose character at random, don't use any character to predict next character

## Markov Zero
- Set the training text
- Set the generating text
```java
// Training text
public class MarkovZero{
    private String myText;
    public void setTraining (String s){
        myText = s;
    }
}
```