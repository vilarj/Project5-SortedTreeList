package project5Tree;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import encoding.Decoder;


public class testing {

	public static void main(String[] args) {
		Decoder message = new Decoder("encoded.txt");
		System.out.println("===== Message =====");
		System.out.println(message);
		System.out.println("\n===== End of the message =====");

		// ====================================================
		SortedTreeList <Name> nameDirectory = new SortedTreeList<>();

		try (FileReader file = new FileReader("names.txt")) {
			FileWriter fout = new FileWriter("sortedNames.txt");
			//int counter = 0;

			Scanner read = new Scanner (file);

			while (read.hasNext()) {
				String fullName = read.nextLine();

				nameDirectory.addEntry(new Name(fullName));
				//fout.write(nameDirectory.getEntry(counter));
				//counter++;

				fout.write(fullName);
				int counter = 0;

				Scanner read = new Scanner (file);

				while (read.hasNext()) {
					String fullName = read.nextLine();

					nameDirectory.addEntry(new Name(fullName));
					fout.write(nameDirectory.remove.toString() + "\n");
					counter++;

					//fout.write(fullName + "\n");
				}

				// Closing the Scanner and FileWriter objects
				read.close();
				fout.close();
			}

			catch(IOException ex) {System.out.print("File not found " + ex);}
		}
	}
