package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AggregatingReportData {

    public static void main(String[] args) {

        String inputFile = "C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\logs.txt";
        String outputFile = "C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\log_summary.txt";

        Map<String, Integer> logCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 3); 
                if (parts.length < 2) continue;
                String logLevel = parts[1].trim();

                logCount.put(logLevel, logCount.getOrDefault(logLevel, 0) + 1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : logCount.entrySet()) {
                bw.write(entry.getKey() + ": " + entry.getValue());
                bw.newLine();
            }
            System.out.println("Log summary written to file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
