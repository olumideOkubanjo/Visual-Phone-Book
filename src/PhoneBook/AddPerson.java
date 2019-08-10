package PhoneBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

//When Save is clicked Show a Message Dialouge That confims that all the ninformation  has been saved
//Change Sed to be a radio Button

//Make All the varibles private
public class AddPerson extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField phoneNumberField;
	private JTextField birthDayField;
	private JTextField emailAdressField;
	private JTextField streetAdressField;
	private JTextField residenceField;
	private JTextField spouceField;
	private JTextField sexField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPerson frame = new AddPerson();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddPerson() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 392);
		contentPane = new JPanel();
		contentPane.setToolTipText("Click to Cancel");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel firstName = new JLabel("First Name : ");
		contentPane.add(firstName);

		firstNameField = new JTextField();
		contentPane.add(firstNameField);
		firstNameField.setColumns(10);

		JLabel lastName = new JLabel("Last Name : ");
		contentPane.add(lastName);

		lastNameField = new JTextField();
		contentPane.add(lastNameField);
		lastNameField.setColumns(10);

		JLabel phoneNumber = new JLabel("Phone Number: ");
		contentPane.add(phoneNumber);

		phoneNumberField = new JTextField();
		contentPane.add(phoneNumberField);
		phoneNumberField.setColumns(10);

		JLabel birthday = new JLabel("Birthday : ");
		contentPane.add(birthday);

		birthDayField = new JTextField();
		contentPane.add(birthDayField);
		birthDayField.setColumns(10);

		JLabel emailAddress = new JLabel("Email Address (Valid) : ");
		contentPane.add(emailAddress);

		emailAdressField = new JTextField();
		contentPane.add(emailAdressField);
		emailAdressField.setColumns(10);

		JLabel streetAdrdess = new JLabel("Street Address: ");
		contentPane.add(streetAdrdess);

		streetAdressField = new JTextField();
		contentPane.add(streetAdressField);
		streetAdressField.setColumns(10);

		JLabel residenceLocation = new JLabel("Residence (Edmonton, AB) : ");
		contentPane.add(residenceLocation);

		residenceField = new JTextField();
		contentPane.add(residenceField);
		residenceField.setColumns(10);

		JLabel spouce = new JLabel("Spouce : ");
		contentPane.add(spouce);

		spouceField = new JTextField();
		contentPane.add(spouceField);
		spouceField.setColumns(10);

		JLabel sex = new JLabel("Sex : ");
		contentPane.add(sex);

		sexField = new JTextField();
		contentPane.add(sexField);
		sexField.setColumns(10);

		JLabel label_6 = new JLabel("");
		contentPane.add(label_6);

		JLabel label_11 = new JLabel("");
		contentPane.add(label_11);

		Button cancelButton = new Button("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Going Back to the Main Page
				clearFields();
				VisualPhoneBook vpb = new VisualPhoneBook();
				vpb.getFrame().setVisible(true);
				contentPane.setVisible(false);
				
				
			}
		});
		cancelButton.setForeground(new Color(0, 191, 255));
		cancelButton.setBackground(new Color(255, 69, 0));
		contentPane.add(cancelButton);

		Button saveButton = new Button("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//New PhoneBoook
				PhoneBook pb = new PhoneBook();
				try {
					pb.add(new Person(firstNameField.getText(),lastNameField.getText(),phoneNumberField.getText(),birthDayField.getText(),emailAdressField.getText(),streetAdressField.getText(),residenceField.getText(),spouceField.getText(),sexField.getText()));
					clearFields();
					ViewPeople vp = new ViewPeople();
					vp.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		});
		saveButton.setBackground(new Color(105, 105, 105));
		saveButton.setForeground(new Color(255, 255, 255));
		contentPane.add(saveButton);
	}
	
	public void clearFields() {
		firstNameField = new JTextField();
		lastNameField= new JTextField();
		phoneNumberField = new JTextField();
		birthDayField=new JTextField();
		emailAdressField=new JTextField();
		streetAdressField=new JTextField();
		residenceField=new JTextField();
		spouceField=new JTextField();
		sexField=new JTextField();
	}

}
