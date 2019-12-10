package encoding;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import project5Tree.SortedTreeList;

public class Decoder {
	private SortedTreeList<Packet> message;

	public Decoder(String file) {
		message = new SortedTreeList<>();
		readFile(file);
	}

	private void readFile(String file) {
		try (FileReader fin = new FileReader("encoded.txt")) {
			Scanner read = new Scanner(fin);
			while (read.hasNext()) {
				char[] line = read.nextLine().toCharArray();
				if (line[1] > 32) { // 32 space in ascii table
					int number = ((int) line[0] - 48) * 10 + (int) line[1] - 48;
					message.addEntry(new Packet(number, line[3], line[4], line[5]));
				} else {
					message.addEntry(new Packet((int) line[0] - 48, line[2], line[3], line[4]));
				}
			}
			read.close();
		} catch (IOException e) {
			System.out.println("The file was not found");
			System.exit(2);
		}
	}

	public String toString() {
		String data = "";
		for (Object p : message.toArray()) {
			data += ((Packet) p).getMsg();
		}
		return data;		
	}

}
