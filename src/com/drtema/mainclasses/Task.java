package com.drtema.mainclasses;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dr.tema on 10.04.17.
 */
public class Task {
    private static int taskCounter = 0;
    private String taskName;
    private int taskID;
    private Integer courseID;
    private LinkedHashMap<String, Integer> marks = new LinkedHashMap<>();

    public Task(String taskName, Integer courseID) {
        this.taskName = taskName;
        this.courseID = courseID;
        this.taskID = ++taskCounter;
    }

    public int getTaskID() {
        return taskID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setMark(String studentName, Integer mark) {
        this.marks.put(studentName,mark);
    }

    @Override
    public String toString() {
        return
                "\ntaskName='" + taskName + '\'' +
                "\ntaskID=" + taskID +
                "\nmarks=" + marks
                ;
    }
}
