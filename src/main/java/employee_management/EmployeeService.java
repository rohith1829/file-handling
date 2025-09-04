package employee_management;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    private static final String FILE_PATH = "employees.json";
    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Employee> loadEmployees() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new ArrayList<>();
            return mapper.readValue(file, new TypeReference<List<Employee>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void saveEmployees(List<Employee> employees) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), employees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addEmployee(Employee emp) {
        List<Employee> employees = loadEmployees();
        for (Employee e : employees) {
            if (e.getEmployeeId() == emp.getEmployeeId()) {
                System.out.println("Employee ID already exists!");
                return;
            }
        }
        employees.add(emp);
        saveEmployees(employees);
        System.out.println("Employee added successfully!");
    }

    public static void viewEmployees() {
        List<Employee> employees = loadEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    public static void updateEmployee(int id, Scanner sc) {
        List<Employee> employees = loadEmployees();
        for (Employee e : employees) {
            if (e.getEmployeeId() == id) {
                System.out.print("Enter new name: ");
                e.setName(sc.nextLine());

                System.out.print("Enter new department: ");
                e.setDepartment(sc.nextLine());

                System.out.print("Enter new street: ");
                String street = sc.nextLine();
                System.out.print("Enter new city: ");
                String city = sc.nextLine();
                System.out.print("Enter new zipcode: ");
                String zipcode = sc.nextLine();
                e.setAddress(new Address(street, city, zipcode));

                System.out.print("How many projects to update? ");
                int count = sc.nextInt(); sc.nextLine();
                List<Project> projects = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    System.out.print("Enter Project ID: ");
                    int pid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Project Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();
                    projects.add(new Project(pid, pname, status));
                }
                e.setProjects(projects);

                saveEmployees(employees);
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void deleteEmployee(int id) {
        List<Employee> employees = loadEmployees();
        employees.removeIf(e -> e.getEmployeeId() == id);
        saveEmployees(employees);
        System.out.println("Employee deleted successfully!");
    }

    public static void searchEmployee(int id) {
        List<Employee> employees = loadEmployees();
        for (Employee e : employees) {
            if (e.getEmployeeId() == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
