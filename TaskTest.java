package Tests;

/* TaskTest Class contains JUnit tests for the Task class. 
 * It tests the getters, setters, length validation, and null requirement of the taskId, name, and description fields.   */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Milestone1.Task;


public class TaskTest {

    @Test
    public void testTaskCreation() {
        // Test creating a valid task
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        // Test creating a task with an invalid ID
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task Name", "Task Description");
        });
        assertEquals("Invalid task id - null or length > 10", exception.getMessage());
    }

    @Test
    public void testInvalidName() {
        // Test creating a task with an invalid name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name That Is Way Too Long", "Task Description");
        });
        assertEquals("Invalid name - null or length > 20", exception.getMessage());
    }

    @Test
    public void testInvalidDescription() {
        // Test creating a task with an invalid description
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name", "This description is way too long and exceeds the fifty character limit.");
        });
        assertEquals("Invalid description - null or length > 50", exception.getMessage());
    }

    @Test
    public void testSetters() {
        // Test setting valid values
        Task task = new Task("1234567890", "Task Name", "Task Description");
        task.setTaskId("0987654321");
        assertEquals("0987654321", task.getTaskId());
        task.setName("New Task Name");
        assertEquals("New Task Name", task.getName());
        task.setDescription("New Task Description");
        assertEquals("New Task Description", task.getDescription());
    }

    @Test
    public void testInvalidSetters() {
        // Test setting invalid values
        Task task = new Task("1234567890", "Task Name", "Task Description");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskId("12345678901");
        });
        assertEquals("Invalid task ID - null or length > 10", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setName("Task Name That Is Way Too Long");
        });
        assertEquals("Invalid name - null or length > 20", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is way too long and exceeds the fifty character limit.");
        });
        assertEquals("Invalid description - null or length > 50", exception.getMessage());
    }
}