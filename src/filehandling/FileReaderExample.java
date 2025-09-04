package filehandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReaderExample {

    public static void main(String[] args) {

        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\input.txt");
            fw = new FileWriter("C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\output.txt");

            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
                System.out.print((char) ch);
            }

            System.out.println("\nDone");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) fr.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
