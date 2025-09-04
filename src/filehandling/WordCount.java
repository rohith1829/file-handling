package filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\text_file.txt";
        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
            System.out.println("Total words in file: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
