package filehandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader2 {

    public static void main(String[] args) {

        try (
            FileReader fr = new FileReader("C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\input");
            FileWriter fw = new FileWriter("C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\output.txt")
        ) {
            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
                System.out.print((char) ch);
            }
            System.out.println("\nFile copied successfully using FileReader & FileWriter!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
