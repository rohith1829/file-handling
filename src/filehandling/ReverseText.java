package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseText {
public static void main(String[] args) {
	String file1="C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\input.txt";
	String file2="C:\\Users\\Rohith Kumar\\bridgelabz\\File_Handling\\src\\filehandling\\reversed.txt";
	try(BufferedReader fi=new BufferedReader(new FileReader(file1));
			BufferedWriter fo=new BufferedWriter(new FileWriter(file2))){
		StringBuilder input=new StringBuilder();
		String line;
		while((line=fi.readLine())!=null){
			input.append(line).append("\n");
			
			
		}
		if(input.charAt(input.length()-1)=='\n')
			input.deleteCharAt(input.length()-1);
		
		input.reverse();
		fo.write(input.toString());
		
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
