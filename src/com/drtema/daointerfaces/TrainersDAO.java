package com.drtema.daointerfaces;

import com.drtema.mainclasses.Trainer;

/**
 * Created by Dr.tema on 08.04.17.
 */
public interface TrainersDAO {
    void add(Trainer trainer);
    Trainer find(int trainerID);
    void view(int trainerID);

}
