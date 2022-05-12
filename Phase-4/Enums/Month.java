/**
 * An Enum representing the US months of the year.
 */
package Enums;

public enum Month {
    JANUARY(31, 0),
    FEBRUARY(28, 1),
    MARCH(31, 2),
    APRIL(30, 3),
    MAY(31, 4),
    JUNE(30, 5),
    JULY(31, 6),
    AUGUST(31, 7),
    SEPTEMBER(30, 8),
    OCTOBER(31, 9),
    NOVEMBER(30, 10),
    DECEMBER(31, 11);

    private int days;
    private int monthNumber;

    private Month(int numberOfDays, int monthNumber){
        this.days = numberOfDays;
        this.monthNumber = monthNumber;
    } 
    /**
     * Get the number of days in the month. Leap years are not considered.
     * Ex: January -> 31
     * @return the number of days in a month
     */
    public int getLength() {
        //TODO: Implement me
        return days;
    }

    /**
     * Adds numberOfMonths to the current Month and returns what month it will then be.
     * @param numberOfMonths the number of months to look ahead
     * @return what month it will be numberOfMonths after the current month
     */
    public Month plus(int numberOfMonths) {
        //TODO: Implement me
        double total = numberOfMonths + monthNumber;
        double modulus = Math.floor(total % 12);
        for (Month month : Month.values()){
            if(month.monthNumber==modulus){
                return month;
            }
        }
        return JANUARY;
    }

    /**
     * Return the name of the month in the requested style, either SHORT or default to LONG. For some months,
     * SHORT may be equal to LONG.
     * Ex: A SHORT style would return 'Jan' and the LONG style would return 'January'
     * @param style - the style the month should be returned in
     * @return the display name of the current month according to the requested style.
     */
    public String getDisplayName(DisplayStyle style) {
        //TODO: Implement me
        if(style == DisplayStyle.LONG){
            return super.toString().substring(0,1)+super.toString().substring(1).toLowerCase();
        }
        if(style == DisplayStyle.SHORT){
            int end = 5;
            if(super.toString().length()<5){
                end = super.toString().length();
            }
            if(super.toString().length()>5){
                end = 3;
            }
            if(super.toString().length()>7){
                end = 4;
            }
            return super.toString().substring(0,1)+super.toString().substring(1, end).toLowerCase();
        }
        return "";
    }
}
