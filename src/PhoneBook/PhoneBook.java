package PhoneBook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
	ArrayList<Person> thePeople = new ArrayList<Person>();
	private Scanner reader;
	
	
	public void add(Person p) throws IOException {
		this.thePeople.add(p);
		writeToPhoneBook();
	}
	public ArrayList<Person> getPeople(){
		return this.thePeople;
	}
	
	private void printPPL() {
//		System.out.println("PEOPLE IN PHONEBOOK");
		for(Person p : thePeople) {
			System.out.println(p);
		}
	}
	//Loading the phoneBook
	public void loadPhoneBook () throws FileNotFoundException {
		File file = new File("src/phoneBookText/PHONEBOOK.txt");
		reader = new Scanner(file);
		
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
			if(line.isEmpty()) {
				break;
			}
			String[] newLine = line.split(" ");
			Person person = new Person(newLine[0],newLine[1],newLine[2],newLine[3],newLine[4],newLine[5],newLine[6],newLine[7],newLine[8]);
			thePeople.add(person);	
			
		}
		
		
		//Testing Purposes
		printPPL();
		reader.close();
	}
	
	public void writeToPhoneBook() throws IOException {
		FileWriter writer = new FileWriter("src/phoneBookText/PHONEBOOK.txt", true);
		for(Person p: thePeople) {
			writer.write(p.getWriteFormat());
		}
		
		printPPL();		
		writer.close();
	}

}
