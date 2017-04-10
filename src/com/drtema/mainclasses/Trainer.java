package com.drtema.mainclasses;

import com.drtema.daointerfaces.CoursesDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dr.tema on 08.04.17.
 */
public class Trainer {
    private static int trainersCounter = 0;
    private final int trainerID;
    private final String firstName;
    private final String lastName;
    private List<Integer> coursesID = new ArrayList();

    public Trainer(String firstName, String lastName,Integer... coursesID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.trainerID = ++trainersCounter;
        for (Integer integer : coursesID) {
            this.coursesID.add(integer);
        }
    }

    public void setCourse(Integer courseID) {
        this.coursesID.add(courseID);
    }

    public List<Integer> getCoursesID() {
        return coursesID;
    }

    @Override
    public String toString() {
        return  "\ntrainerID=" + trainerID +
                "\nfirstName='" + firstName + '\'' +
                "\nlastName='" + lastName + '\''
                ;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTrainerID() {
        return trainerID;
    }

}
