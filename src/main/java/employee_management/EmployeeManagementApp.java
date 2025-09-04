package employee_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Street: ");
                    String street = sc.nextLine();
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    System.out.print("Enter Zipcode: ");
                    String zipcode = sc.nextLine();
                    Address addr = new Address(street, city, zipcode);

                    System.out.print("Enter number of projects: ");
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

                    Employee emp = new Employee(id, name, dept, addr, projects);
                    EmployeeService.addEmployee(emp);
                    break;

                case 2:
                    EmployeeService.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    EmployeeService.updateEmployee(uid, sc);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int did = sc.nextInt();
                    EmployeeService.deleteEmployee(did);
                    break;

                case 5:
                    System.out.print("Enter Employee ID to search: ");
                    int sid = sc.nextInt();
                    EmployeeService.searchEmployee(sid);
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
