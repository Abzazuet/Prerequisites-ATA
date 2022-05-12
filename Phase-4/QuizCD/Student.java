package QuizCD;

import java.util.ArrayList;

public class Student {
    private String id;
    private ArrayList<Grade> grades = new ArrayList<Grade>();

    public Student(String id) {
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public ArrayList<Grade> addGrade(Grade grade) {
        grades.add(grade);
    
        return grades;
    }
}
