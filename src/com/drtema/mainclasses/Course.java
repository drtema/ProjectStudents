package com.drtema.mainclasses;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;


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
    private LocalDate startDate;
    private LocalDate endDate;
    private List<DayOfWeek> dayOfTheCourses = new LinkedList();
    private SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");

    public Course(
            String courseName,
            String courseDescription,
            String startDate,
            String endDate,
            String... dayOfTheCourses
    ) {
        this.courseID = ++coursesCounter;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.startDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        this.endDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        for (String x:dayOfTheCourses) {
            this.dayOfTheCourses.add(DayOfWeek.valueOf(x));
        }
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    @Override
    public String toString() {
        return
                " courseID=" + courseID +
                ",\n courseName='" + courseName + '\'' +
                ",\n courseDescription='" + courseDescription + '\'' +
                ",\n studentsList=" + studentsList +
                ",\n trainer=" + trainer +
                ",\n startDate='" + startDate + '\'' +
                ",\n endDate='" + endDate+ '\'' +
                ",\n dayOfTheCourses=" + dayOfTheCourses
                ;
    }
}
