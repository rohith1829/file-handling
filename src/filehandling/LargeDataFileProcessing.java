package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LargeDataFileProcessing {
public static void main(String[] args) {
	String file1="C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\transactions.txt";
	String file2="C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\filtered.txt";
	double tprice=1000;
	try(BufferedReader fi=new BufferedReader(new FileReader(file1));BufferedWriter fo=new BufferedWriter(new FileWriter(file2)))
	{
		String line;
		while((line=fi.readLine())!=null) {
			String[] words=line.split(",");
			double price=Double.parseDouble(words[2]);
			if(price>=tprice) {
				fo.write(line);
				fo.newLine();
			}
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	


}
}
