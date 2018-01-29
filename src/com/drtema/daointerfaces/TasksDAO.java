package com.drtema.daointerfaces;

import com.drtema.mainclasses.Task;

/**
 * Created by Dr.tema on 10.04.17.
 */
public interface TasksDAO {
    Task add(Task task);
    Task find(Integer taskID);
    Task findByCourseID(Integer courseID);
    void close();
}
