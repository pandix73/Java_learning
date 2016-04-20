package netdb.courses.softwarestudio.lab.main;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import netdb.courses.softwarestudio.lab.io.LowerCaseReader;

public class App {
	public static void main(String[] args) throws IOException {

		// Enter file names
		BufferedReader keyReader = new BufferedReader(new InputStreamReader(
				System.in));
		String inputFile, outputFile;
		System.out.println("Please enter input file name:");
		inputFile = keyReader.readLine();
		System.out.println("Please enter output file name:");
		outputFile = keyReader.readLine();

		BufferedReader br = new BufferedReader(new LowerCaseReader(new FileReader(inputFile)));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

		// TODO initialize the reader and writer here
		// remember to include your LowerCaseReader

		String temp;
		boolean newLine = false;
		while((temp = br.readLine()) != null){
			if(newLine == false)newLine = true;
			else bw.newLine();
			bw.write(temp);
		}
		// TODO use a while loop to read the string from the input file
		// and then write to the output file

		bw.flush();
		
		// TODO remember to flush your writer
		// using flush() method

		bw.close();
		br.close();
		
		// TODO close the reader and writer;

	}
}
