package QuizCD;

public class GraderTester {
    public static void main(String[] args) {
        GraderTester tester = new GraderTester();
        tester.testGrader();
    }

    public void testGrader() {
        final Student bStudent = new Student("B");
        final Student aStudent = new Student("A");
        Grader grader = new Grader();
        grader.addStudent(bStudent);
        grader.addStudent(aStudent);

        final Quiz sampleQuiz1 = makeSampleQuiz1();
        final Quiz sampleQuiz2 = makeSampleQuiz2();
        final Quiz sampleQuiz3 = makeSampleQuiz3();

        grader.administer("B", sampleQuiz1);
        grader.administer("B", sampleQuiz2);
        grader.administer("A", sampleQuiz2);
        grader.administer("A", sampleQuiz3);

        // Did the B student get a B?
        final LetterGrade bGrade = grader.getLetterGrade(bStudent.getId());
        if (bGrade == LetterGrade.B) {
            System.out.println("✔︎ The B student got a B grade.");
        } else {
            System.out.println(String.format(
                    "✘ The B student got a %s when we expected a B!", bGrade));
        }

        // Did the A student get an A?
        final LetterGrade aGrade = grader.getLetterGrade(aStudent.getId());
        if (aGrade == LetterGrade.A) {
            System.out.println("✔︎ The A student got an A grade.");
        } else {
            System.out.println(String.format(
                    "✘ The A student got a %s when we expected an A!", aGrade));
        }
    }

    /**
     * This tricky little bit of code returns a quiz where the user always
     * gets the same score. You are NOT expected to understand this. Carry on
     * with your life as usual.
     *
     * @return A sample quiz that always scores 17 out of 20.
     */
    private Quiz makeSampleQuiz1() {
        return new Quiz() {
            @Override
            public int administer() {
                return 17;
            }

            @Override
            public int getNumberOfQuestions() {
                return 20;
            }
        };
    }

    /**
     * This tricky little bit of code returns a quiz where the user always
     * gets the same score. You are NOT expected to understand this. Carry on
     * with you life as usual.
     *
     * @return A sample quiz that always scores 87 out of 100.
     */
    private Quiz makeSampleQuiz2() {
        return new Quiz() {
            @Override
            public int administer() {
                return 87;
            }

            @Override
            public int getNumberOfQuestions() {
                return 100;
            }
        };
    }

    /**
     * This tricky little bit of code returns a quiz where the user always
     * gets the same score. You are NOT expected to understand this. Carry on
     * with you life as usual.
     *
     * @return A sample quiz that always scores 49 out of 50.
     */
    private Quiz makeSampleQuiz3() {
        return new Quiz() {
            @Override
            public int administer() {
                return 49;
            }

            @Override
            public int getNumberOfQuestions() {
                return 50;
            }
        };
    }
}
