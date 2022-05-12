package QuizCD;

public class Grade {
    private int numQuestions;
    private int numCorrect;
    public Grade(int numQuestions, int numCorrect){
        this.numCorrect = numCorrect;
        this.numQuestions = numQuestions;
    }
    public double getPercentScore(){
        return ((double)numCorrect/(double)numQuestions) * 100.0;
    }
}
