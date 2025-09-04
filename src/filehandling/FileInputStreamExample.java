package filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExample {

    public static void main(String[] args) {

        FileInputStream fi = null;
        FileOutputStream fo = null;

        try {
            
            fi = new FileInputStream("C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\input.txt");

            
            fo = new FileOutputStream("C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\output.txt");

            int data;
            while ((data = fi.read()) != -1) {
                fo.write(data);              
                System.out.print((char) data); 
            }

            System.out.println("\nDone");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fi != null) fi.close();
                if (fo != null) fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
