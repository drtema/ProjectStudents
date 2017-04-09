package com.drtema.daoimplemantations;

import com.drtema.daointerfaces.TrainersDAO;
import com.drtema.mainclasses.Trainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dr.tema on 08.04.17.
 */
public class TrainersList implements TrainersDAO {

    private static List<Trainer> trainersList = new ArrayList<>();

    @Override
    public void add(Trainer trainer) {

        trainersList.add(trainer);
    }

    @Override
    public Trainer find(int trainerID) {
        for (Trainer trainer:trainersList) {
            if (trainerID == trainer.getTrainerID()) {
                return trainer;
            }
        }
        return null;
    }

    @Override
    public void view(int trainerID) {
        if(find(trainerID) == null) {
            System.out.println("Course with id " + trainerID + " doesn’t exist");
        } else
            System.out.println(find(trainerID));
    }

    public static List<String> getTrainersFirstNames() {

        List<String> trainers1stNames = new ArrayList();
        for (Trainer course : trainersList) {
            trainers1stNames.add(course.getFirstName());
        }
        return trainers1stNames;
    }

    public static List<String> getTrainersLastNames() {

        List<String> trainersLastNames = new ArrayList();
        for (Trainer course : trainersList) {
            trainersLastNames.add(course.getLastName());
        }
        return trainersLastNames;
    }

}
