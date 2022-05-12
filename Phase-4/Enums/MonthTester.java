/**
 * This class will be used to write test methods that interact with the Month enum.
 */
package Enums;

public class MonthTester {

    public void testGetLengthMethod() {
        System.out.println("Testing getLength() method.");

        Month jan = Month.JANUARY;
        System.out.println("Testing: " + jan);
        int length = jan.getLength();
        if (length == 31) {
            System.out.println("✔ Got the right number of days for January!");
        } else {
            System.out.println("✘ Incorrect number of days for January. Should be 31, but got: " + length);
        }

        Month feb = Month.FEBRUARY;
        System.out.println("Testing: " + feb);
        length = feb.getLength();
        if (length == 28) {
            System.out.println("✔ Got the right number of days for February!");
        } else {
            System.out.println("✘ Incorrect number of days for February. Should be 28, but got: " + length);
        }

        Month june = Month.JUNE;
        System.out.println("Testing: " + june);
        length = june.getLength();
        if (length == 30) {
            System.out.println("✔ Got the right number of days for June!");
        } else {
            System.out.println("✘ Incorrect number of days for June. Should be 30, but got: " + length);
        }

    }

    public void testPlusMethod() {
        System.out.println("Testing plus() method.");

        Month jan = Month.JANUARY;
        System.out.println("Testing: " + jan + " plus 6 months.");
        Month sixMonthsLater = jan.plus(6);
        if (sixMonthsLater == Month.JULY) {
            System.out.println("✔ Correct: landed in July");
        } else {
            System.out.println("✘ Landed in the wrong month. Should be July, but got: " + sixMonthsLater);
        }

        System.out.println("Testing: " + jan + " plus 18 months.");
        Month eighteenMonthsLater = jan.plus(18);
        if (eighteenMonthsLater == Month.JULY) {
            System.out.println("✔ Correct: landed in July");
        } else {
            System.out.println("✘ Landed in the wrong month. Should be July, but got: " + eighteenMonthsLater);
        }

        Month aug = Month.AUGUST;
        System.out.println("Testing: " + aug + " plus 7 months.");
        Month sevenMonthsLater = aug.plus(7);
        if (sevenMonthsLater == Month.MARCH) {
            System.out.println("✔ Correct: landed in March");
        } else {
            System.out.println("✘ Landed in the wrong month. Should be March, but got: " + sevenMonthsLater);
        }

    }

    public void testGetDisplayNameMethod() {
        System.out.println("Testing getDisplayName() method.");

        DisplayStyle shortStyle = DisplayStyle.SHORT;
        DisplayStyle longStyle = DisplayStyle.LONG;

        Month june = Month.JUNE;
        System.out.println("Testing: " + june + ".");
        String shortJune = june.getDisplayName(shortStyle);
        String longJune = june.getDisplayName(longStyle);
        if (shortJune.equals("June") && longJune.equals("June")) {
            System.out.println("✔ Correct: the short and long display are both: " + longJune);
        } else {
            System.out.println("✘ Incorrect display names. Expected Long: June, Short: June. Got Long: "
                    + longJune + " Short: " + shortJune);
        }

        Month may = Month.MAY;
        System.out.println("Testing: " + may + ".");
        String shortMay = may.getDisplayName(shortStyle);
        String longMay = may.getDisplayName(longStyle);
        if (shortMay.equals("May") && longMay.equals("May")) {
            System.out.println("✔ Correct: the short and long display are both: " + longMay);
        } else {
            System.out.println("✘ Incorrect display names. Expected Long: May, Short: May. Got Long: "
                    + longMay + " Short: " + shortMay);
        }

        Month july = Month.JULY;
        System.out.println("Testing: " + july + ".");
        String shortJuly = july.getDisplayName(shortStyle);
        String longJuly = july.getDisplayName(longStyle);
        if (shortJuly.equals("July") && longJuly.equals("July")) {
            System.out.println("✔ Correct: the short and long display are both: " + longJuly);
        } else {
            System.out.println("✘ Incorrect display names. Expected Long: July, Short: July. Got Long: "
                    + longJuly + " Short: " + shortJuly);
        }

        Month sept = Month.SEPTEMBER;
        System.out.println("Testing: " + sept + ".");
        String shortSept = sept.getDisplayName(shortStyle);
        String longSept = sept.getDisplayName(longStyle);
        if (shortSept.equals("Sept") && longSept.equals("September")) {
            System.out.println("✔ Correct: the short and long display are different. Long: " + longSept
                    + " Short: " + shortSept);
        } else {
            System.out.println("✘ Incorrect display names. Expected Long: September, Short: Sept. Got Long: "
                    + longSept + " Short: " + shortSept);
        }

        Month oct = Month.OCTOBER;
        System.out.println("Testing: " + oct + ".");
        String shortOct = oct.getDisplayName(shortStyle);
        String longOct = oct.getDisplayName(longStyle);
        if (shortOct.equals("Oct") && longOct.equals("October")) {
            System.out.println("✔ Correct: the short and long display are different. Long: " + longOct
                    + " Short: " + shortOct);
        } else {
            System.out.println("✘ Incorrect display names. Expected Long: October, Short: Oct. Got Long: "
                    + longOct + " Short: " + shortOct);
        }

    }

    public static void main(String[] args) {
        MonthTester test = new MonthTester();
        test.testGetDisplayNameMethod();
    }
}
