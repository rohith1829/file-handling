package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExample {

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(
                    new FileReader("C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\input.txt"));
            bw = new BufferedWriter(
                    new FileWriter("C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\output.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                System.out.println(line);
            }
            System.out.println("\nDone");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
