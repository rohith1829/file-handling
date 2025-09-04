package filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStream2 {

    public static void main(String[] args) {

        try (
            FileInputStream fi = new FileInputStream("C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\input.txt");
            FileOutputStream fo = new FileOutputStream("C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\output.txt")
        ) {
            int data;
            while ((data = fi.read()) != -1) {
                fo.write(data);
                System.out.print((char) data);
            }
            System.out.println("\nDone");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
