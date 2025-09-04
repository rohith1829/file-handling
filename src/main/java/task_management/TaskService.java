package task_management;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TaskService {
    private static final String FILE_NAME = "tasks.json";
    private final ObjectMapper mapper = new ObjectMapper();

    private List<Task> readTasks() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return new ArrayList<>();
            return mapper.readValue(file, new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void writeTasks(List<Task> tasks) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_NAME), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTask(Scanner sc) {
        List<Task> tasks = readTasks();

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Task t : tasks) {
            if (t.getTaskId() == id) {
                System.out.println("Task ID must be unique!");
                return;
            }
        }

        System.out.print("Enter Description: ");
        String desc = sc.nextLine();
        System.out.print("Enter Due Date: ");
        String due = sc.nextLine();

        tasks.add(new Task(id, desc, due, false));
        writeTasks(tasks);
        System.out.println("Task added successfully.");
    }

    public void viewTasks() {
        List<Task> tasks = readTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    public void updateTask(Scanner sc) {
        List<Task> tasks = readTasks();
        System.out.print("Enter Task ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Task t : tasks) {
            if (t.getTaskId() == id) {
                System.out.print("Enter new Description: ");
                t.setDescription(sc.nextLine());
                System.out.print("Enter new Due Date: ");
                t.setDueDate(sc.nextLine());

                writeTasks(tasks);
                System.out.println("Task updated successfully.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(Scanner sc) {
        List<Task> tasks = readTasks();
        System.out.print("Enter Task ID to delete: ");
        int id = sc.nextInt();

        boolean removed = tasks.removeIf(t -> t.getTaskId() == id);
        if (removed) {
            writeTasks(tasks);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void markTaskCompleted(Scanner sc) {
        List<Task> tasks = readTasks();
        System.out.print("Enter Task ID to mark completed: ");
        int id = sc.nextInt();

        for (Task t : tasks) {
            if (t.getTaskId() == id) {
                t.setCompleted(true);
                writeTasks(tasks);
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}
