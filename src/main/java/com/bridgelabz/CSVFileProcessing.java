package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVFileProcessing {

    public static void writeToCSV(String file) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Rohith", 50000),
                new Employee(2, "Jayanth", 60000),
                new Employee(3, "Gopi", 55000)
        );

        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            writer.writeNext(new String[]{"ID", "Name", "Salary"});
            for (Employee emp : employees) {
                String[] row = {
                        String.valueOf(emp.getId()),
                        emp.getName(),
                        String.valueOf(emp.getSalary())
                };
                writer.writeNext(row);
            }
            System.out.println("CSV file written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            while ((row = reader.readNext()) != null) {
                System.out.println(String.join(" | ", row));
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file = "C:\\Users\\Rohith Kumar\\bridgelabz\\CSV_File_Processing\\src\\main\\java\\employees.csv";
        writeToCSV(file);
        System.out.println("\nReading back the CSV file:");
        readFromCSV(file);
    }
}
