package com.techelevator;

public class HomeworkAssignment {


    private int earnedMarks;
    private int possibleMarks = 100;
    private String submitterName;





    public HomeworkAssignment() {

    }

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getEarnedMarks() {
        return this.earnedMarks;
    }

    public int getPossibleMarks() {
        return this.possibleMarks;
    }


    public String getSubmitterName() {
        return this.submitterName;
    }

    public String getLetterGrade() {
        int percentCurrentGrade = (earnedMarks * 100) / possibleMarks;
        if (percentCurrentGrade >= 90) {
            return "A";
        } else if (percentCurrentGrade >= 80 && percentCurrentGrade < 90) {
            return "B";
        } else if (percentCurrentGrade >= 70 && percentCurrentGrade < 80) {
            return "C";
        } else if (percentCurrentGrade >= 60 && percentCurrentGrade < 70) {
            return "D";
        } else {
            return "F";
        }
    }


}
