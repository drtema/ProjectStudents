package com.drtema.mainclasses;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Dr.tema on 08.04.17.
 */
public class Course {
    private static int coursesCounter = 0;
    private final int courseID;
    private final String courseName;
    private String courseDescription;
    private List<Student> studentsList = new LinkedList<Student>();
    private Trainer trainer;
    private final String dateOfBeginning;
    private final String endDate;
    private List<DayOfWeek> dayOfTheCourses = new LinkedList();

    public Course(String courseName, String courseDescription, String dateOfBeginning, String endDate, String... a) {

        this.courseID = ++coursesCounter;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.dateOfBeginning = dateOfBeginning;
        this.endDate = endDate;

        for (String x:a) {
            dayOfTheCourses.add(DayOfWeek.valueOf(x));
        }
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return
                " courseID=" + courseID +
                ",\n courseName='" + courseName + '\'' +
                ",\n courseDescription='" + courseDescription + '\'' +
                ",\n studentsList=" + studentsList +
                ",\n trainer=" + trainer +
                ",\n dateOfBeginning='" + dateOfBeginning + '\'' +
                ",\n endDate='" + endDate + '\'' +
                ",\n dayOfTheCourses=" + dayOfTheCourses
                ;
    }
}
