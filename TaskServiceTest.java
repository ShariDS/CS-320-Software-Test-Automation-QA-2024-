package Tests;

/* The TaskServiceTest class contains JUnit tests for the TaskService class. 
 * It tests the addTask(), deleteTask(), updateName(), and updateDescription() methods,
 * verifying the expected behavior and handling of exceptions.  */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Milestone1.Task;
import Milestone1.TaskService;
import java.util.List;


public class TaskServiceTest {

    @Test
    public void testAddTask() {
        // Test adding a task
        TaskService service = new TaskService();
        service.addTask("Task Name", "Task Description");
        assertEquals(1, service.getListOfTasks().size());
    }

    @Test
    public void testDeleteTask() throws Exception {
        // Test deleting a task
        TaskService service = new TaskService();
        service.addTask("Task Name", "Task Description");
        Task task = service.getListOfTasks().get(0);
        service.deleteTask(task.getTaskId());
        assertEquals(0, service.getListOfTasks().size());
    }

    @Test
    public void testUpdateName() throws Exception {
        // Test updating task name
        TaskService service = new TaskService();
        service.addTask("Task Name", "Task Description");
        Task task = service.getListOfTasks().get(0);
        service.updateName(task.getTaskId(), "New Task Name");
        assertEquals("New Task Name", task.getName());
    }

    @Test
    public void testUpdateDescription() throws Exception {
        // Test updating task description
        TaskService service = new TaskService();
        service.addTask("Task Name", "Task Description");
        Task task = service.getListOfTasks().get(0);
        service.updateDescription(task.getTaskId(), "New Task Description");
        assertEquals("New Task Description", task.getDescription());
    }

    @Test
    public void testGetListOfTasks() {
        // Test getting the list of tasks
        TaskService service = new TaskService();
        service.addTask("Task Name", "Task Description");
        List<Task> tasks = service.getListOfTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    public void testSearchForTask() throws Exception {
        // Test searching for a task
        TaskService service = new TaskService();
        service.addTask("Task Name", "Task Description");
        Task task = service.getListOfTasks().get(0);
        Task foundTask = service.searchForTask(task.getTaskId());
        assertEquals(task, foundTask);
    }

    @Test
    public void testSearchForTaskNotFound() {
        // Test searching for a task that does not exist
        TaskService service = new TaskService();
        Exception exception = assertThrows(Exception.class, () -> {
            service.searchForTask("nonexistent");
        });
        assertEquals("Task ID not found", exception.getMessage());
    }
}