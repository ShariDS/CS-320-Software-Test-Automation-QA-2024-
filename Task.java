package Milestone1;

/**
 * The Task class represents a task with a unique ID, name, and description.
 * The task objects (taskID, name, and description) are given character length limitations and cannot be null.
 */
public class Task {
    private String taskId; // Limit 10 characters
    private String name; // Limit 20 characters
    private String description; // Limit 50 characters

    /**
     * Constructs a Task object with the given ID, name, and description.
     * @param tid the unique ID of the task, must be non-null and <= 10 characters
     * @param nm the name of the task, must be non-null and <= 20 characters
     * @param desc the description of the task, must be non-null and <= 50 characters
     */
    public Task(String tid, String nm, String desc) {
        if (tid == null || tid.length() > 10) {
            throw new IllegalArgumentException("Invalid task id - null or length > 10");
        }
        if (nm == null || nm.length() > 20) {
            throw new IllegalArgumentException("Invalid name - null or length > 20");
        }
        if (desc == null || desc.length() > 50) {
            throw new IllegalArgumentException("Invalid description - null or length > 50");
        }
        this.taskId = tid;
        this.name = nm;
        this.description = desc;
    }

    // Getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setTaskId(String tid) {
        if (tid == null || tid.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID - null or length > 10");
        }
        this.taskId = tid;
    }

    public void setName(String nm) {
        if (nm == null || nm.length() > 20) {
            throw new IllegalArgumentException("Invalid name - null or length > 20");
        }
        this.name = nm;
    }

    public void setDescription(String desc) {
        if (desc == null || desc.length() > 50) {
            throw new IllegalArgumentException("Invalid description - null or length > 50");
        }
        this.description = desc;
    }
}