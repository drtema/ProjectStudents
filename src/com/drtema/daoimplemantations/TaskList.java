package com.drtema.daoimplemantations;

import com.drtema.daointerfaces.TasksDAO;
import com.drtema.mainclasses.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dr.tema on 10.04.17.
 */
public class TaskList implements TasksDAO {
    private static List<Task> taskList = new ArrayList<>();

    @Override
    public Task add(Task task) {
        taskList.add(task);
        return find(task.getTaskID());
    }

    @Override
    public Task find(Integer taskID) throws NullPointerException {
        for (Task student:taskList) {
            if (taskID == student.getTaskID()) {
                return student;
            }
        }
        throw new NullPointerException("Task with id " + taskID + " doesn’t exist");
    }

    @Override
    public Task findByCourseID(Integer courseID) throws NullPointerException {
        for (Task task : taskList) {
            if (task.getCourseID() == courseID) {
                return task;
            }
        }
        throw new NullPointerException("Task with id " + courseID + " doesn’t exist");
    }

    @Override
    public void close() {
        taskList.clear();
    }

}
