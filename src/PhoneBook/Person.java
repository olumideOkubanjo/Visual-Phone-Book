package PhoneBook;

//FirstName
//last Name
//Phone Number(Home and work and any other numbers to add)
//Birthday
//EmailAdress
//StreetAdress
//Where individual Lives
//Spouces's name
//(Optional: Add Picture)



/*
This program must Display a Page with two Buttons at first
[Add New Person]
[Show PhoneBook]


Click [Add new Person]:
	Display a form with:
		FirstName
		last Name
		Birthday
		EmailAdress
		StreetAdress
		City
		Phone Number(Home and work and any other numbers to add)
		(Optional: Add Picture)


		 Click Button[Save]:
		 	Clear Form above and add person to Phone Book
		 	show Button that has [Phone Book] Run the show phoneBook Code
		 Click Button[Cancel]:
		 Re run the Home Page and Clear the Form
		 	if user Entered cancel from the edit page then make sure the original Person isn't edited

Click [Show PhoneBook]
Load List of People from a file and to the program on a new page slightly bigger than
the main page
		if click [Person] box:
			Display Specific Person in a new Page and list all information entered about the Person
			(Optional add Edit Button to edit the Person and re add them back to the list)
*/
public class Person {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String birthday;//(MM/DD/YYYY);
	private String emailAdress;
	private String StreetAdress;
	private String WhereLives;//(Edmonton, Alberta)
	private String Spouce;
	private String sex;
	
	public Person(String fn,String ln,String pn,String birth,String email,String streetAdress,String whereLives,String Spouce,String sex) {
		this.firstName = fn;
		this.lastName = ln;
		this.phoneNumber = pn;
		this.birthday = birth;
		this.emailAdress = email;
		this.StreetAdress = streetAdress;
		this.WhereLives = whereLives;
		this.Spouce = Spouce;
		this.sex = sex;
	}
	
	
	public String getfirstName() {return this.firstName;}
	public String getlastName() {return this.lastName;}
	public String getphoneNumber() {return this.phoneNumber;}
	public String getbirthday() {return this.birthday;}
	public String getemailAdress() {return this.emailAdress;}
	public String getStreetAdress() {return this.StreetAdress;}
	public String getWhereLives() {return this.WhereLives;}
	public String getSpouce() {return this.Spouce;}
	
	//Editing Purposes 
	@Override
	public String toString() {
		return String.format(" \n\n This is %s %s ,\n PhoneNumber : %s \n BirthDay: %s \n Email Adress: %s \nStreet Adress: %s  \nHe Lives in %s \n He is Married to %s \n Sex : %s ", this.firstName, this.lastName, this.phoneNumber, this.birthday, this.emailAdress, this.StreetAdress, this.WhereLives, this.Spouce, this.sex);
	}
	
	public String getWriteFormat() {
		return  firstName + " " + lastName + " " + phoneNumber + " " + birthday + " " + emailAdress + " " + StreetAdress + " " + WhereLives + " " + Spouce + " " +sex + "\n";
	}
	
}
