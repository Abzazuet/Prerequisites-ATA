package QuizCD;

public enum LetterGrade {
    A(90.0), 
    B(80.0),
    C(70.0),
    D(60.0),
    F(0.0);
    private double minPercent;
    private LetterGrade(double grade){
        this.minPercent = grade;
    }
    public double getMinimimPercent(LetterGrade letter){
        return letter.minPercent;
    }
}
