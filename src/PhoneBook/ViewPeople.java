package PhoneBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewPeople extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPeople frame = new ViewPeople();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public ViewPeople() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel title = new JLabel("Phone Book");
		title.setFont(new Font("Tahoma", Font.PLAIN, 51));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(title);
		
		JPanel peoplePanel = new JPanel();
		peoplePanel.setBorder(new LineBorder(Color.BLACK, 10, true));
		addPeopleFromFile(peoplePanel);
		contentPane.add(peoplePanel);
		GridBagLayout gbl_peoplePanel = new GridBagLayout();
		gbl_peoplePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_peoplePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_peoplePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_peoplePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		peoplePanel.setLayout(gbl_peoplePanel);
		
		
		JButton returnToMainPageButton = new JButton("Return to Main Page");
		contentPane.add(returnToMainPageButton);
		returnToMainPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				VisualPhoneBook vpb = new VisualPhoneBook();
				vpb.getFrame().setVisible(true);
			}
		});
		
	}
	
	public void addPeopleFromFile(JPanel panel) throws FileNotFoundException {
		PhoneBook ph = new PhoneBook();
		ph.loadPhoneBook();
		ArrayList<Person> peopleInBook = ph.getPeople();
		for(Person person: peopleInBook) {
			JLabel personLabel = new JLabel(person.getfirstName() + " " + person.getlastName());
			//Setting the border
			Border raisedbevel = BorderFactory.createRaisedBevelBorder();
			Border loweredbevel = BorderFactory.createLoweredBevelBorder();
			Border compoundBorder;
			compoundBorder = BorderFactory.createCompoundBorder(
					  raisedbevel, loweredbevel);
			personLabel.setBorder(compoundBorder);
			panel.add(personLabel);			
			System.out.println(person);
		}
		
		
		
	}
}
