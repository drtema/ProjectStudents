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
    public int getSize() {
        return trainersList.size();
    }

    @Override
    public void add(Trainer trainer) {
        trainersList.add(trainer);
    }

    @Override
    public Trainer find(int trainerID) throws NullPointerException{
        for (Trainer trainer:trainersList) {
            if (trainerID == trainer.getTrainerID()) {
                return trainer;
            }
        }
        throw new NullPointerException("Trainer with id " + trainerID + " doesn’t exist");
    }

    @Override
    public void view(int trainerID) {
        try {
            System.out.println(find(trainerID));
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void close() {
        trainersList.clear();
    }


}
