package Milestone1;

import java.util.*;

/**
 * The TaskService class provides methods to manage Task objects, including adding, deleting, and updating tasks.
 * Character length limitations and null requirement are enforced in this class.
 */
public class TaskService {
    private final List<Task> listOfTasks = new ArrayList<>();

    // Generates a random unique task ID of length 10
    private String newTaskID() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    // Searches for a task by its ID
    public Task searchForTask(String tid) throws Exception {
        for (Task task : listOfTasks) {
            if (tid.equals(task.getTaskId())) {
                return task;
            }
        }
        throw new Exception("Task ID not found");
    }

    // Adds a new task with the given name and description
    public void addTask(String nm, String desc) {
        Task task = new Task(newTaskID(), nm, desc);
        listOfTasks.add(task);
    }

    // Deletes a task by its ID
    public void deleteTask(String tid) throws Exception {
        listOfTasks.remove(searchForTask(tid));
    }

    // Updates the name of a task by its ID
    public void updateName(String tid, String nm) throws Exception {
        searchForTask(tid).setName(nm);
    }

    // Updates the description of a task by its ID
    public void updateDescription(String tid, String desc) throws Exception {
        searchForTask(tid).setDescription(desc);
    }

    // Gets the list of all tasks
    public List<Task> getListOfTasks() {
        return listOfTasks;
    }
}
