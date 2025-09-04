package com.bridgelabz;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JSONFileProcessing {

    public static void writeToJSON(String file) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Rohith", 50000),
                new Employee(2, "Jayanth", 60000),
                new Employee(3, "Gopi", 55000)
        );

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(file), employees);
            System.out.println("JSON file written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromJSON(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Employee> employees = mapper.readValue(new File(filePath), new TypeReference<List<Employee>>() {});
            for (Employee emp : employees) {
                System.out.println(emp.getId() + " | " + emp.getName() + " | " + emp.getSalary());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file = "C:\\Users\\Rohith Kumar\\bridgelabz\\JSON_File_Processing\\employees.json";
        writeToJSON(file);
        System.out.println("\nReading back the JSON file:");
        readFromJSON(file);
    }
}
