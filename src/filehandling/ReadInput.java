package filehandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadInput {
public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in);
	String str=sc.nextLine();
	try (FileWriter fo = new FileWriter("C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\user_input.txt")) {
		fo.write(str);
	}
	sc.close();
	
			
}
}
