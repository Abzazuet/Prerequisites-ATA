package QuizCD;

import java.util.ArrayList;
import java.util.HashMap;

public class Grader {
    private ArrayList<Student> students = new ArrayList<Student>();
    private HashMap<String, ArrayList<LetterGrade>> studentGrade = new HashMap<String, ArrayList<LetterGrade>>();

    public void addStudent(Student student) {
        students.add(student);
        studentGrade.put(student.getId(), new ArrayList<LetterGrade>());
    }

    public LetterGrade getLetterGrade(String studentId) {
        ArrayList<LetterGrade> letters = studentGrade.get(studentId);
        return letters.get(0);
    }

    public int administer(String studentId, Quiz quiz) {
        int numCorrect = quiz.administer();
        int numQuestions = quiz.getNumberOfQuestions();
        double grade = Math.floor(new Grade(numQuestions, numCorrect).getPercentScore());
        LetterGrade letter = LetterGrade.F;
        ArrayList<LetterGrade> grades = new ArrayList<LetterGrade>();
        if(grade>90){
            letter = LetterGrade.A;
        }
        else if(grade>80){
            letter = LetterGrade.B;
        }
        else if(grade>70){
            letter = LetterGrade.C;
        }
        else if(grade>60){
            letter = LetterGrade.D;
        }
        else{
            letter = LetterGrade.F;
        }

        grades.add(letter);
        studentGrade.put(studentId, grades);
        return 1;
    }
}
